package controller.admin.user;

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

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserSearchController {

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

        try {
            Connection connection = DBConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE email=" + "'" + txtEmail.getText() + "'");
            if (resultSet.next()){
                ObservableList<User> userObservableList = FXCollections.observableArrayList();
                userObservableList.add(new User(
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4)
                ));
                colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
                colPassword.setCellValueFactory(new PropertyValueFactory<>("password"));
                colRole.setCellValueFactory(new PropertyValueFactory<>("role"));
                tblView.setItems(userObservableList);
            }
            else {
                new Alert(Alert.AlertType.CONFIRMATION,"User Not Found").show();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
