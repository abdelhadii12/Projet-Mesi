package com.caroca.Caroca_Mesi.Model;

import jakarta.persistence.*;

@Entity
public class CarImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] data;

    private String contentType;

    @ManyToOne
    private VoitureInfo voiture;

    // Getters and setters...

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public VoitureInfo getVoiture() {
        return voiture;
    }

    public void setVoiture(VoitureInfo voiture) {
        this.voiture = voiture;
    }
}
