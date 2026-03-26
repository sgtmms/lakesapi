/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.mims.lakes.controllers;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import net.mims.lakes.entity.Greeting;
import net.mims.lakes.entity.Waterbody;
import net.mims.lakes.services.WaterbodyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory; 
@RestController
@CrossOrigin
public class WaterbodyController {
    @Autowired
    private WaterbodyService waterbodyService;
    
    private static final String template = "Hello, %s!";

    private final AtomicLong counter = new AtomicLong();
    final private static Logger logger = LoggerFactory.getLogger(WaterbodyController.class);

    @GetMapping(value="/greeting")
    public Greeting greeting(@RequestParam(required = false, defaultValue = "World") String name) {
		logger.info("==== get greeting ====");
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
 
    @GetMapping(value="/waterbodies")
    public List<Waterbody> getWaterbody() {
        logger.info("==== get waterbodies ====");
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
