/*
 * Click nbfs://nbhost/SystemFileSystem/Twaterbodylates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Twaterbodylates/Classes/Class.java to edit this twaterbodylate
 */
package net.mims.lakes.services;

import java.util.List;
import java.util.Optional;
import net.mims.lakes.domain.Waterbody;
import net.mims.lakes.repositories.WaterbodyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author leroy
 */
@Service
public class WaterbodyServiceImpl implements WaterbodyService{
   
    @Autowired 
    private WaterbodyRepository waterbodyRepository;
 
   public List<Waterbody> getAllWaterbodies()
    {
        return waterbodyRepository.findAll();
    }
 
    public void save(Waterbody waterbody)
    {
        waterbodyRepository.save(waterbody);
    }
 
  public Waterbody getById(Long id)
    {
        Optional<Waterbody> optional = waterbodyRepository.findById(id);
        Waterbody waterbody = null;
        if (optional.isPresent())
            waterbody = optional.get();
        else
            throw new RuntimeException(
                "Waterbody not found for id : " + id);
        return waterbody;
    }
 
   public void deleteWaterbodyById(Long waterbodyId) {
        waterbodyRepository.deleteById(waterbodyId);
    }

    @Override
    public Waterbody saveWaterbody(Waterbody waterbody) {
        waterbodyRepository.save(waterbody);
        return waterbody;
    }

    @Override
    public List<Waterbody> fetchWaterbodiesList() {
        return waterbodyRepository.findAll();
    }

    @Override
    public Waterbody updateWaterbody(Waterbody waterbody, Long waterbodyId) {
        waterbodyRepository.save(waterbody);
        return getById(waterbodyId);
        
    }

   
}