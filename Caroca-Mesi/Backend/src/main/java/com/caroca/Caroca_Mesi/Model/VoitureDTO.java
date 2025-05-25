package com.caroca.Caroca_Mesi.Model;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class VoitureDTO {
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
    private List<MultipartFile> images;
    

    // Getters and Setters
    public List<MultipartFile> getImages() {
        return images;
    }

    public void setImages(List<MultipartFile> images) { 
        this.images = images;}

        
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

    

}