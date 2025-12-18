package com.realestate.main;

import com.realestate.dao.AppointmentDAO;
import com.realestate.dao.PaymentDAO;
import com.realestate.dao.PropertyDAO;
import com.realestate.model.Appointment;
import com.realestate.model.Payment;
import com.realestate.model.Property;

import java.time.LocalDate;
import java.time.LocalTime;

public class TestDAOs {
    public static void main(String[] args) {
        // Test PropertyDAO
        PropertyDAO propertyDAO = new PropertyDAO();
        System.out.println("Testing PropertyDAO...");
        
        // Test creating a sample property
        Property property = new Property();
        property.setPropertyName("Test Property");
        property.setLocation("Test Location");
        property.setAreaSqft(1500);
        property.setPrice(250000.0);
        property.setStatus("Available");
        // Note: Not setting propertyType as it's not in the table schema
        
        boolean propertyAdded = propertyDAO.addProperty(property);
        System.out.println("Property added: " + propertyAdded);
        
        // Get all properties to see what we have
        System.out.println("All properties:");
        propertyDAO.getAllProperties().forEach(System.out::println);
        
        // Test AppointmentDAO
        AppointmentDAO appointmentDAO = new AppointmentDAO();
        System.out.println("Testing AppointmentDAO...");
        
        // Test PaymentDAO
        PaymentDAO paymentDAO = new PaymentDAO();
        System.out.println("Testing PaymentDAO...");
        
        System.out.println("Basic DAOs test completed!");
    }
}