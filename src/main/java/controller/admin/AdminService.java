package controller.admin;

import model.Product;
import model.Supplier;
import model.User;

import java.util.List;

public interface AdminService {

    boolean registerUser(User user);
    boolean updateUser(User user);
    boolean deleteUser(String email);
    User getUserByEmail(String email);
    List<User> getAllUsers();

    boolean addProduct(Product product);
    boolean updateProduct(Product product);
    boolean deleteProduct(int id);
    Product getProductByName(String name);
    List<Product> getAllProducts();

    boolean addSupplier(Supplier supplier);
    boolean updateSupplier(Supplier supplier);
    boolean deleteSupplier(int id);
    Supplier getSupplierByName(String name);
    List<Supplier> getAllSuppliers();
}
