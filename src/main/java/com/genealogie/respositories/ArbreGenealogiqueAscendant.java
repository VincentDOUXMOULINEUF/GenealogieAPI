/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genealogie.respositories;

import com.genealogie.entity.Personne;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
        logger.info("Appel de la méthode permettant de récupérer l'arbre généalogique ascendant de la personne avec id = " + id);
        arbre = new ArrayList<>();
        arbre = monterArbre(personneRepo.getOne(id));
        logger.info("L'arbre généalogique non trié est le suivant : " + arbre);
        return sortArbre(arbre);
    }
    
    /**
     * Méthode récursive permettant de remonter l'arbre généalogique d'une personne
     * @param pers, la personne dont on souhaite connaitre la généalogie ascendante
     * @return une liste contenant tous ses parents
     */
    private List<Personne> monterArbre(Personne pers) {
        logger.info("Appel de la méthode récursive permettant de construire l'arbre de la personne avec id = " + pers.getPersonne_id());
        if (pers.getPersonne_id_pere() != null) {
            monterArbre(personneRepo.getOne(pers.getPersonne_id_pere()));
        }
        arbre.add(pers);
        if (pers.getPersonne_id_mere() != null) {
            monterArbre(personneRepo.getOne(pers.getPersonne_id_mere()));
        }
        return arbre;
    }
    
    /**
     * Méthode permettant de trier l'arbre généalogique par id du plis petit au plus grand
     * @param list, la liste que l'on souhaite trier
     * @return la liste triée
     */
    private List<Personne> sortArbre(List<Personne> list) {
        Collections.sort(list, new Comparator<Personne>() {
                @Override
                public int compare(Personne pers1, Personne pers2) {
                    return pers1.getPersonne_id().compareTo(pers2.getPersonne_id());
                }
            });
        logger.info("l'arbre généalogique trié est le suivant : " + list);
        return list;
    }
    
}
