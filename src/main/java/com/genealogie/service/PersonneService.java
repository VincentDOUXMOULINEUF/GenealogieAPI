/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genealogie.service;

import com.genealogie.entity.Personne;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

/**
 *
 * @author Vincent
 */
@Component
public class PersonneService {
    
    private Logger logger = Logger.getLogger(PersonneService.class);
    
    
    public Personne removeGrandParents(Personne pers) {
        logger.info("Appel de la méthode de suppression des grands-parents");
        if (pers.getPere() != null) {
            pers.getPere().setPere(null);
            pers.getPere().setMere(null);
        }
        if (pers.getMere() != null) {
            pers.getMere().setPere(null);
            pers.getMere().setMere(null);
        }
        return pers;
    }
    
}
