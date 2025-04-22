/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.mims.lakes.services;

import java.util.List;
import net.mims.lakes.domain.FishSpecies;

/**
 *
 * @author leroy
 */
public interface FishSpeciesService {
     /**
     * Saves a fishSpecies entity.
     * @param fishSpecies the fishSpecies to save
     * @return the saved fishSpecies
     */
    FishSpecies saveFishSpecies(FishSpecies fishSpecies);

    /**
     * Fetches the list of all fishSpecies entities.
     * @return a list of fishSpeciess
     */
    List<FishSpecies> fetchFishSpeciesList();

    /**
     * Updates an existing fishSpecies entity.
     * @param fishSpecies the fishSpecies with updated information
     * @param fishSpeciesId the ID of the fishSpecies to update
     * @return the updated fishSpecies
     */
    FishSpecies updateFishSpecies(FishSpecies fishSpecies, Long fishSpeciesId);

    /**
     * Deletes a fishSpecies entity by its ID.
     * @param fishSpeciesId the ID of the fishSpecies to delete
     */
    void deleteFishSpeciesById(Long fishSpeciesId);
    
    FishSpecies getById(Long id);
}
