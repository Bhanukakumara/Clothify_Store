package controller.admin.user;

import controller.admin.AdminController;
import controller.admin.AdminService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.User;

import java.net.URL;
import java.util.ResourceBundle;

public class UserUpdateController implements Initializable {

    @FXML
    private ComboBox cmbRole;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtPassword;

    AdminService adminService = new AdminController();
    @FXML
    void btnSearchOnAction(ActionEvent event) {
        User user = adminService.getUserByEmail(txtEmail.getText());
        txtPassword.setText(user.getPassword());
        cmbRole.setValue(user.getRole());
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        adminService.updateUser(new User(
                        txtEmail.getText(),
                        txtPassword.getText(),
                        cmbRole.getValue().toString()
                )
        );
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cmbRole.getItems().addAll("Admin", "Manager", "Customer");
    }
}
