package com.realestate.model;

public class Owner {
    private int ownerId;
    private String ownerName;
    private String email;
    private String phone;
    private String address;

    // Default constructor
    public Owner() {}

    // Parameterized constructor
    public Owner(int ownerId, String ownerName, String email, String phone, String address) {
        this.ownerId = ownerId;
        this.ownerName = ownerName;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    // Getters and Setters
    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "ownerId=" + ownerId +
                ", ownerName='" + ownerName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
