/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.mims.lakes.controllers;

import java.util.List;
import net.mims.lakes.domain.FishSpecies;
import net.mims.lakes.exceptions.FishSpeciesNotFoundException;
import net.mims.lakes.services.FishSpeciesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class FishSpeciesController {
    @Autowired
    private FishSpeciesService fishSpeciesService;
 
    @GetMapping("/fishSpecies")
    public List<FishSpecies> getFishSpecies() {
        return fishSpeciesService.fetchFishSpeciesList();
      
    }
 
    @PostMapping("/fishSpecies")
    public FishSpecies addNewFishSpecies(@RequestBody FishSpecies fishSpecies) {       
        return fishSpeciesService.saveFishSpecies(fishSpecies);
    }
 
    @GetMapping("/fishSpecies/{id}")
    public FishSpecies getOneFishSpecies(@PathVariable Long id) {
        return fishSpeciesService.getById(id);
                //.orElseThrow(() -> new FishSpeciesNotFoundException(id));
    }
    
    @PutMapping("/fishSpecies/{id}")
    FishSpecies replaceFishSpecies(@RequestBody FishSpecies newFishSpecies, @PathVariable Long id) {
    
    //return fishSpeciesService.getById(id)
            //.map(fishSpecies -> {
        FishSpecies fishSpecies = new FishSpecies();
        fishSpecies.setId(newFishSpecies.getId()); 
        fishSpecies.setFishTypeName(newFishSpecies.getFishTypeName());
        fishSpecies.setImagePath(newFishSpecies.getImagePath());
        return fishSpeciesService.saveFishSpecies(fishSpecies);
     // })
      //.orElseGet(() -> {
        //return fishSpeciesService.saveFishSpecies(newFishSpecies);
      //});
  }

 
    @GetMapping("/deleteFishSpecies/{id}")
    public void deleteThroughId(@PathVariable(value = "id") long id) {
        fishSpeciesService.deleteFishSpeciesById(id);
        
 
    }
    
}
