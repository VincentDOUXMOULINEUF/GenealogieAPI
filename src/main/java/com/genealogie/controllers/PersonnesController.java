/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genealogie.controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.genealogie.entity.Personne;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.jboss.logging.Logger;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.genealogie.respositories.IPersonneJpaRepository;
import com.genealogie.service.PersonneService;
import org.springframework.web.bind.annotation.PathVariable;

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
    
    @Autowired
    private PersonneService personneService;

    @GetMapping(value = "/all")
    public List<Personne> findAll() {
        for (Personne pers : personneJpaRepository.findAll()) {
            logger.info(pers.toString());
        }
        return personneJpaRepository.findAll();
    }
    
    @GetMapping(value = "/{id}")
    public Personne getOne(@PathVariable final Integer id) {
        logger.info("Appel de la méthode pour recherche une personne selon son id");
        logger.info("La personne recherchée possède l'id " + id);
        logger.info("La personne est la suivante " + personneService.removeGrandParents(personneJpaRepository.getOne(id)).toString());
        return personneService.removeGrandParents(personneJpaRepository.getOne(id));
    }
    
    @GetMapping(value = "/arbre/{id}")
    public Personne getArbre(@PathVariable final Integer id) {
        logger.info("Appel de la méthode pour recherche l'arbre d'une personne selon son id");
        logger.info("L'arbre de la personne recherchée possède l'id " + id);
        logger.info("L'arbre est le suivant" + personneJpaRepository.getOne(id).toString());
        return personneJpaRepository.getOne(id);
    }

    
    
}
