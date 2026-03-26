package net.mims.lakes.entity;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import net.mims.lakes.data.HibernateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WriteMinnDataToDatabase {

	Session session = null;
	Transaction transaction = null;
         final private static Logger logger = LoggerFactory.getLogger(WriteMinnDataToDatabase.class);

	public WriteMinnDataToDatabase(ArrayList<net.mims.lakes.entity.Waterbody> waterbodies) {

		// HashMap<String, FishSpecies> fishHashMap =
		// createFishSpeciesHashMap(waterbodies);

		try {

			this.session = HibernateUtil.getSessionFactory().openSession();
			this.transaction = session.beginTransaction();

			HashMap<String, net.mims.lakes.entity.FishSpecies> fishHashMap = createFishSpeciesHashMap(waterbodies);

			logger.info(Integer.toString(fishHashMap.size()));

			for (net.mims.lakes.entity.Waterbody waterbody : waterbodies) {
				
				HashSet<FishSpecies> hashedFish = new HashSet<FishSpecies>(); 

				for (FishSpecies fishSpecies : waterbody.getFishSpeciesList()){
					
					hashedFish.add(fishHashMap.get(fishSpecies.getFishTypeName()));
					

				}
				
				waterbody.getFishSpeciesList().clear();
				waterbody.addFishSpeciesList(hashedFish);

				this.session.persist(waterbody);

			}
		 this.transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				logger.info("Transaction is being rolled back.");
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {

			// if (session != null) {
			// session.close();
			// }
		}

		// HibernateUtil.shutdown();
		return;
	}

	HashMap<String, FishSpecies> createFishSpeciesHashMap(ArrayList<Waterbody> waterbodies) {

		HashMap<String, FishSpecies> fishHashMap = new HashMap<String, FishSpecies>();

		// this.session = HibernateUtil.getSessionFactory().openSession();
		// this.transaction = session.beginTransaction();

		for (Waterbody waterbody : waterbodies) {

			for (FishSpecies fishSpecies : waterbody.getFishSpeciesList()) {

				if (!fishHashMap.containsKey(fishSpecies.getFishTypeName()))

					fishHashMap.put(fishSpecies.getFishTypeName(), fishSpecies);

			}

		}

		return fishHashMap;

	}

}
