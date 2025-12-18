package com.realestate.dao;

import com.realestate.model.Agent;
import com.realestate.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AgentDAO {
    
    // Method to add a new agent
    public boolean addAgent(Agent agent) {
        String sql = "INSERT INTO agents (agent_name, email, phone, specialization) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, agent.getAgentName());
            stmt.setString(2, agent.getEmail());
            stmt.setString(3, agent.getPhone());
            stmt.setString(4, agent.getSpecialization());
            
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
            
        } catch (SQLException e) {
            System.err.println("Error adding agent: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    // Method to get all agents
    public List<Agent> getAllAgents() {
        List<Agent> agents = new ArrayList<>();
        String sql = "SELECT * FROM agents";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                Agent agent = new Agent();
                agent.setAgentId(rs.getInt("agent_id"));
                agent.setAgentName(rs.getString("agent_name"));
                agent.setEmail(rs.getString("email"));
                agent.setPhone(rs.getString("phone"));
                agent.setSpecialization(rs.getString("specialization"));
                agents.add(agent);
            }
            
        } catch (SQLException e) {
            System.err.println("Error retrieving agents: " + e.getMessage());
            e.printStackTrace();
        }
        
        return agents;
    }
    
    // Method to get agent by ID
    public Agent getAgentById(int agentId) {
        String sql = "SELECT * FROM agents WHERE agent_id = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, agentId);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Agent agent = new Agent();
                    agent.setAgentId(rs.getInt("agent_id"));
                    agent.setAgentName(rs.getString("agent_name"));
                    agent.setEmail(rs.getString("email"));
                    agent.setPhone(rs.getString("phone"));
                    agent.setSpecialization(rs.getString("specialization"));
                    return agent;
                }
            }
            
        } catch (SQLException e) {
            System.err.println("Error retrieving agent by ID: " + e.getMessage());
            e.printStackTrace();
        }
        
        return null;
    }
    
    // Method to update agent
    public boolean updateAgent(Agent agent) {
        String sql = "UPDATE agents SET agent_name = ?, email = ?, phone = ?, specialization = ? WHERE agent_id = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, agent.getAgentName());
            stmt.setString(2, agent.getEmail());
            stmt.setString(3, agent.getPhone());
            stmt.setString(4, agent.getSpecialization());
            stmt.setInt(5, agent.getAgentId());
            
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
            
        } catch (SQLException e) {
            System.err.println("Error updating agent: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    // Method to delete an agent
    public boolean deleteAgent(int agentId) {
        String sql = "DELETE FROM agents WHERE agent_id = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, agentId);
            
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
            
        } catch (SQLException e) {
            System.err.println("Error deleting agent: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    // Method to search agents by name
    public List<Agent> searchByName(String name) {
        List<Agent> agents = new ArrayList<>();
        String sql = "SELECT * FROM agents WHERE agent_name LIKE ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, "%" + name + "%");
            
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Agent agent = new Agent();
                    agent.setAgentId(rs.getInt("agent_id"));
                    agent.setAgentName(rs.getString("agent_name"));
                    agent.setEmail(rs.getString("email"));
                    agent.setPhone(rs.getString("phone"));
                    agent.setSpecialization(rs.getString("specialization"));
                    agents.add(agent);
                }
            }
            
        } catch (SQLException e) {
            System.err.println("Error searching agents by name: " + e.getMessage());
            e.printStackTrace();
        }
        
        return agents;
    }
    
    // Method to search agents by specialization
    public List<Agent> searchBySpecialization(String specialization) {
        List<Agent> agents = new ArrayList<>();
        String sql = "SELECT * FROM agents WHERE specialization LIKE ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, "%" + specialization + "%");
            
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Agent agent = new Agent();
                    agent.setAgentId(rs.getInt("agent_id"));
                    agent.setAgentName(rs.getString("agent_name"));
                    agent.setEmail(rs.getString("email"));
                    agent.setPhone(rs.getString("phone"));
                    agent.setSpecialization(rs.getString("specialization"));
                    agents.add(agent);
                }
            }
            
        } catch (SQLException e) {
            System.err.println("Error searching agents by specialization: " + e.getMessage());
            e.printStackTrace();
        }
        
        return agents;
    }
}
