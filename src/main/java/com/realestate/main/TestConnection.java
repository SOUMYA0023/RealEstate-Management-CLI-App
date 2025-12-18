package com.realestate.main;

import com.realestate.util.DBConnection;
import java.sql.Connection;

public class TestConnection {
    public static void main(String[] args) {
        System.out.println("Testing database connection...");
        Connection conn = DBConnection.getConnection();
        if (conn != null) {
            System.out.println("Database connection successful!");
            DBConnection.closeConnection();
        } else {
            System.out.println("Failed to connect to the database.");
        }
    }
}