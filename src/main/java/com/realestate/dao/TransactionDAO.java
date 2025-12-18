package com.realestate.dao;

import com.realestate.model.Transaction;
import com.realestate.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionDAO {
    
    // Method to add a new transaction
    public boolean addTransaction(Transaction transaction) {
        String sql = "INSERT INTO transactions (property_id, customer_id, agent_id, transaction_type, transaction_amount, transaction_date) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, transaction.getPropertyId());
            stmt.setInt(2, transaction.getCustomerId());
            stmt.setInt(3, transaction.getAgentId());
            stmt.setString(4, transaction.getTransactionType());
            stmt.setDouble(5, transaction.getTransactionAmount());
            stmt.setDate(6, transaction.getTransactionDate());
            
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
            
        } catch (SQLException e) {
            System.err.println("Error adding transaction: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    // Method to get all transactions
    public List<Transaction> getAllTransactions() {
        List<Transaction> transactions = new ArrayList<>();
        String sql = "SELECT * FROM transactions";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                Transaction transaction = new Transaction();
                transaction.setTransactionId(rs.getInt("transaction_id"));
                transaction.setPropertyId(rs.getInt("property_id"));
                transaction.setCustomerId(rs.getInt("customer_id"));
                transaction.setAgentId(rs.getInt("agent_id"));
                transaction.setTransactionType(rs.getString("transaction_type"));
                transaction.setTransactionAmount(rs.getDouble("transaction_amount"));
                transaction.setTransactionDate(rs.getDate("transaction_date"));
                transactions.add(transaction);
            }
            
        } catch (SQLException e) {
            System.err.println("Error retrieving transactions: " + e.getMessage());
            e.printStackTrace();
        }
        
        return transactions;
    }
    
    // Method to get transaction by ID
    public Transaction getTransactionById(int transactionId) {
        String sql = "SELECT * FROM transactions WHERE transaction_id = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, transactionId);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Transaction transaction = new Transaction();
                    transaction.setTransactionId(rs.getInt("transaction_id"));
                    transaction.setPropertyId(rs.getInt("property_id"));
                    transaction.setCustomerId(rs.getInt("customer_id"));
                    transaction.setAgentId(rs.getInt("agent_id"));
                    transaction.setTransactionType(rs.getString("transaction_type"));
                    transaction.setTransactionAmount(rs.getDouble("transaction_amount"));
                    transaction.setTransactionDate(rs.getDate("transaction_date"));
                    return transaction;
                }
            }
            
        } catch (SQLException e) {
            System.err.println("Error retrieving transaction by ID: " + e.getMessage());
            e.printStackTrace();
        }
        
        return null;
    }
    
    // Method to get transactions by property ID
    public List<Transaction> getTransactionsByPropertyId(int propertyId) {
        List<Transaction> transactions = new ArrayList<>();
        String sql = "SELECT * FROM transactions WHERE property_id = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, propertyId);
            
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Transaction transaction = new Transaction();
                    transaction.setTransactionId(rs.getInt("transaction_id"));
                    transaction.setPropertyId(rs.getInt("property_id"));
                    transaction.setCustomerId(rs.getInt("customer_id"));
                    transaction.setAgentId(rs.getInt("agent_id"));
                    transaction.setTransactionType(rs.getString("transaction_type"));
                    transaction.setTransactionAmount(rs.getDouble("transaction_amount"));
                    transaction.setTransactionDate(rs.getDate("transaction_date"));
                    transactions.add(transaction);
                }
            }
            
        } catch (SQLException e) {
            System.err.println("Error retrieving transactions by property ID: " + e.getMessage());
            e.printStackTrace();
        }
        
        return transactions;
    }
    
    // Method to get transactions by customer ID
    public List<Transaction> getTransactionsByCustomerId(int customerId) {
        List<Transaction> transactions = new ArrayList<>();
        String sql = "SELECT * FROM transactions WHERE customer_id = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, customerId);
            
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Transaction transaction = new Transaction();
                    transaction.setTransactionId(rs.getInt("transaction_id"));
                    transaction.setPropertyId(rs.getInt("property_id"));
                    transaction.setCustomerId(rs.getInt("customer_id"));
                    transaction.setAgentId(rs.getInt("agent_id"));
                    transaction.setTransactionType(rs.getString("transaction_type"));
                    transaction.setTransactionAmount(rs.getDouble("transaction_amount"));
                    transaction.setTransactionDate(rs.getDate("transaction_date"));
                    transactions.add(transaction);
                }
            }
            
        } catch (SQLException e) {
            System.err.println("Error retrieving transactions by customer ID: " + e.getMessage());
            e.printStackTrace();
        }
        
        return transactions;
    }
    
    // Method to get transactions by agent ID
    public List<Transaction> getTransactionsByAgentId(int agentId) {
        List<Transaction> transactions = new ArrayList<>();
        String sql = "SELECT * FROM transactions WHERE agent_id = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, agentId);
            
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Transaction transaction = new Transaction();
                    transaction.setTransactionId(rs.getInt("transaction_id"));
                    transaction.setPropertyId(rs.getInt("property_id"));
                    transaction.setCustomerId(rs.getInt("customer_id"));
                    transaction.setAgentId(rs.getInt("agent_id"));
                    transaction.setTransactionType(rs.getString("transaction_type"));
                    transaction.setTransactionAmount(rs.getDouble("transaction_amount"));
                    transaction.setTransactionDate(rs.getDate("transaction_date"));
                    transactions.add(transaction);
                }
            }
            
        } catch (SQLException e) {
            System.err.println("Error retrieving transactions by agent ID: " + e.getMessage());
            e.printStackTrace();
        }
        
        return transactions;
    }
    
    // Method to get transactions by type
    public List<Transaction> getTransactionsByType(String transactionType) {
        List<Transaction> transactions = new ArrayList<>();
        String sql = "SELECT * FROM transactions WHERE transaction_type = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, transactionType);
            
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Transaction transaction = new Transaction();
                    transaction.setTransactionId(rs.getInt("transaction_id"));
                    transaction.setPropertyId(rs.getInt("property_id"));
                    transaction.setCustomerId(rs.getInt("customer_id"));
                    transaction.setAgentId(rs.getInt("agent_id"));
                    transaction.setTransactionType(rs.getString("transaction_type"));
                    transaction.setTransactionAmount(rs.getDouble("transaction_amount"));
                    transaction.setTransactionDate(rs.getDate("transaction_date"));
                    transactions.add(transaction);
                }
            }
            
        } catch (SQLException e) {
            System.err.println("Error retrieving transactions by type: " + e.getMessage());
            e.printStackTrace();
        }
        
        return transactions;
    }
    
    // Method to update transaction
    public boolean updateTransaction(Transaction transaction) {
        String sql = "UPDATE transactions SET property_id = ?, customer_id = ?, agent_id = ?, transaction_type = ?, transaction_amount = ?, transaction_date = ? WHERE transaction_id = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, transaction.getPropertyId());
            stmt.setInt(2, transaction.getCustomerId());
            stmt.setInt(3, transaction.getAgentId());
            stmt.setString(4, transaction.getTransactionType());
            stmt.setDouble(5, transaction.getTransactionAmount());
            stmt.setDate(6, transaction.getTransactionDate());
            stmt.setInt(7, transaction.getTransactionId());
            
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
            
        } catch (SQLException e) {
            System.err.println("Error updating transaction: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    // Method to delete a transaction
    public boolean deleteTransaction(int transactionId) {
        String sql = "DELETE FROM transactions WHERE transaction_id = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, transactionId);
            
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
            
        } catch (SQLException e) {
            System.err.println("Error deleting transaction: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}
