package com.caroca.Caroca_Mesi.Model;

import jakarta.persistence.*;
import lombok.ToString;
import java.io.Serializable;

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
    
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] imgExt;
    
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] imgInt;
    
    private String imgExtType;
    private String imgIntType;

    public VoitureInfo() {}

    public VoitureInfo(String marque, String modele, int annee, double prix, String couleur,
                      long kilometrage, String typeCarbu, String trans, String description,
                      byte[] imgExt, byte[] imgInt, String imgExtType, String imgIntType) {
        this.marque = marque;
        this.modele = modele;
        this.annee = annee;
        this.prix = prix;
        this.couleur = couleur;
        this.kilometrage = kilometrage;
        this.typeCarbu = typeCarbu;
        this.trans = trans;
        this.description = description;
        this.imgExt = imgExt;
        this.imgInt = imgInt;
        this.imgExtType = imgExtType;
        this.imgIntType = imgIntType;
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

    public byte[] getImgExt() {
        return imgExt;
    }

    public void setImgExt(byte[] imgExt) {
        this.imgExt = imgExt;
    }

    public byte[] getImgInt() {
        return imgInt;
    }

    public void setImgInt(byte[] imgInt) {
        this.imgInt = imgInt;
    }

    public String getImgExtType() {
        return imgExtType;
    }

    public void setImgExtType(String imgExtType) {
        this.imgExtType = imgExtType;
    }

    public String getImgIntType() {
        return imgIntType;
    }

    public void setImgIntType(String imgIntType) {
        this.imgIntType = imgIntType;
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
}

