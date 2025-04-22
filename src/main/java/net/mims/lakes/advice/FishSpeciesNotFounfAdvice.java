/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.mims.lakes.advice;

import net.mims.lakes.exceptions.FishSpeciesNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 *
 * @author leroy
 */
@RestControllerAdvice
public class FishSpeciesNotFounfAdvice {

    @ExceptionHandler(FishSpeciesNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String fishSpeciesNotFoundHandler(FishSpeciesNotFoundException ex) {
        return ex.getMessage();
    }

}
