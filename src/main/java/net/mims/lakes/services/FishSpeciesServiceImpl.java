/*
 * Click nbfs://nbhost/SystemFileSystem/TfishSpecieslates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/TfishSpecieslates/Classes/Class.java to edit this tfishSpecieslate
 */
package net.mims.lakes.services;

import java.util.List;
import java.util.Optional;
import net.mims.lakes.domain.FishSpecies;
import net.mims.lakes.repositories.FishSpeciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author leroy
 */
@Service
public class FishSpeciesServiceImpl implements FishSpeciesService{
   
    @Autowired 
    private FishSpeciesRepository fishSpeciesRepository;
 
   public List<FishSpecies> getAllFishSpecies()
    {
        return fishSpeciesRepository.findAll();
    }
 
    public void save(FishSpecies fishSpecies)
    {
        fishSpeciesRepository.save(fishSpecies);
    }
 
  public FishSpecies getById(Long id)
    {
        Optional<FishSpecies> optional = fishSpeciesRepository.findById(id);
        FishSpecies fishSpecies = null;
        if (optional.isPresent())
            fishSpecies = optional.get();
        else
            throw new RuntimeException(
                "FishSpecies not found for id : " + id);
        return fishSpecies;
    }
 
   public void deleteFishSpeciesById(Long fishSpeciesId) {
        fishSpeciesRepository.deleteById(fishSpeciesId);
    }

    @Override
    public FishSpecies saveFishSpecies(FishSpecies fishSpecies) {
        fishSpeciesRepository.save(fishSpecies);
        return fishSpecies;
    }

    @Override
    public List<FishSpecies> fetchFishSpeciesList() {
        return fishSpeciesRepository.findAll();
    }

    @Override
    public FishSpecies updateFishSpecies(FishSpecies fishSpecies, Long fishSpeciesId) {
        fishSpeciesRepository.save(fishSpecies);
        return getById(fishSpeciesId);
        
    }

   
}