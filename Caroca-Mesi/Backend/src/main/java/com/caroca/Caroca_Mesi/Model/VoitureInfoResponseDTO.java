package com.caroca.Caroca_Mesi.Model.dto;

import java.util.List;

public class VoitureInfoResponseDTO {
    private Long id;
    private String marque;
    private String modele;
    private int annee;
    private double prix;
    private String couleur;
    private long kilometrage;
    private String typeCarbu;
    private String trans;
    private String description;
    private List<CarImageResponseDTO> images; // List of image DTOs

    // Constructors
    public VoitureInfoResponseDTO() {
    }

    public VoitureInfoResponseDTO(Long id, String marque, String modele, int annee, double prix, String couleur, long kilometrage, String typeCarbu, String trans, String description, List<CarImageResponseDTO> images) {
        this.id = id;
        this.marque = marque;
        this.modele = modele;
        this.annee = annee;
        this.prix = prix;
        this.couleur = couleur;
        this.kilometrage = kilometrage;
        this.typeCarbu = typeCarbu;
        this.trans = trans;
        this.description = description;
        this.images = images;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public long getKilometrage() {
        return kilometrage;
    }

    public void setKilometrage(long kilometrage) {
        this.kilometrage = kilometrage;
    }

    public String getTypeCarbu() {
        return typeCarbu;
    }

    public void setTypeCarbu(String typeCarbu) {
        this.typeCarbu = typeCarbu;
    }

    public String getTrans() {
        return trans;
    }

    public void setTrans(String trans) {
        this.trans = trans;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<CarImageResponseDTO> getImages() {
        return images;
    }

    public void setImages(List<CarImageResponseDTO> images) {
        this.images = images;
    }
}