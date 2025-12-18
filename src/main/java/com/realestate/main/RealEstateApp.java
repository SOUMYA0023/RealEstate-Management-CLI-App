package com.realestate.main;

import com.realestate.dao.PropertyDAO;
import com.realestate.model.Property;

import java.util.List;
import java.util.Scanner;

public class RealEstateApp {
    private static PropertyDAO propertyDAO = new PropertyDAO();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== Real Estate Management System ===");
        
        boolean running = true;
        while (running) {
            displayMenu();
            int choice = getIntInput("Enter your choice: ");
            
            switch (choice) {
                case 1:
                    addNewProperty();
                    break;
                case 2:
                    viewAllProperties();
                    break;
                case 3:
                    searchPropertiesByLocation();
                    break;
                case 4:
                    searchPropertiesByStatus();
                    break;
                case 5:
                    updatePropertyPrice();
                    break;
                case 6:
                    updatePropertyStatus();
                    break;
                case 7:
                    deleteProperty();
                    break;
                case 8:
                    System.out.println("Thank you for using Real Estate Management System!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a number between 1-8.");
            }
        }
        
        scanner.close();
    }
    
    private static void displayMenu() {
        System.out.println("\n=== MENU ===");
        System.out.println("1. Add new property");
        System.out.println("2. View all properties");
        System.out.println("3. Search properties by location");
        System.out.println("4. Search properties by status");
        System.out.println("5. Update property price");
        System.out.println("6. Update property status");
        System.out.println("7. Delete property");
        System.out.println("8. Exit");
        System.out.println("=============");
    }
    
    private static void addNewProperty() {
        System.out.println("\n--- Add New Property ---");
        
        System.out.print("Enter property name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter location: ");
        String location = scanner.nextLine();
        
        int areaSqft = getPositiveIntegerInput("Enter area (in sq ft): ");
        double price = getPositiveDoubleInput("Enter price: ");
        
        System.out.print("Enter property type (Residential/Commercial/Land): ");
        String propertyType = scanner.nextLine();
        
        System.out.print("Enter status (Available/Sold/Rented): ");
        String status = scanner.nextLine();
        
        // Validate status
        while (!isValidStatus(status)) {
            System.out.print("Invalid status! Please enter Available, Sold, or Rented: ");
            status = scanner.nextLine();
        }
        
        Property property = new Property(0, name, location, areaSqft, price, status);
        property.setPropertyType(propertyType);
        if (propertyDAO.addProperty(property)) {
            System.out.println("Property added successfully!");
        } else {
            System.out.println("Failed to add property!");
        }
    }
    
    private static void viewAllProperties() {
        System.out.println("\n--- All Properties ---");
        List<Property> properties = propertyDAO.getAllProperties();
        
        if (properties.isEmpty()) {
            System.out.println("No properties found!");
            return;
        }
        
        printPropertyTable(properties);
    }
    
    private static void searchPropertiesByLocation() {
        System.out.println("\n--- Search Properties by Location ---");
        System.out.print("Enter location: ");
        String location = scanner.nextLine();
        
        List<Property> properties = propertyDAO.searchByLocation(location);
        
        if (properties.isEmpty()) {
            System.out.println("No properties found for location: " + location);
            return;
        }
        
        System.out.println("Properties found for location: " + location);
        printPropertyTable(properties);
    }
    
    private static void searchPropertiesByStatus() {
        System.out.println("\n--- Search Properties by Status ---");
        System.out.print("Enter status (Available/Sold/Rented): ");
        String status = scanner.nextLine();
        
        // Validate status
        while (!isValidStatus(status)) {
            System.out.print("Invalid status! Please enter Available, Sold, or Rented: ");
            status = scanner.nextLine();
        }
        
        List<Property> properties = propertyDAO.searchByStatus(status);
        
        if (properties.isEmpty()) {
            System.out.println("No properties found with status: " + status);
            return;
        }
        
        System.out.println("Properties found with status: " + status);
        printPropertyTable(properties);
    }
    
    private static void updatePropertyPrice() {
        System.out.println("\n--- Update Property Price ---");
        int propertyId = getIntInput("Enter property ID: ");
        double newPrice = getPositiveDoubleInput("Enter new price: ");
        
        if (propertyDAO.updatePropertyPrice(propertyId, newPrice)) {
            System.out.println("Property price updated successfully!");
        } else {
            System.out.println("Failed to update property price! Property ID may not exist.");
        }
    }
    
    private static void updatePropertyStatus() {
        System.out.println("\n--- Update Property Status ---");
        int propertyId = getIntInput("Enter property ID: ");
        
        System.out.print("Enter new status (Available/Sold/Rented): ");
        String newStatus = scanner.nextLine();
        
        // Validate status
        while (!isValidStatus(newStatus)) {
            System.out.print("Invalid status! Please enter Available, Sold, or Rented: ");
            newStatus = scanner.nextLine();
        }
        
        if (propertyDAO.updatePropertyStatus(propertyId, newStatus)) {
            System.out.println("Property status updated successfully!");
        } else {
            System.out.println("Failed to update property status! Property ID may not exist.");
        }
    }
    
    private static void deleteProperty() {
        System.out.println("\n--- Delete Property ---");
        int propertyId = getIntInput("Enter property ID to delete: ");
        
        if (propertyDAO.deleteProperty(propertyId)) {
            System.out.println("Property deleted successfully!");
        } else {
            System.out.println("Failed to delete property! Property ID may not exist.");
        }
    }
    
    private static int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                int value = Integer.parseInt(scanner.nextLine());
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid integer.");
            }
        }
    }
    
    private static double getPositiveDoubleInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                double value = Double.parseDouble(scanner.nextLine());
                if (value > 0) {
                    return value;
                } else {
                    System.out.println("Value must be greater than 0!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number.");
            }
        }
    }
    
    private static int getPositiveIntegerInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                int value = Integer.parseInt(scanner.nextLine());
                if (value > 0) {
                    return value;
                } else {
                    System.out.println("Value must be greater than 0!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid integer.");
            }
        }
    }
    
    private static boolean isValidStatus(String status) {
        return "Available".equalsIgnoreCase(status) || 
               "Sold".equalsIgnoreCase(status) || 
               "Rented".equalsIgnoreCase(status);
    }
    
    private static void printPropertyTable(List<Property> properties) {
        System.out.printf("%-5s %-20s %-15s %-10s %-12s %-10s %-15s%n", 
                "ID", "Name", "Location", "Area(sqft)", "Price", "Status", "Type");
        System.out.println("-------------------------------------------------------------------------------------------");
        
        for (Property property : properties) {
            System.out.printf("%-5d %-20s %-15s %-10d %-12.2f %-10s %-15s%n",
                    property.getPropertyId(),
                    property.getPropertyName(),
                    property.getLocation(),
                    property.getAreaSqft(),
                    property.getPrice(),
                    property.getStatus(),
                    property.getPropertyType());
        }
        System.out.println("-------------------------------------------------------------------------------------------");
    }
}