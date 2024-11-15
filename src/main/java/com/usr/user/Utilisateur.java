package com.usr.user;

import java.io.Serializable;

public class Utilisateur implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nom;
    private String prenom;
    private String sexe;
    private String codePostal;
    private String[] transports;

    // Constructeur par défaut
    public Utilisateur() {}


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

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String[] getTransports() {
        return transports;
    }

    public void setTransports(String[] transports) {
        this.transports = transports;
    }
}
