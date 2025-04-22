/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.mims.lakes.services;

import java.util.List;
import net.mims.lakes.domain.Waterbody;

/**
 *
 * @author leroy
 */
public interface WaterbodyService {
     /**
     * Saves a waterbody entity.
     * @param waterbody the waterbody to save
     * @return the saved waterbody
     */
    Waterbody saveWaterbody(Waterbody waterbody);

    /**
     * Fetches the list of all waterbody entities.
     * @return a list of waterbodys
     */
    List<Waterbody> fetchWaterbodiesList();

    /**
     * Updates an existing waterbody entity.
     * @param waterbody the waterbody with updated information
     * @param waterbodyId the ID of the waterbody to update
     * @return the updated waterbody
     */
    Waterbody updateWaterbody(Waterbody waterbody, Long waterbodyId);

    /**
     * Deletes a waterbody entity by its ID.
     * @param waterbodyId the ID of the waterbody to delete
     */
    void deleteWaterbodyById(Long waterbodyId);
    
    Waterbody getById(Long id);
}
