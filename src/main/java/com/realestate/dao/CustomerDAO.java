package com.realestate.dao;

import com.realestate.model.Customer;
import com.realestate.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {
    
    // Method to add a new customer
    public boolean addCustomer(Customer customer) {
        String sql = "INSERT INTO customers (customer_name, email, phone, address) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, customer.getCustomerName());
            stmt.setString(2, customer.getEmail());
            stmt.setString(3, customer.getPhone());
            stmt.setString(4, customer.getAddress());
            
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
            
        } catch (SQLException e) {
            System.err.println("Error adding customer: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    // Method to get all customers
    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        String sql = "SELECT * FROM customers";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setCustomerId(rs.getInt("customer_id"));
                customer.setCustomerName(rs.getString("customer_name"));
                customer.setEmail(rs.getString("email"));
                customer.setPhone(rs.getString("phone"));
                customer.setAddress(rs.getString("address"));
                customers.add(customer);
            }
            
        } catch (SQLException e) {
            System.err.println("Error retrieving customers: " + e.getMessage());
            e.printStackTrace();
        }
        
        return customers;
    }
    
    // Method to get customer by ID
    public Customer getCustomerById(int customerId) {
        String sql = "SELECT * FROM customers WHERE customer_id = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, customerId);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Customer customer = new Customer();
                    customer.setCustomerId(rs.getInt("customer_id"));
                    customer.setCustomerName(rs.getString("customer_name"));
                    customer.setEmail(rs.getString("email"));
                    customer.setPhone(rs.getString("phone"));
                    customer.setAddress(rs.getString("address"));
                    return customer;
                }
            }
            
        } catch (SQLException e) {
            System.err.println("Error retrieving customer by ID: " + e.getMessage());
            e.printStackTrace();
        }
        
        return null;
    }
    
    // Method to update customer
    public boolean updateCustomer(Customer customer) {
        String sql = "UPDATE customers SET customer_name = ?, email = ?, phone = ?, address = ? WHERE customer_id = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, customer.getCustomerName());
            stmt.setString(2, customer.getEmail());
            stmt.setString(3, customer.getPhone());
            stmt.setString(4, customer.getAddress());
            stmt.setInt(5, customer.getCustomerId());
            
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
            
        } catch (SQLException e) {
            System.err.println("Error updating customer: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    // Method to delete a customer
    public boolean deleteCustomer(int customerId) {
        String sql = "DELETE FROM customers WHERE customer_id = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, customerId);
            
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
            
        } catch (SQLException e) {
            System.err.println("Error deleting customer: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    // Method to search customers by name
    public List<Customer> searchByName(String name) {
        List<Customer> customers = new ArrayList<>();
        String sql = "SELECT * FROM customers WHERE customer_name LIKE ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, "%" + name + "%");
            
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Customer customer = new Customer();
                    customer.setCustomerId(rs.getInt("customer_id"));
                    customer.setCustomerName(rs.getString("customer_name"));
                    customer.setEmail(rs.getString("email"));
                    customer.setPhone(rs.getString("phone"));
                    customer.setAddress(rs.getString("address"));
                    customers.add(customer);
                }
            }
            
        } catch (SQLException e) {
            System.err.println("Error searching customers by name: " + e.getMessage());
            e.printStackTrace();
        }
        
        return customers;
    }
}
