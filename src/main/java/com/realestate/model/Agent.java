package com.realestate.model;

public class Agent {
    private int agentId;
    private String agentName;
    private String email;
    private String phone;
    private String specialization;

    // Default constructor
    public Agent() {}

    // Parameterized constructor
    public Agent(int agentId, String agentName, String email, String phone, String specialization) {
        this.agentId = agentId;
        this.agentName = agentName;
        this.email = email;
        this.phone = phone;
        this.specialization = specialization;
    }

    // Getters and Setters
    public int getAgentId() {
        return agentId;
    }

    public void setAgentId(int agentId) {
        this.agentId = agentId;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
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

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Override
    public String toString() {
        return "Agent{" +
                "agentId=" + agentId +
                ", agentName='" + agentName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", specialization='" + specialization + '\'' +
                '}';
    }
}
