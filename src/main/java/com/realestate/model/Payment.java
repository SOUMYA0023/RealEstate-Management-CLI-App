package com.realestate.model;

import java.time.LocalDate;

public class Payment {
    private int paymentId;
    private int propertyId;
    private String payerName;
    private double amount;
    private LocalDate paymentDate;
    private String paymentMode;

    // Default constructor
    public Payment() {}

    // Parameterized constructor
    public Payment(int paymentId, int propertyId, String payerName, double amount, LocalDate paymentDate, String paymentMode) {
        this.paymentId = paymentId;
        this.propertyId = propertyId;
        this.payerName = payerName;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.paymentMode = paymentMode;
    }

    // Getters and Setters
    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public String getPayerName() {
        return payerName;
    }

    public void setPayerName(String payerName) {
        this.payerName = payerName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId=" + paymentId +
                ", propertyId=" + propertyId +
                ", payerName='" + payerName + '\'' +
                ", amount=" + amount +
                ", paymentDate=" + paymentDate +
                ", paymentMode='" + paymentMode + '\'' +
                '}';
    }
}