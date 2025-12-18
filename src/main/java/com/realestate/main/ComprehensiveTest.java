package com.realestate.main;

import com.realestate.dao.AppointmentDAO;
import com.realestate.dao.PaymentDAO;
import com.realestate.dao.PropertyDAO;
import com.realestate.model.Appointment;
import com.realestate.model.Payment;
import com.realestate.model.Property;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class ComprehensiveTest {
    public static void main(String[] args) {
        System.out.println("=== Comprehensive DAO Test ===");
        
        // Test PropertyDAO
        testPropertyDAO();
        
        // Test AppointmentDAO
        testAppointmentDAO();
        
        // Test PaymentDAO
        testPaymentDAO();
        
        System.out.println("=== All Tests Completed ===");
    }
    
    private static void testPropertyDAO() {
        System.out.println("\n--- Testing PropertyDAO ---");
        PropertyDAO propertyDAO = new PropertyDAO();
        
        // Add a new property
        Property property = new Property();
        property.setPropertyName("Sunset Villa");
        property.setLocation("Miami Beach");
        property.setAreaSqft(2500);
        property.setPrice(750000.0);
        property.setStatus("Available");
        
        boolean added = propertyDAO.addProperty(property);
        System.out.println("Property added: " + added);
        
        // Get all properties
        List<Property> properties = propertyDAO.getAllProperties();
        System.out.println("Total properties: " + properties.size());
        
        if (!properties.isEmpty()) {
            Property latestProperty = properties.get(properties.size() - 1);
            int propertyId = latestProperty.getPropertyId();
            System.out.println("Latest property ID: " + propertyId);
            
            // Update property price
            boolean priceUpdated = propertyDAO.updatePropertyPrice(propertyId, 725000.0);
            System.out.println("Property price updated: " + priceUpdated);
            
            // Update property status
            boolean statusUpdated = propertyDAO.updatePropertyStatus(propertyId, "Sold");
            System.out.println("Property status updated: " + statusUpdated);
            
            // Search by status
            List<Property> soldProperties = propertyDAO.searchByStatus("Sold");
            System.out.println("Sold properties: " + soldProperties.size());
        }
    }
    
    private static void testAppointmentDAO() {
        System.out.println("\n--- Testing AppointmentDAO ---");
        AppointmentDAO appointmentDAO = new AppointmentDAO();
        
        // Get a property ID to use for the appointment
        PropertyDAO propertyDAO = new PropertyDAO();
        List<Property> properties = propertyDAO.getAllProperties();
        
        if (!properties.isEmpty()) {
            int propertyId = properties.get(0).getPropertyId();
            
            // Add a new appointment
            Appointment appointment = new Appointment();
            appointment.setPropertyId(propertyId);
            appointment.setClientName("Alice Johnson");
            appointment.setAppointmentDate(LocalDate.now().plusDays(7));
            appointment.setAppointmentTime(LocalTime.of(14, 30));
            appointment.setStatus("Scheduled");
            
            boolean added = appointmentDAO.addAppointment(appointment);
            System.out.println("Appointment added: " + added);
            
            // Get all appointments
            List<Appointment> appointments = appointmentDAO.getAllAppointments();
            System.out.println("Total appointments: " + appointments.size());
            
            if (!appointments.isEmpty()) {
                Appointment latestAppointment = appointments.get(appointments.size() - 1);
                int appointmentId = latestAppointment.getAppointmentId();
                System.out.println("Latest appointment ID: " + appointmentId);
                
                // Update appointment status
                boolean statusUpdated = appointmentDAO.updateAppointmentStatus(appointmentId, "Completed");
                System.out.println("Appointment status updated: " + statusUpdated);
            }
        } else {
            System.out.println("No properties available to create appointment");
        }
    }
    
    private static void testPaymentDAO() {
        System.out.println("\n--- Testing PaymentDAO ---");
        PaymentDAO paymentDAO = new PaymentDAO();
        
        // Get a property ID to use for the payment
        PropertyDAO propertyDAO = new PropertyDAO();
        List<Property> properties = propertyDAO.getAllProperties();
        
        if (!properties.isEmpty()) {
            int propertyId = properties.get(0).getPropertyId();
            
            // Add a new payment
            Payment payment = new Payment();
            payment.setPropertyId(propertyId);
            payment.setPayerName("Bob Smith");
            payment.setAmount(725000.0);
            payment.setPaymentDate(LocalDate.now());
            payment.setPaymentMode("Bank Transfer");
            
            boolean added = paymentDAO.addPayment(payment);
            System.out.println("Payment added: " + added);
            
            // Get all payments
            List<Payment> payments = paymentDAO.getAllPayments();
            System.out.println("Total payments: " + payments.size());
            
            if (!payments.isEmpty()) {
                Payment latestPayment = payments.get(payments.size() - 1);
                int paymentId = latestPayment.getPaymentId();
                System.out.println("Latest payment ID: " + paymentId);
                
                // Update payment amount
                boolean amountUpdated = paymentDAO.updatePaymentAmount(paymentId, 720000.0);
                System.out.println("Payment amount updated: " + amountUpdated);
            }
        } else {
            System.out.println("No properties available to create payment");
        }
    }
}