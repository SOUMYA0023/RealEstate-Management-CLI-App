package com.realestate.dao;

import com.realestate.model.Owner;
import com.realestate.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OwnerDAO {
    
    // Method to add a new owner
    public boolean addOwner(Owner owner) {
        String sql = "INSERT INTO owners (owner_name, email, phone, address) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, owner.getOwnerName());
            stmt.setString(2, owner.getEmail());
            stmt.setString(3, owner.getPhone());
            stmt.setString(4, owner.getAddress());
            
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
            
        } catch (SQLException e) {
            System.err.println("Error adding owner: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    // Method to get all owners
    public List<Owner> getAllOwners() {
        List<Owner> owners = new ArrayList<>();
        String sql = "SELECT * FROM owners";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                Owner owner = new Owner();
                owner.setOwnerId(rs.getInt("owner_id"));
                owner.setOwnerName(rs.getString("owner_name"));
                owner.setEmail(rs.getString("email"));
                owner.setPhone(rs.getString("phone"));
                owner.setAddress(rs.getString("address"));
                owners.add(owner);
            }
            
        } catch (SQLException e) {
            System.err.println("Error retrieving owners: " + e.getMessage());
            e.printStackTrace();
        }
        
        return owners;
    }
    
    // Method to get owner by ID
    public Owner getOwnerById(int ownerId) {
        String sql = "SELECT * FROM owners WHERE owner_id = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, ownerId);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Owner owner = new Owner();
                    owner.setOwnerId(rs.getInt("owner_id"));
                    owner.setOwnerName(rs.getString("owner_name"));
                    owner.setEmail(rs.getString("email"));
                    owner.setPhone(rs.getString("phone"));
                    owner.setAddress(rs.getString("address"));
                    return owner;
                }
            }
            
        } catch (SQLException e) {
            System.err.println("Error retrieving owner by ID: " + e.getMessage());
            e.printStackTrace();
        }
        
        return null;
    }
    
    // Method to update owner
    public boolean updateOwner(Owner owner) {
        String sql = "UPDATE owners SET owner_name = ?, email = ?, phone = ?, address = ? WHERE owner_id = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, owner.getOwnerName());
            stmt.setString(2, owner.getEmail());
            stmt.setString(3, owner.getPhone());
            stmt.setString(4, owner.getAddress());
            stmt.setInt(5, owner.getOwnerId());
            
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
            
        } catch (SQLException e) {
            System.err.println("Error updating owner: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    // Method to delete an owner
    public boolean deleteOwner(int ownerId) {
        String sql = "DELETE FROM owners WHERE owner_id = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, ownerId);
            
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
            
        } catch (SQLException e) {
            System.err.println("Error deleting owner: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    // Method to search owners by name
    public List<Owner> searchByName(String name) {
        List<Owner> owners = new ArrayList<>();
        String sql = "SELECT * FROM owners WHERE owner_name LIKE ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, "%" + name + "%");
            
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Owner owner = new Owner();
                    owner.setOwnerId(rs.getInt("owner_id"));
                    owner.setOwnerName(rs.getString("owner_name"));
                    owner.setEmail(rs.getString("email"));
                    owner.setPhone(rs.getString("phone"));
                    owner.setAddress(rs.getString("address"));
                    owners.add(owner);
                }
            }
            
        } catch (SQLException e) {
            System.err.println("Error searching owners by name: " + e.getMessage());
            e.printStackTrace();
        }
        
        return owners;
    }
}
