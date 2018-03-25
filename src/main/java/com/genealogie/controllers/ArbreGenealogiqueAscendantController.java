/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genealogie.controllers;

import com.genealogie.entity.Personne;
import com.genealogie.respositories.IArbreGenealogiqueRepository;
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
        logger.info("L'utilsateur souhaite connaitre l'arbre généalogique de la personne avec id = " + id);
        return iArbreGenealogiqueRepo.getArbreGenealogiqueAscendant(id);
    }
    
}
