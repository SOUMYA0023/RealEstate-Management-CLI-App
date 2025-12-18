package com.realestate.model;

import java.sql.Date;

public class Transaction {
    private int transactionId;
    private int propertyId;
    private int customerId;
    private int agentId;
    private String transactionType; // Sale, Rent, Lease
    private double transactionAmount;
    private Date transactionDate;

    // Default constructor
    public Transaction() {}

    // Parameterized constructor
    public Transaction(int transactionId, int propertyId, int customerId, int agentId, 
                      String transactionType, double transactionAmount, Date transactionDate) {
        this.transactionId = transactionId;
        this.propertyId = propertyId;
        this.customerId = customerId;
        this.agentId = agentId;
        this.transactionType = transactionType;
        this.transactionAmount = transactionAmount;
        this.transactionDate = transactionDate;
    }

    // Getters and Setters
    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getAgentId() {
        return agentId;
    }

    public void setAgentId(int agentId) {
        this.agentId = agentId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", propertyId=" + propertyId +
                ", customerId=" + customerId +
                ", agentId=" + agentId +
                ", transactionType='" + transactionType + '\'' +
                ", transactionAmount=" + transactionAmount +
                ", transactionDate=" + transactionDate +
                '}';
    }
}
