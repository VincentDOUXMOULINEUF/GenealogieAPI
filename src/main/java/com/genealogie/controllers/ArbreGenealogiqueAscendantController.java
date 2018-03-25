/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genealogie.controllers;

import com.genealogie.entity.Personne;
import com.genealogie.respositories.IArbreGenealogiqueRepository;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Vincent
 */
@RestController
@CrossOrigin
@RequestMapping("/api/arbre-genealogique-ascendant")
public class ArbreGenealogiqueAscendantController {
    
    private Logger logger = Logger.getLogger(ArbreGenealogiqueAscendantController.class);
    
    @Autowired
    private IArbreGenealogiqueRepository iArbreGenealogiqueRepo;
    
    @GetMapping(value = "/{id}")
    public List<Personne> getArbreGenealogique(@PathVariable Integer id) {
        List<Personne> list = new ArrayList<>();
        logger.info("Entré dans la méthode GET");
        logger.info("l'id = " + id);
        list = iArbreGenealogiqueRepo.getArbreGenealogiqueAscendant(id);
        Collections.sort(list, new Comparator<Personne>() {
            @Override
            public int compare(Personne o1, Personne o2) {
                return o1.getPersonne_id().compareTo(o2.getPersonne_id());
            }
        });
        logger.info("Liste triée" + list);
        return list;
    }
    
}
