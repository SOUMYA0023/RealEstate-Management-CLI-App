package com.realestate.dao;

import com.realestate.model.Payment;
import com.realestate.util.DBConnection;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PaymentDAO {

    // Method to add a new payment
    public boolean addPayment(Payment payment) {
        String sql = "INSERT INTO payment (property_id, payer_name, amount, payment_date, payment_mode) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, payment.getPropertyId());
            stmt.setString(2, payment.getPayerName());
            stmt.setDouble(3, payment.getAmount());
            stmt.setDate(4, Date.valueOf(payment.getPaymentDate()));
            stmt.setString(5, payment.getPaymentMode());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.err.println("Error adding payment: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    // Method to get all payments
    public List<Payment> getAllPayments() {
        List<Payment> payments = new ArrayList<>();
        String sql = "SELECT * FROM payment";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Payment payment = new Payment();
                payment.setPaymentId(rs.getInt("payment_id"));
                payment.setPropertyId(rs.getInt("property_id"));
                payment.setPayerName(rs.getString("payer_name"));
                payment.setAmount(rs.getDouble("amount"));
                payment.setPaymentDate(rs.getDate("payment_date").toLocalDate());
                payment.setPaymentMode(rs.getString("payment_mode"));
                payments.add(payment);
            }

        } catch (SQLException e) {
            System.err.println("Error retrieving payments: " + e.getMessage());
            e.printStackTrace();
        }

        return payments;
    }

    // Method to get payment by ID
    public Payment getPaymentById(int paymentId) {
        String sql = "SELECT * FROM payment WHERE payment_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, paymentId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Payment payment = new Payment();
                    payment.setPaymentId(rs.getInt("payment_id"));
                    payment.setPropertyId(rs.getInt("property_id"));
                    payment.setPayerName(rs.getString("payer_name"));
                    payment.setAmount(rs.getDouble("amount"));
                    payment.setPaymentDate(rs.getDate("payment_date").toLocalDate());
                    payment.setPaymentMode(rs.getString("payment_mode"));
                    return payment;
                }
            }

        } catch (SQLException e) {
            System.err.println("Error retrieving payment: " + e.getMessage());
            e.printStackTrace();
        }

        return null;
    }

    // Method to get payments by property ID
    public List<Payment> getPaymentsByPropertyId(int propertyId) {
        List<Payment> payments = new ArrayList<>();
        String sql = "SELECT * FROM payment WHERE property_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, propertyId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Payment payment = new Payment();
                    payment.setPaymentId(rs.getInt("payment_id"));
                    payment.setPropertyId(rs.getInt("property_id"));
                    payment.setPayerName(rs.getString("payer_name"));
                    payment.setAmount(rs.getDouble("amount"));
                    payment.setPaymentDate(rs.getDate("payment_date").toLocalDate());
                    payment.setPaymentMode(rs.getString("payment_mode"));
                    payments.add(payment);
                }
            }

        } catch (SQLException e) {
            System.err.println("Error retrieving payments by property ID: " + e.getMessage());
            e.printStackTrace();
        }

        return payments;
    }

    // Method to update payment amount
    public boolean updatePaymentAmount(int paymentId, double newAmount) {
        String sql = "UPDATE payment SET amount = ? WHERE payment_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, newAmount);
            stmt.setInt(2, paymentId);

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.err.println("Error updating payment amount: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    // Method to delete a payment
    public boolean deletePayment(int paymentId) {
        String sql = "DELETE FROM payment WHERE payment_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, paymentId);

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.err.println("Error deleting payment: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}