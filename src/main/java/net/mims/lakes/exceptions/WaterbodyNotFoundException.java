/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.mims.lakes.exceptions;

/**
 *
 * @author leroy
 */
public class WaterbodyNotFoundException extends RuntimeException {

  @SuppressWarnings("unused")
  WaterbodyNotFoundException(Long id) {
    super("Could not find Waterbody " + id);
  }
    
}
