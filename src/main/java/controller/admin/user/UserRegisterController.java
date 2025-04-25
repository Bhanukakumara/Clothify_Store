package controller.admin.user;

import controller.admin.AdminController;
import controller.admin.AdminService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.User;

import java.net.URL;
import java.util.ResourceBundle;

public class UserRegisterController implements Initializable {

    @FXML
    private ComboBox cmbRole;

    @FXML
    private TextField txtEmail;

    @FXML
    private PasswordField txtPassword;

    public void addUser(){
        User user = new User(
                txtEmail.getText(),
                txtPassword.getText(),
                cmbRole.getValue().toString()
        );
        AdminService adminService = new AdminController();
        adminService.registerUser(user);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cmbRole.getItems().addAll("Admin", "Manager", "Customer");
    }

    public void btnRegisterOnAction(ActionEvent actionEvent) {
        addUser();
    }
}
