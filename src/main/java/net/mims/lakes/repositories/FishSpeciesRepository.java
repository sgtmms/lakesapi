/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.mims.lakes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import net.mims.lakes.domain.FishSpecies;
/**
 *
 * @author leroy
 */
@Repository
public interface FishSpeciesRepository extends JpaRepository<FishSpecies,Long>{
    
}
