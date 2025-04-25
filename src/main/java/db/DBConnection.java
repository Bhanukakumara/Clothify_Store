package db;

import lombok.Getter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static DBConnection instance;

    @Getter
    private Connection connection;

    private static final String URL = "jdbc:mysql://localhost:3306/clothifystore";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

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
