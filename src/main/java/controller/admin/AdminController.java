package controller.admin;

import controller.admin.user.UserRegisterController;
import db.DBConnection;
import javafx.scene.control.Alert;
import model.Product;
import model.Supplier;
import model.User;

import java.sql.*;
import java.util.List;

public class AdminController implements AdminService{
    @Override
    public boolean registerUser(User user) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE email=" + "'" + user.getEmail() + "'");
            if (!resultSet.next()){
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Users (email, password, role) VALUES(?,?,?)");
                preparedStatement.setString(1,user.getEmail());
                preparedStatement.setString(2, user.getPassword());
                preparedStatement.setString(3, user.getRole());
                preparedStatement.executeUpdate();
                new Alert(Alert.AlertType.INFORMATION,"User Added!").show();
            }
            else {
                new Alert(Alert.AlertType.ERROR,"User Found!").show();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public boolean updateUser(User user) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE email=" + "'" + user.getEmail() + "'");
            if (resultSet.next()){

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public boolean deleteUser(int id) {
        return false;
    }

    @Override
    public User getUserByEmail(String email) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return List.of();
    }

    @Override
    public boolean addProduct(Product product) {
        return false;
    }

    @Override
    public boolean updateProduct(Product product) {
        return false;
    }

    @Override
    public boolean deleteProduct(int id) {
        return false;
    }

    @Override
    public Product getProductByName(String name) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public boolean addSupplier(Supplier supplier) {
        return false;
    }

    @Override
    public boolean updateSupplier(Supplier supplier) {
        return false;
    }

    @Override
    public boolean deleteSupplier(int id) {
        return false;
    }

    @Override
    public Supplier getSupplierByName(String name) {
        return null;
    }

    @Override
    public List<Supplier> getAllSuppliers() {
        return List.of();
    }
}
