package com.realestate.model;

public class Property {
    private int propertyId;
    private String propertyName;
    private String location;
    private int areaSqft;
    private double price;
    private String status; // Available, Sold, Rented
    private String propertyType;

    // Default constructor
    public Property() {}

    // Parameterized constructor
    public Property(int propertyId, String propertyName, String location, int areaSqft, double price, String status) {
        this.propertyId = propertyId;
        this.propertyName = propertyName;
        this.location = location;
        this.areaSqft = areaSqft;
        this.price = price;
        this.status = status;
        this.propertyType = "Residential"; // Default value
    }

    // Getters and Setters
    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getAreaSqft() {
        return areaSqft;
    }

    public void setAreaSqft(int areaSqft) {
        this.areaSqft = areaSqft;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Property{" +
                "propertyId=" + propertyId +
                ", propertyName='" + propertyName + '\'' +
                ", location='" + location + '\'' +
                ", areaSqft=" + areaSqft +
                ", price=" + price +
                ", status='" + status + '\'' +
                ", propertyType='" + propertyType + '\'' +
                '}';
    }
}