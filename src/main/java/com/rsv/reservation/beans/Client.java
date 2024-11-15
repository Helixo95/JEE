package com.rsv.reservation.beans;

import java.io.Serializable;

public class Client implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nom;
    private String prenom;
    private String telephone;
    private String email;

    // Constructeur par défaut
    public Client() {}

    // Getters et setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

