package com.rsv.reservation.beans;

import java.io.Serializable;

public class Reservation implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nom;
    private String prenom;
    private String telephone;
    private String email;
    private String typeAppartement;
    private double prix;
    private String options;

    // Constructeur par défaut
    public Reservation() {}

    // Constructeur avec paramètres
    public Reservation(String nom, String prenom, String telephone, String email,
                       String typeAppartement, double prix, String options) {
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.email = email;
        this.typeAppartement = typeAppartement;
        this.prix = prix;
        this.options = options;
    }

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

    public String getTypeAppartement() {
        return typeAppartement;
    }

    public void setTypeAppartement(String typeAppartement) {
        this.typeAppartement = typeAppartement;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }
}
