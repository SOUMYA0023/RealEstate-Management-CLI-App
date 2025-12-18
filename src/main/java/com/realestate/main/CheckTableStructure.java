package com.realestate.main;

import com.realestate.util.DBConnection;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckTableStructure {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            conn = DBConnection.getConnection();
            if (conn != null) {
                DatabaseMetaData metaData = conn.getMetaData();
                ResultSet columns = metaData.getColumns(null, null, "properties", null);
                
                System.out.println("Columns in 'properties' table:");
                System.out.println("-------------------------------");
                while (columns.next()) {
                    String columnName = columns.getString("COLUMN_NAME");
                    String typeName = columns.getString("TYPE_NAME");
                    int size = columns.getInt("COLUMN_SIZE");
                    System.out.println(columnName + " (" + typeName + "(" + size + "))");
                }
                columns.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeConnection();
        }
    }
}