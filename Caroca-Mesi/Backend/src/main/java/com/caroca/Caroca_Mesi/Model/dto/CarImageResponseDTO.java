package com.caroca.Caroca_Mesi.Model.dto; // <--- This package declaration is crucial

public class CarImageResponseDTO {
    private String data; // Base64 encoded image data
    private String contentType;

    // Constructors
    public CarImageResponseDTO() {
    }

    public CarImageResponseDTO(String data, String contentType) {
        this.data = data;
        this.contentType = contentType;
    }

    // Getters and Setters
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
}