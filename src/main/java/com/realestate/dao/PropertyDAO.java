package com.realestate.dao;

import com.realestate.model.Property;
import com.realestate.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PropertyDAO {
    
    // Method to add a new property
    public boolean addProperty(Property property) {
        String sql = "INSERT INTO properties (property_name, location, area_sqft, price, status, property_type) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, property.getPropertyName());
            stmt.setString(2, property.getLocation());
            stmt.setInt(3, property.getAreaSqft());
            stmt.setDouble(4, property.getPrice());
            stmt.setString(5, property.getStatus());
            stmt.setString(6, property.getPropertyType());
            
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
            
        } catch (SQLException e) {
            System.err.println("Error adding property: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    // Method to get all properties
    public List<Property> getAllProperties() {
        List<Property> properties = new ArrayList<>();
        String sql = "SELECT * FROM properties";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                Property property = new Property();
                property.setPropertyId(rs.getInt("property_id"));
                property.setPropertyName(rs.getString("property_name"));
                property.setLocation(rs.getString("location"));
                property.setAreaSqft(rs.getInt("area_sqft"));
                property.setPrice(rs.getDouble("price"));
                property.setStatus(rs.getString("status"));
                properties.add(property);
            }
            
        } catch (SQLException e) {
            System.err.println("Error retrieving properties: " + e.getMessage());
            e.printStackTrace();
        }
        
        return properties;
    }
    
    // Method to search properties by location
    public List<Property> searchByLocation(String location) {
        List<Property> properties = new ArrayList<>();
        String sql = "SELECT * FROM properties WHERE location LIKE ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, "%" + location + "%");
            
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Property property = new Property();
                    property.setPropertyId(rs.getInt("property_id"));
                    property.setPropertyName(rs.getString("property_name"));
                    property.setLocation(rs.getString("location"));
                    property.setAreaSqft(rs.getInt("area_sqft"));
                    property.setPrice(rs.getDouble("price"));
                    property.setStatus(rs.getString("status"));
                    properties.add(property);
                }
            }
            
        } catch (SQLException e) {
            System.err.println("Error searching properties by location: " + e.getMessage());
            e.printStackTrace();
        }
        
        return properties;
    }
    
    // Method to search properties by status
    public List<Property> searchByStatus(String status) {
        List<Property> properties = new ArrayList<>();
        String sql = "SELECT * FROM properties WHERE status = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, status);
            
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Property property = new Property();
                    property.setPropertyId(rs.getInt("property_id"));
                    property.setPropertyName(rs.getString("property_name"));
                    property.setLocation(rs.getString("location"));
                    property.setAreaSqft(rs.getInt("area_sqft"));
                    property.setPrice(rs.getDouble("price"));
                    property.setStatus(rs.getString("status"));
                    properties.add(property);
                }
            }
            
        } catch (SQLException e) {
            System.err.println("Error searching properties by status: " + e.getMessage());
            e.printStackTrace();
        }
        
        return properties;
    }
    
    // Method to update property price
    public boolean updatePropertyPrice(int propertyId, double newPrice) {
        String sql = "UPDATE properties SET price = ? WHERE property_id = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setDouble(1, newPrice);
            stmt.setInt(2, propertyId);
            
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
            
        } catch (SQLException e) {
            System.err.println("Error updating property price: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    // Method to update property status
    public boolean updatePropertyStatus(int propertyId, String newStatus) {
        String sql = "UPDATE properties SET status = ? WHERE property_id = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, newStatus);
            stmt.setInt(2, propertyId);
            
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
            
        } catch (SQLException e) {
            System.err.println("Error updating property status: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    // Method to delete a property
    public boolean deleteProperty(int propertyId) {
        String sql = "DELETE FROM properties WHERE property_id = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, propertyId);
            
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
            
        } catch (SQLException e) {
            System.err.println("Error deleting property: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}