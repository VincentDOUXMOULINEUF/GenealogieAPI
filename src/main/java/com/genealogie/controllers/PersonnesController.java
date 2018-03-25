/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genealogie.controllers;

import com.genealogie.entity.Personne;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.jboss.logging.Logger;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.genealogie.respositories.IPersonneJpaRepository;

/**
 *
 * @author Vincent
 */
@RestController
@CrossOrigin
@RequestMapping("api/personne")
public class PersonnesController {
    
    private Logger logger = Logger.getLogger(PersonnesController.class);
    
    @Autowired
    private IPersonneJpaRepository personneJpaRepository;

    @GetMapping(value = "/all")
    public List<Personne> findAll() {
        for (Personne pers : personneJpaRepository.findAll()) {
            logger.info(pers.toString());
        }
        return personneJpaRepository.findAll();
    }

    
    
}
