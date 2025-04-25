package controller.admin.user;

import controller.admin.AdminController;
import controller.admin.AdminService;
import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.User;

public class UserSearchController {

    AdminService adminService = new AdminController();

    @FXML
    private TableColumn colEmail;

    @FXML
    private TableColumn colPassword;

    @FXML
    private TableColumn colRole;

    @FXML
    private TableView tblView;

    @FXML
    private TextField txtEmail;

    @FXML
    void btnSearchOnAction(ActionEvent event) {
        ObservableList<User> userObservableList = FXCollections.observableArrayList();
        userObservableList.add(searchUser(txtEmail.getText()));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colPassword.setCellValueFactory(new PropertyValueFactory<>("password"));
        colRole.setCellValueFactory(new PropertyValueFactory<>("role"));
        tblView.setItems(userObservableList);

    }

    public User searchUser(String email){
        return adminService.getUserByEmail(txtEmail.getText());
    }

    @FXML
    void btnDeleteOnAction(ActionEvent actionEvent) {
        adminService.deleteUser(txtEmail.getText());
    }
}
