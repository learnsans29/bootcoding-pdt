package com.bootcoding.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class VendorDAO {

    public static void main(String[] args) {
        VendorDAO cd = new VendorDAO();
        for(int i = 103; i < 1000; i++){
            cd.insertVendor(i);
            System.out.println("New record Inserted into database!");
        }
    }

    public void insertVendor(int i){

        // Database Connectivity in Java
        // Total 5 steps
        // 1. Load JDBC Driver into Memory
        // 2. Create Database Connection
        // 3. Create Statement to write a SQL Query
        // 4. Get Result into ResultSet
        // 5. Close DB Connection
        try{
            // 1. Load JDBC Driver into Memory
            Class.forName("org.postgresql.Driver");

            // 2. Create Database Connection
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                    "postgres", "Skps@777");
            // 3. Create Statement to write a SQL Query
            Statement stmt = connection.createStatement();
            // 4. Get Result into ResultSet
            stmt.executeUpdate("insert into vendor " +
                    "values("+ i + ", 'Haldiram', 'Surya Nagar', 989787, true)");

            // 5. Close DB Connection
            connection.close();


        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}