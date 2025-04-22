/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.mims.lakes.exceptions;

/**
 *
 * @author leroy
 */
public class FishSpeciesNotFoundException extends RuntimeException {

  public FishSpeciesNotFoundException(Long id) {
    super("Could not find FishSpecies " + id);
  }
    
}
