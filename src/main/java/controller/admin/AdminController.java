package controller.admin;

import model.Product;
import model.Supplier;
import model.User;

import java.util.List;

public class AdminController implements AdminService{

    @Override
    public boolean registerUser(User user) {
        return false;
    }

    @Override
    public boolean updateUser(User user) {
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
