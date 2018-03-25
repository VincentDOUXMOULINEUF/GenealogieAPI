/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genealogie.respositories;

import com.genealogie.entity.Personne;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author Vincent
 */
@Component
public interface IArbreGenealogiqueRepository {
    
    List<Personne> getArbreGenealogiqueAscendant(Integer id);
}
