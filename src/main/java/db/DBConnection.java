package db;

import lombok.Getter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static DBConnection instance;

    @Getter
    private Connection connection;

    // Database credentials
    private static final String URL = "jdbc:mysql://localhost:3306/clothifystore";  // Replace with your DB URL
    private static final String USER = "root";  // Replace with your DB username
    private static final String PASSWORD = "1234";  // Replace with your DB password

    private DBConnection(){
        try {
            connection = DriverManager.getConnection(URL, USER,PASSWORD);
            System.out.println("Database connection successful.");
        } catch (SQLException e) {
            System.out.println("Database connection failed.");
        }
    }

    public static DBConnection getInstance(){
        return instance == null ? instance = new DBConnection() : instance;
    }
}
