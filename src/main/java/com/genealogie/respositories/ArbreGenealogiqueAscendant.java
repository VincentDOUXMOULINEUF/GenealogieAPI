/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genealogie.respositories;

import com.genealogie.entity.Personne;
import java.util.ArrayList;
import java.util.List;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Vincent
 */
@Repository
public class ArbreGenealogiqueAscendant implements IArbreGenealogiqueRepository{

    @Autowired
    private IPersonneJpaRepository personneRepo;
    private List<Personne> arbre;
    private final Logger logger = Logger.getLogger(ArbreGenealogiqueAscendant.class);
    
    
    @Override
    public List<Personne> getArbreGenealogiqueAscendant(Integer id) throws UnsupportedOperationException{
            arbre = new ArrayList<>();
            return monterArbre(personneRepo.getOne(id));
    }
    
    private List<Personne> monterArbre(Personne pers) {
        logger.info("Je suis rentré dans la méthode de l'arbre");
        if (pers.getPersonne_id_pere() != null) {
            logger.info("J'ai un papa");
            monterArbre(personneRepo.getOne(pers.getPersonne_id_pere()));
        }
        arbre.add(pers);
        logger.info(pers.toString());
        if (pers.getPersonne_id_mere() != null) {
            logger.info("j'ai une maman");
            monterArbre(personneRepo.getOne(pers.getPersonne_id_mere()));
        }
        logger.info(arbre);
        return arbre;
    }
    
}
