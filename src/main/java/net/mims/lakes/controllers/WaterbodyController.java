/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.mims.lakes.controllers;

import java.util.List;
import net.mims.lakes.domain.Waterbody;
import net.mims.lakes.services.WaterbodyService;

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
public class WaterbodyController {
    @Autowired
    private WaterbodyService waterbodyService;
 
    @GetMapping("/waterbody")
    public List<Waterbody> getWaterbody() {
        return waterbodyService.fetchWaterbodiesList();
      
    }
 
    @PostMapping("/waterbody")
    public Waterbody addNewWaterbody(@RequestBody Waterbody waterbody) {       
        return waterbodyService.saveWaterbody(waterbody);
    }
 
    @GetMapping("/waterbody/{id}")
    public Waterbody getOneWaterbody(@PathVariable Long id) {
        return waterbodyService.getById(id);
                //.orElseThrow(() -> new WaterbodyNotFoundException(id));
    }
    
    @PutMapping("/waterbody/{id}")
    Waterbody replaceWaterbody(@RequestBody Waterbody newWaterbody, @PathVariable Long id) {
    
    //return waterbodyService.getById(id)
            //.map(waterbody -> {
        Waterbody waterbody = new Waterbody();
        waterbody.setId(newWaterbody.getId()); 
        waterbody.setLakeName(newWaterbody.getLakeName());
        waterbody.setStateName(newWaterbody.getStateName());
        return waterbodyService.saveWaterbody(waterbody);
     // })
      //.orElseGet(() -> {
        //return waterbodyService.saveWaterbody(newWaterbody);
      //});
  }

 
    @GetMapping("/deleteWaterbody/{id}")
    public void deleteThroughId(@PathVariable(value = "id") long id) {
        waterbodyService.deleteWaterbodyById(id);
        
 
    }
    
}
