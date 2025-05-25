package com.caroca.Caroca_Mesi.Model;

import jakarta.persistence.*;
import lombok.ToString;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@ToString
public class VoitureInfo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private long Id;
    private String marque;
    private String modele;
    private int annee;
    private double prix;
    private String couleur;
    private long kilometrage;
    private String typeCarbu;
    private String trans;
    private String description;

    @OneToMany(mappedBy = "voiture", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CarImage> images = new ArrayList<>();

    @ManyToOne
    private User owner;

    public VoitureInfo() {}

    public VoitureInfo(String marque, String modele, int annee, double prix, String couleur,
                      long kilometrage, String typeCarbu, String trans, String description) {
        this.marque = marque;
        this.modele = modele;
        this.annee = annee;
        this.prix = prix;
        this.couleur = couleur;
        this.kilometrage = kilometrage;
        this.typeCarbu = typeCarbu;
        this.trans = trans;
        this.description = description;
    }

    public long getId() {
        return Id;
    }

    public String getMarque() {
        return marque;
    }

    public String getModele() {
        return modele;
    }

    public int getAnnee() {
        return annee;
    }

    public double getPrix() {
        return prix;
    }

    public String getCouleur() {
        return couleur;
    }

    public long getKilometrage() {
        return kilometrage;
    }

    public String getTypeCarbu() {
        return typeCarbu;
    }

    public String getTrans() {
        return trans;
    }

    public String getDescription() {
        return description;
    }

    public List<CarImage> getImages() {
        return images;
    }

    public void setImages(List<CarImage> images) {
        this.images = images;
    }

    public void setId(long id) {
        Id = id;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public void setKilometrage(long kilometrage) {
        this.kilometrage = kilometrage;
    }

    public void setTypeCarbu(String typeCarbu) {
        this.typeCarbu = typeCarbu;
    }

    public void setTrans(String trans) {
        this.trans = trans;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}

