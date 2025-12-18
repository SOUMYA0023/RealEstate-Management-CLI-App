package com.realestate.dao;

import com.realestate.model.Appointment;
import com.realestate.util.DBConnection;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDAO {

    // Method to add a new appointment
    public boolean addAppointment(Appointment appointment) {
        String sql = "INSERT INTO appointment (property_id, client_name, appointment_date, appointment_time, status) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, appointment.getPropertyId());
            stmt.setString(2, appointment.getClientName());
            stmt.setDate(3, Date.valueOf(appointment.getAppointmentDate()));
            stmt.setTime(4, Time.valueOf(appointment.getAppointmentTime()));
            stmt.setString(5, appointment.getStatus());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.err.println("Error adding appointment: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    // Method to get all appointments
    public List<Appointment> getAllAppointments() {
        List<Appointment> appointments = new ArrayList<>();
        String sql = "SELECT * FROM appointment";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Appointment appointment = new Appointment();
                appointment.setAppointmentId(rs.getInt("appointment_id"));
                appointment.setPropertyId(rs.getInt("property_id"));
                appointment.setClientName(rs.getString("client_name"));
                appointment.setAppointmentDate(rs.getDate("appointment_date").toLocalDate());
                appointment.setAppointmentTime(rs.getTime("appointment_time").toLocalTime());
                appointment.setStatus(rs.getString("status"));
                appointments.add(appointment);
            }

        } catch (SQLException e) {
            System.err.println("Error retrieving appointments: " + e.getMessage());
            e.printStackTrace();
        }

        return appointments;
    }

    // Method to get appointment by ID
    public Appointment getAppointmentById(int appointmentId) {
        String sql = "SELECT * FROM appointment WHERE appointment_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, appointmentId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Appointment appointment = new Appointment();
                    appointment.setAppointmentId(rs.getInt("appointment_id"));
                    appointment.setPropertyId(rs.getInt("property_id"));
                    appointment.setClientName(rs.getString("client_name"));
                    appointment.setAppointmentDate(rs.getDate("appointment_date").toLocalDate());
                    appointment.setAppointmentTime(rs.getTime("appointment_time").toLocalTime());
                    appointment.setStatus(rs.getString("status"));
                    return appointment;
                }
            }

        } catch (SQLException e) {
            System.err.println("Error retrieving appointment: " + e.getMessage());
            e.printStackTrace();
        }

        return null;
    }

    // Method to get appointments by property ID
    public List<Appointment> getAppointmentsByPropertyId(int propertyId) {
        List<Appointment> appointments = new ArrayList<>();
        String sql = "SELECT * FROM appointment WHERE property_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, propertyId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Appointment appointment = new Appointment();
                    appointment.setAppointmentId(rs.getInt("appointment_id"));
                    appointment.setPropertyId(rs.getInt("property_id"));
                    appointment.setClientName(rs.getString("client_name"));
                    appointment.setAppointmentDate(rs.getDate("appointment_date").toLocalDate());
                    appointment.setAppointmentTime(rs.getTime("appointment_time").toLocalTime());
                    appointment.setStatus(rs.getString("status"));
                    appointments.add(appointment);
                }
            }

        } catch (SQLException e) {
            System.err.println("Error retrieving appointments by property ID: " + e.getMessage());
            e.printStackTrace();
        }

        return appointments;
    }

    // Method to update appointment status
    public boolean updateAppointmentStatus(int appointmentId, String newStatus) {
        String sql = "UPDATE appointment SET status = ? WHERE appointment_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, newStatus);
            stmt.setInt(2, appointmentId);

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.err.println("Error updating appointment status: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    // Method to delete an appointment
    public boolean deleteAppointment(int appointmentId) {
        String sql = "DELETE FROM appointment WHERE appointment_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, appointmentId);

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.err.println("Error deleting appointment: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}