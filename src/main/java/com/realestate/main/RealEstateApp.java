package com.realestate.main;

import com.realestate.dao.*;
import com.realestate.model.*;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class RealEstateApp {
    private static PropertyDAO propertyDAO = new PropertyDAO();
    private static OwnerDAO ownerDAO = new OwnerDAO();
    private static CustomerDAO customerDAO = new CustomerDAO();
    private static AgentDAO agentDAO = new AgentDAO();
    private static TransactionDAO transactionDAO = new TransactionDAO();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== Real Estate Management System ===");
        System.out.println("Welcome to the Real Estate Management System");
        
        boolean running = true;
        while (running) {
            showMainMenu();
            int choice = getIntInput("Enter your choice: ");
            
            switch (choice) {
                case 1:
                    showPropertiesMenu();
                    break;
                case 2:
                    showOwnersMenu();
                    break;
                case 3:
                    showCustomersMenu();
                    break;
                case 4:
                    showAgentsMenu();
                    break;
                case 5:
                    showTransactionsMenu();
                    break;
                case 6:
                    System.out.println("\nThank you for using Real Estate Management System!");
                    System.out.println("Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("\n[ERROR] Invalid choice! Please enter a number between 1-6.");
            }
        }
        
        scanner.close();
    }
    
    // ========== MAIN MENU ==========
    private static void showMainMenu() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("                  MAIN MENU");
        System.out.println("=".repeat(50));
        System.out.println("1. Properties Management");
        System.out.println("2. Owners Management");
        System.out.println("3. Customers Management");
        System.out.println("4. Agents Management");
        System.out.println("5. Transactions Management");
        System.out.println("6. Exit");
        System.out.println("=".repeat(50));
    }
    
    // ========== PROPERTIES SUBMENU ==========
    private static void showPropertiesMenu() {
        boolean inMenu = true;
        while (inMenu) {
            System.out.println("\n" + "-".repeat(50));
            System.out.println("            PROPERTIES MANAGEMENT");
            System.out.println("-".repeat(50));
            System.out.println("1. Add new property");
            System.out.println("2. View all properties");
            System.out.println("3. Search properties by location");
            System.out.println("4. Search properties by status");
            System.out.println("5. Update property price");
            System.out.println("6. Update property status");
            System.out.println("7. Delete property");
            System.out.println("8. Back to main menu");
            System.out.println("-".repeat(50));
            
            int choice = getIntInput("Enter your choice: ");
            
            switch (choice) {
                case 1: addNewProperty(); break;
                case 2: viewAllProperties(); break;
                case 3: searchPropertiesByLocation(); break;
                case 4: searchPropertiesByStatus(); break;
                case 5: updatePropertyPrice(); break;
                case 6: updatePropertyStatus(); break;
                case 7: deleteProperty(); break;
                case 8: 
                    inMenu = false;
                    System.out.println("\nReturning to main menu...");
                    break;
                default:
                    System.out.println("\n[ERROR] Invalid choice! Please enter a number between 1-8.");
            }
        }
    }
    
    // ========== OWNERS SUBMENU ==========
    private static void showOwnersMenu() {
        boolean inMenu = true;
        while (inMenu) {
            System.out.println("\n" + "-".repeat(50));
            System.out.println("              OWNERS MANAGEMENT");
            System.out.println("-".repeat(50));
            System.out.println("1. Add new owner");
            System.out.println("2. View all owners");
            System.out.println("3. Search owner by ID");
            System.out.println("4. Search owners by name");
            System.out.println("5. Update owner");
            System.out.println("6. Delete owner");
            System.out.println("7. Back to main menu");
            System.out.println("-".repeat(50));
            
            int choice = getIntInput("Enter your choice: ");
            
            switch (choice) {
                case 1: addNewOwner(); break;
                case 2: viewAllOwners(); break;
                case 3: searchOwnerById(); break;
                case 4: searchOwnersByName(); break;
                case 5: updateOwner(); break;
                case 6: deleteOwner(); break;
                case 7: 
                    inMenu = false;
                    System.out.println("\nReturning to main menu...");
                    break;
                default:
                    System.out.println("\n[ERROR] Invalid choice! Please enter a number between 1-7.");
            }
        }
    }
    
    // ========== CUSTOMERS SUBMENU ==========
    private static void showCustomersMenu() {
        boolean inMenu = true;
        while (inMenu) {
            System.out.println("\n" + "-".repeat(50));
            System.out.println("            CUSTOMERS MANAGEMENT");
            System.out.println("-".repeat(50));
            System.out.println("1. Add new customer");
            System.out.println("2. View all customers");
            System.out.println("3. Search customer by ID");
            System.out.println("4. Search customers by name");
            System.out.println("5. Update customer");
            System.out.println("6. Delete customer");
            System.out.println("7. Back to main menu");
            System.out.println("-".repeat(50));
            
            int choice = getIntInput("Enter your choice: ");
            
            switch (choice) {
                case 1: addNewCustomer(); break;
                case 2: viewAllCustomers(); break;
                case 3: searchCustomerById(); break;
                case 4: searchCustomersByName(); break;
                case 5: updateCustomer(); break;
                case 6: deleteCustomer(); break;
                case 7: 
                    inMenu = false;
                    System.out.println("\nReturning to main menu...");
                    break;
                default:
                    System.out.println("\n[ERROR] Invalid choice! Please enter a number between 1-7.");
            }
        }
    }
    
    // ========== AGENTS SUBMENU ==========
    private static void showAgentsMenu() {
        boolean inMenu = true;
        while (inMenu) {
            System.out.println("\n" + "-".repeat(50));
            System.out.println("              AGENTS MANAGEMENT");
            System.out.println("-".repeat(50));
            System.out.println("1. Add new agent");
            System.out.println("2. View all agents");
            System.out.println("3. Search agent by ID");
            System.out.println("4. Search agents by name");
            System.out.println("5. Search agents by specialization");
            System.out.println("6. Update agent");
            System.out.println("7. Delete agent");
            System.out.println("8. Back to main menu");
            System.out.println("-".repeat(50));
            
            int choice = getIntInput("Enter your choice: ");
            
            switch (choice) {
                case 1: addNewAgent(); break;
                case 2: viewAllAgents(); break;
                case 3: searchAgentById(); break;
                case 4: searchAgentsByName(); break;
                case 5: searchAgentsBySpecialization(); break;
                case 6: updateAgent(); break;
                case 7: deleteAgent(); break;
                case 8: 
                    inMenu = false;
                    System.out.println("\nReturning to main menu...");
                    break;
                default:
                    System.out.println("\n[ERROR] Invalid choice! Please enter a number between 1-8.");
            }
        }
    }
    
    // ========== TRANSACTIONS SUBMENU ==========
    private static void showTransactionsMenu() {
        boolean inMenu = true;
        while (inMenu) {
            System.out.println("\n" + "-".repeat(50));
            System.out.println("           TRANSACTIONS MANAGEMENT");
            System.out.println("-".repeat(50));
            System.out.println("1. Add new transaction");
            System.out.println("2. View all transactions");
            System.out.println("3. Search transaction by ID");
            System.out.println("4. View transactions by property");
            System.out.println("5. View transactions by customer");
            System.out.println("6. View transactions by agent");
            System.out.println("7. View transactions by type");
            System.out.println("8. Delete transaction");
            System.out.println("9. Back to main menu");
            System.out.println("-".repeat(50));
            
            int choice = getIntInput("Enter your choice: ");
            
            switch (choice) {
                case 1: addNewTransaction(); break;
                case 2: viewAllTransactions(); break;
                case 3: searchTransactionById(); break;
                case 4: viewTransactionsByProperty(); break;
                case 5: viewTransactionsByCustomer(); break;
                case 6: viewTransactionsByAgent(); break;
                case 7: viewTransactionsByType(); break;
                case 8: deleteTransaction(); break;
                case 9: 
                    inMenu = false;
                    System.out.println("\nReturning to main menu...");
                    break;
                default:
                    System.out.println("\n[ERROR] Invalid choice! Please enter a number between 1-9.");
            }
        }
    }
    
    // ========== PROPERTY MANAGEMENT ==========
    
    private static void addNewProperty() {
        System.out.println("\n" + "*".repeat(40));
        System.out.println("         ADD NEW PROPERTY");
        System.out.println("*".repeat(40));
        
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
            System.out.println("\n[SUCCESS] Property added successfully!");
        } else {
            System.out.println("\n[ERROR] Failed to add property!");
        }
    }
    
    private static void viewAllProperties() {
        System.out.println("\n" + "*".repeat(40));
        System.out.println("         ALL PROPERTIES");
        System.out.println("*".repeat(40));
        List<Property> properties = propertyDAO.getAllProperties();
        
        if (properties.isEmpty()) {
            System.out.println("\n[INFO] No properties found!");
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
    
    // ========== OWNER MANAGEMENT ==========
    
    private static void addNewOwner() {
        System.out.println("\n--- Add New Owner ---");
        System.out.print("Enter owner name: ");
        String name = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter phone: ");
        String phone = scanner.nextLine();
        System.out.print("Enter address: ");
        String address = scanner.nextLine();
        
        Owner owner = new Owner(0, name, email, phone, address);
        if (ownerDAO.addOwner(owner)) {
            System.out.println("Owner added successfully!");
        } else {
            System.out.println("Failed to add owner!");
        }
    }
    
    private static void viewAllOwners() {
        System.out.println("\n--- All Owners ---");
        List<Owner> owners = ownerDAO.getAllOwners();
        if (owners.isEmpty()) {
            System.out.println("No owners found!");
            return;
        }
        System.out.printf("%-5s %-20s %-25s %-15s %-30s%n", "ID", "Name", "Email", "Phone", "Address");
        System.out.println("-----------------------------------------------------------------------------------------------");
        for (Owner owner : owners) {
            System.out.printf("%-5d %-20s %-25s %-15s %-30s%n", owner.getOwnerId(), owner.getOwnerName(), 
                owner.getEmail(), owner.getPhone(), owner.getAddress());
        }
    }
    
    private static void searchOwnerById() {
        int ownerId = getIntInput("Enter owner ID: ");
        Owner owner = ownerDAO.getOwnerById(ownerId);
        if (owner != null) {
            System.out.println("\nOwner Found:");
            System.out.println(owner);
        } else {
            System.out.println("Owner not found!");
        }
    }
    
    private static void searchOwnersByName() {
        System.out.print("Enter owner name: ");
        String name = scanner.nextLine();
        List<Owner> owners = ownerDAO.searchByName(name);
        if (owners.isEmpty()) {
            System.out.println("No owners found!");
            return;
        }
        System.out.printf("%-5s %-20s %-25s %-15s %-30s%n", "ID", "Name", "Email", "Phone", "Address");
        System.out.println("-----------------------------------------------------------------------------------------------");
        for (Owner owner : owners) {
            System.out.printf("%-5d %-20s %-25s %-15s %-30s%n", owner.getOwnerId(), owner.getOwnerName(), 
                owner.getEmail(), owner.getPhone(), owner.getAddress());
        }
    }
    
    private static void updateOwner() {
        int ownerId = getIntInput("Enter owner ID to update: ");
        Owner owner = ownerDAO.getOwnerById(ownerId);
        if (owner == null) {
            System.out.println("Owner not found!");
            return;
        }
        System.out.print("Enter new name (current: " + owner.getOwnerName() + "): ");
        String name = scanner.nextLine();
        System.out.print("Enter new email (current: " + owner.getEmail() + "): ");
        String email = scanner.nextLine();
        System.out.print("Enter new phone (current: " + owner.getPhone() + "): ");
        String phone = scanner.nextLine();
        System.out.print("Enter new address (current: " + owner.getAddress() + "): ");
        String address = scanner.nextLine();
        
        owner.setOwnerName(name.isEmpty() ? owner.getOwnerName() : name);
        owner.setEmail(email.isEmpty() ? owner.getEmail() : email);
        owner.setPhone(phone.isEmpty() ? owner.getPhone() : phone);
        owner.setAddress(address.isEmpty() ? owner.getAddress() : address);
        
        if (ownerDAO.updateOwner(owner)) {
            System.out.println("Owner updated successfully!");
        } else {
            System.out.println("Failed to update owner!");
        }
    }
    
    private static void deleteOwner() {
        int ownerId = getIntInput("Enter owner ID to delete: ");
        if (ownerDAO.deleteOwner(ownerId)) {
            System.out.println("Owner deleted successfully!");
        } else {
            System.out.println("Failed to delete owner!");
        }
    }
    
    // ========== CUSTOMER MANAGEMENT ==========
    
    private static void addNewCustomer() {
        System.out.println("\n--- Add New Customer ---");
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter phone: ");
        String phone = scanner.nextLine();
        System.out.print("Enter address: ");
        String address = scanner.nextLine();
        
        Customer customer = new Customer(0, name, email, phone, address);
        if (customerDAO.addCustomer(customer)) {
            System.out.println("Customer added successfully!");
        } else {
            System.out.println("Failed to add customer!");
        }
    }
    
    private static void viewAllCustomers() {
        System.out.println("\n--- All Customers ---");
        List<Customer> customers = customerDAO.getAllCustomers();
        if (customers.isEmpty()) {
            System.out.println("No customers found!");
            return;
        }
        System.out.printf("%-5s %-20s %-25s %-15s %-30s%n", "ID", "Name", "Email", "Phone", "Address");
        System.out.println("-----------------------------------------------------------------------------------------------");
        for (Customer customer : customers) {
            System.out.printf("%-5d %-20s %-25s %-15s %-30s%n", customer.getCustomerId(), customer.getCustomerName(), 
                customer.getEmail(), customer.getPhone(), customer.getAddress());
        }
    }
    
    private static void searchCustomerById() {
        int customerId = getIntInput("Enter customer ID: ");
        Customer customer = customerDAO.getCustomerById(customerId);
        if (customer != null) {
            System.out.println("\nCustomer Found:");
            System.out.println(customer);
        } else {
            System.out.println("Customer not found!");
        }
    }
    
    private static void searchCustomersByName() {
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();
        List<Customer> customers = customerDAO.searchByName(name);
        if (customers.isEmpty()) {
            System.out.println("No customers found!");
            return;
        }
        System.out.printf("%-5s %-20s %-25s %-15s %-30s%n", "ID", "Name", "Email", "Phone", "Address");
        System.out.println("-----------------------------------------------------------------------------------------------");
        for (Customer customer : customers) {
            System.out.printf("%-5d %-20s %-25s %-15s %-30s%n", customer.getCustomerId(), customer.getCustomerName(), 
                customer.getEmail(), customer.getPhone(), customer.getAddress());
        }
    }
    
    private static void updateCustomer() {
        int customerId = getIntInput("Enter customer ID to update: ");
        Customer customer = customerDAO.getCustomerById(customerId);
        if (customer == null) {
            System.out.println("Customer not found!");
            return;
        }
        System.out.print("Enter new name (current: " + customer.getCustomerName() + "): ");
        String name = scanner.nextLine();
        System.out.print("Enter new email (current: " + customer.getEmail() + "): ");
        String email = scanner.nextLine();
        System.out.print("Enter new phone (current: " + customer.getPhone() + "): ");
        String phone = scanner.nextLine();
        System.out.print("Enter new address (current: " + customer.getAddress() + "): ");
        String address = scanner.nextLine();
        
        customer.setCustomerName(name.isEmpty() ? customer.getCustomerName() : name);
        customer.setEmail(email.isEmpty() ? customer.getEmail() : email);
        customer.setPhone(phone.isEmpty() ? customer.getPhone() : phone);
        customer.setAddress(address.isEmpty() ? customer.getAddress() : address);
        
        if (customerDAO.updateCustomer(customer)) {
            System.out.println("Customer updated successfully!");
        } else {
            System.out.println("Failed to update customer!");
        }
    }
    
    private static void deleteCustomer() {
        int customerId = getIntInput("Enter customer ID to delete: ");
        if (customerDAO.deleteCustomer(customerId)) {
            System.out.println("Customer deleted successfully!");
        } else {
            System.out.println("Failed to delete customer!");
        }
    }
    
    // ========== AGENT MANAGEMENT ==========
    
    private static void addNewAgent() {
        System.out.println("\n--- Add New Agent ---");
        System.out.print("Enter agent name: ");
        String name = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter phone: ");
        String phone = scanner.nextLine();
        System.out.print("Enter specialization (Residential/Commercial/Land): ");
        String specialization = scanner.nextLine();
        
        Agent agent = new Agent(0, name, email, phone, specialization);
        if (agentDAO.addAgent(agent)) {
            System.out.println("Agent added successfully!");
        } else {
            System.out.println("Failed to add agent!");
        }
    }
    
    private static void viewAllAgents() {
        System.out.println("\n--- All Agents ---");
        List<Agent> agents = agentDAO.getAllAgents();
        if (agents.isEmpty()) {
            System.out.println("No agents found!");
            return;
        }
        System.out.printf("%-5s %-20s %-25s %-15s %-20s%n", "ID", "Name", "Email", "Phone", "Specialization");
        System.out.println("-------------------------------------------------------------------------------------------");
        for (Agent agent : agents) {
            System.out.printf("%-5d %-20s %-25s %-15s %-20s%n", agent.getAgentId(), agent.getAgentName(), 
                agent.getEmail(), agent.getPhone(), agent.getSpecialization());
        }
    }
    
    private static void searchAgentById() {
        int agentId = getIntInput("Enter agent ID: ");
        Agent agent = agentDAO.getAgentById(agentId);
        if (agent != null) {
            System.out.println("\nAgent Found:");
            System.out.println(agent);
        } else {
            System.out.println("Agent not found!");
        }
    }
    
    private static void searchAgentsByName() {
        System.out.print("Enter agent name: ");
        String name = scanner.nextLine();
        List<Agent> agents = agentDAO.searchByName(name);
        if (agents.isEmpty()) {
            System.out.println("No agents found!");
            return;
        }
        System.out.printf("%-5s %-20s %-25s %-15s %-20s%n", "ID", "Name", "Email", "Phone", "Specialization");
        System.out.println("-------------------------------------------------------------------------------------------");
        for (Agent agent : agents) {
            System.out.printf("%-5d %-20s %-25s %-15s %-20s%n", agent.getAgentId(), agent.getAgentName(), 
                agent.getEmail(), agent.getPhone(), agent.getSpecialization());
        }
    }
    
    private static void searchAgentsBySpecialization() {
        System.out.print("Enter specialization: ");
        String specialization = scanner.nextLine();
        List<Agent> agents = agentDAO.searchBySpecialization(specialization);
        if (agents.isEmpty()) {
            System.out.println("No agents found!");
            return;
        }
        System.out.printf("%-5s %-20s %-25s %-15s %-20s%n", "ID", "Name", "Email", "Phone", "Specialization");
        System.out.println("-------------------------------------------------------------------------------------------");
        for (Agent agent : agents) {
            System.out.printf("%-5d %-20s %-25s %-15s %-20s%n", agent.getAgentId(), agent.getAgentName(), 
                agent.getEmail(), agent.getPhone(), agent.getSpecialization());
        }
    }
    
    private static void updateAgent() {
        int agentId = getIntInput("Enter agent ID to update: ");
        Agent agent = agentDAO.getAgentById(agentId);
        if (agent == null) {
            System.out.println("Agent not found!");
            return;
        }
        System.out.print("Enter new name (current: " + agent.getAgentName() + "): ");
        String name = scanner.nextLine();
        System.out.print("Enter new email (current: " + agent.getEmail() + "): ");
        String email = scanner.nextLine();
        System.out.print("Enter new phone (current: " + agent.getPhone() + "): ");
        String phone = scanner.nextLine();
        System.out.print("Enter new specialization (current: " + agent.getSpecialization() + "): ");
        String specialization = scanner.nextLine();
        
        agent.setAgentName(name.isEmpty() ? agent.getAgentName() : name);
        agent.setEmail(email.isEmpty() ? agent.getEmail() : email);
        agent.setPhone(phone.isEmpty() ? agent.getPhone() : phone);
        agent.setSpecialization(specialization.isEmpty() ? agent.getSpecialization() : specialization);
        
        if (agentDAO.updateAgent(agent)) {
            System.out.println("Agent updated successfully!");
        } else {
            System.out.println("Failed to update agent!");
        }
    }
    
    private static void deleteAgent() {
        int agentId = getIntInput("Enter agent ID to delete: ");
        if (agentDAO.deleteAgent(agentId)) {
            System.out.println("Agent deleted successfully!");
        } else {
            System.out.println("Failed to delete agent!");
        }
    }
    
    // ========== TRANSACTION MANAGEMENT ==========
    
    private static void addNewTransaction() {
        System.out.println("\n--- Add New Transaction ---");
        int propertyId = getIntInput("Enter property ID: ");
        int customerId = getIntInput("Enter customer ID: ");
        int agentId = getIntInput("Enter agent ID: ");
        System.out.print("Enter transaction type (Sale/Rent/Lease): ");
        String type = scanner.nextLine();
        double amount = getPositiveDoubleInput("Enter transaction amount: ");
        System.out.print("Enter transaction date (YYYY-MM-DD): ");
        String dateStr = scanner.nextLine();
        
        try {
            Date date = Date.valueOf(dateStr);
            Transaction transaction = new Transaction(0, propertyId, customerId, agentId, type, amount, date);
            if (transactionDAO.addTransaction(transaction)) {
                System.out.println("Transaction added successfully!");
            } else {
                System.out.println("Failed to add transaction!");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid date format! Please use YYYY-MM-DD format.");
        }
    }
    
    private static void viewAllTransactions() {
        System.out.println("\n--- All Transactions ---");
        List<Transaction> transactions = transactionDAO.getAllTransactions();
        if (transactions.isEmpty()) {
            System.out.println("No transactions found!");
            return;
        }
        System.out.printf("%-5s %-12s %-12s %-10s %-12s %-15s %-12s%n", 
            "ID", "Property ID", "Customer ID", "Agent ID", "Type", "Amount", "Date");
        System.out.println("--------------------------------------------------------------------------------------------");
        for (Transaction t : transactions) {
            System.out.printf("%-5d %-12d %-12d %-10d %-12s %-15.2f %-12s%n", 
                t.getTransactionId(), t.getPropertyId(), t.getCustomerId(), t.getAgentId(), 
                t.getTransactionType(), t.getTransactionAmount(), t.getTransactionDate());
        }
    }
    
    private static void searchTransactionById() {
        int transactionId = getIntInput("Enter transaction ID: ");
        Transaction transaction = transactionDAO.getTransactionById(transactionId);
        if (transaction != null) {
            System.out.println("\nTransaction Found:");
            System.out.println(transaction);
        } else {
            System.out.println("Transaction not found!");
        }
    }
    
    private static void viewTransactionsByProperty() {
        int propertyId = getIntInput("Enter property ID: ");
        List<Transaction> transactions = transactionDAO.getTransactionsByPropertyId(propertyId);
        if (transactions.isEmpty()) {
            System.out.println("No transactions found for this property!");
            return;
        }
        System.out.printf("%-5s %-12s %-12s %-10s %-12s %-15s %-12s%n", 
            "ID", "Property ID", "Customer ID", "Agent ID", "Type", "Amount", "Date");
        System.out.println("--------------------------------------------------------------------------------------------");
        for (Transaction t : transactions) {
            System.out.printf("%-5d %-12d %-12d %-10d %-12s %-15.2f %-12s%n", 
                t.getTransactionId(), t.getPropertyId(), t.getCustomerId(), t.getAgentId(), 
                t.getTransactionType(), t.getTransactionAmount(), t.getTransactionDate());
        }
    }
    
    private static void viewTransactionsByCustomer() {
        int customerId = getIntInput("Enter customer ID: ");
        List<Transaction> transactions = transactionDAO.getTransactionsByCustomerId(customerId);
        if (transactions.isEmpty()) {
            System.out.println("No transactions found for this customer!");
            return;
        }
        System.out.printf("%-5s %-12s %-12s %-10s %-12s %-15s %-12s%n", 
            "ID", "Property ID", "Customer ID", "Agent ID", "Type", "Amount", "Date");
        System.out.println("--------------------------------------------------------------------------------------------");
        for (Transaction t : transactions) {
            System.out.printf("%-5d %-12d %-12d %-10d %-12s %-15.2f %-12s%n", 
                t.getTransactionId(), t.getPropertyId(), t.getCustomerId(), t.getAgentId(), 
                t.getTransactionType(), t.getTransactionAmount(), t.getTransactionDate());
        }
    }
    
    private static void viewTransactionsByAgent() {
        int agentId = getIntInput("Enter agent ID: ");
        List<Transaction> transactions = transactionDAO.getTransactionsByAgentId(agentId);
        if (transactions.isEmpty()) {
            System.out.println("No transactions found for this agent!");
            return;
        }
        System.out.printf("%-5s %-12s %-12s %-10s %-12s %-15s %-12s%n", 
            "ID", "Property ID", "Customer ID", "Agent ID", "Type", "Amount", "Date");
        System.out.println("--------------------------------------------------------------------------------------------");
        for (Transaction t : transactions) {
            System.out.printf("%-5d %-12d %-12d %-10d %-12s %-15.2f %-12s%n", 
                t.getTransactionId(), t.getPropertyId(), t.getCustomerId(), t.getAgentId(), 
                t.getTransactionType(), t.getTransactionAmount(), t.getTransactionDate());
        }
    }
    
    private static void viewTransactionsByType() {
        System.out.print("Enter transaction type (Sale/Rent/Lease): ");
        String type = scanner.nextLine();
        List<Transaction> transactions = transactionDAO.getTransactionsByType(type);
        if (transactions.isEmpty()) {
            System.out.println("No transactions found for this type!");
            return;
        }
        System.out.printf("%-5s %-12s %-12s %-10s %-12s %-15s %-12s%n", 
            "ID", "Property ID", "Customer ID", "Agent ID", "Type", "Amount", "Date");
        System.out.println("--------------------------------------------------------------------------------------------");
        for (Transaction t : transactions) {
            System.out.printf("%-5d %-12d %-12d %-10d %-12s %-15.2f %-12s%n", 
                t.getTransactionId(), t.getPropertyId(), t.getCustomerId(), t.getAgentId(), 
                t.getTransactionType(), t.getTransactionAmount(), t.getTransactionDate());
        }
    }
    
    private static void deleteTransaction() {
        int transactionId = getIntInput("Enter transaction ID to delete: ");
        if (transactionDAO.deleteTransaction(transactionId)) {
            System.out.println("Transaction deleted successfully!");
        } else {
            System.out.println("Failed to delete transaction!");
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