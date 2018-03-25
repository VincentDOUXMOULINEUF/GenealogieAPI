/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genealogie.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Vincent
 */
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "personne")
public class Personne implements Serializable {
    
    @Id
    @Column(name = "personne_id")
    private Integer personne_id;
    private String personne_nom;
    private String personne_nom_naissance;
    private String personne_prenom;
    private String personne_prenom_second;
    private String personne_prenom_troisieme;
    private String personne_date_naissance;
    private String personne_code_postal_naissance;
    private String personne_ville_naissance;
    private String personne_date_deces;
    private String personne_code_postal_deces;
    private String personne_ville_deces;
    private Integer personne_id_pere;
    private Integer personne_id_mere;

    public Integer getPersonne_id() {
        return personne_id;
    }

    public void setPersonne_id(Integer personne_id) {
        this.personne_id = personne_id;
    }

    public String getPersonne_nom() {
        return personne_nom;
    }

    public void setPersonne_nom(String personne_nom) {
        this.personne_nom = personne_nom;
    }

    public String getPersonne_nom_naissance() {
        return personne_nom_naissance;
    }

    public void setPersonne_nom_naissance(String personne_nom_naissance) {
        this.personne_nom_naissance = personne_nom_naissance;
    }

    public String getPersonne_prenom() {
        return personne_prenom;
    }

    public void setPersonne_prenom(String personne_prenom) {
        this.personne_prenom = personne_prenom;
    }

    public String getPersonne_prenom_second() {
        return personne_prenom_second;
    }

    public void setPersonne_prenom_second(String personne_prenom_second) {
        this.personne_prenom_second = personne_prenom_second;
    }

    public String getPersonne_prenom_troisieme() {
        return personne_prenom_troisieme;
    }

    public void setPersonne_prenom_troisieme(String personne_prenom_troisieme) {
        this.personne_prenom_troisieme = personne_prenom_troisieme;
    }

    public String getPersonne_date_naissance() {
        return personne_date_naissance;
    }

    public void setPersonne_date_naissance(String personne_date_naissance) {
        this.personne_date_naissance = personne_date_naissance;
    }

    public String getPersonne_code_postal_naissance() {
        return personne_code_postal_naissance;
    }

    public void setPersonne_code_postal_naissance(String personne_code_postal_naissance) {
        this.personne_code_postal_naissance = personne_code_postal_naissance;
    }

    public String getPersonne_ville_naissance() {
        return personne_ville_naissance;
    }

    public void setPersonne_ville_naissance(String personne_ville_naissance) {
        this.personne_ville_naissance = personne_ville_naissance;
    }

    public String getPersonne_date_deces() {
        return personne_date_deces;
    }

    public void setPersonne_date_deces(String personne_date_deces) {
        this.personne_date_deces = personne_date_deces;
    }

    public String getPersonne_code_postal_deces() {
        return personne_code_postal_deces;
    }

    public void setPersonne_code_postal_deces(String personne_code_postal_deces) {
        this.personne_code_postal_deces = personne_code_postal_deces;
    }

    public String getPersonne_ville_deces() {
        return personne_ville_deces;
    }

    public void setPersonne_ville_deces(String personne_ville_deces) {
        this.personne_ville_deces = personne_ville_deces;
    }

    public Integer getPersonne_id_pere() {
        return personne_id_pere;
    }

    public void setPersonne_id_pere(Integer personne_id_pere) {
        this.personne_id_pere = personne_id_pere;
    }

    public Integer getPersonne_id_mere() {
        return personne_id_mere;
    }

    public void setPersonne_id_mere(Integer personne_id_mere) {
        this.personne_id_mere = personne_id_mere;
    }

    @Override
    public String toString() {
        return "Personne{" + "personne_id=" + personne_id + ", personne_nom=" + personne_nom + ", personne_nom_naissance=" + personne_nom_naissance + ", personne_prenom=" + personne_prenom + ", personne_prenom_second=" + personne_prenom_second + ", personne_prenom_troisieme=" + personne_prenom_troisieme + ", personne_date_naissance=" + personne_date_naissance + ", personne_code_postal_naissance=" + personne_code_postal_naissance + ", personne_ville_naissance=" + personne_ville_naissance + ", personne_date_deces=" + personne_date_deces + ", personne_code_postal_deces=" + personne_code_postal_deces + ", personne_ville_deces=" + personne_ville_deces + ", personne_id_pere=" + personne_id_pere + ", personne_id_mere=" + personne_id_mere + '}';
    }

    

    
    
    
    
    
    
}
