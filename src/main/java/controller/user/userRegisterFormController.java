package controller.user;

import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.User;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class userRegisterFormController implements Initializable {

    @FXML
    public ComboBox cmbUserRole;

    @FXML
    private PasswordField txtConfirmPassword;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtFirstName;

    @FXML
    private TextField txtLastName;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtPhoneNumber;

    private Map<String,Integer> userRoleHashMap = new HashMap<>();

    @FXML
    void btnCancelOnAction(ActionEvent event) {

    }

    @FXML
    void btnRegisterOnAction(ActionEvent event) {
        String SQL = "INSERT INTO users (first_name,last_name,email,phone_number,role,password) VALUES(?,?,?,?,?,?)";
        if (txtPassword.getText().equals(txtConfirmPassword.getText())){
            try {
                Connection connection = DBConnection.getInstance().getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE email=" + "'" + txtEmail.getText() + "'");
                if (!resultSet.next()){
                    User user = new User(
                            txtFirstName.getText(),
                            txtLastName.getText(),
                            txtEmail.getText(),
                            txtPhoneNumber.getText(),
                            (String)cmbUserRole.getSelectionModel().getSelectedItem(),
                            txtPassword.getText()
                    );
                    PreparedStatement preparedStatement = connection.prepareStatement(SQL);
                    preparedStatement.setString(1,user.getFirstName());
                    preparedStatement.setString(2,user.getLastName());
                    preparedStatement.setString(3,user.getEmail());
                    preparedStatement.setString(4,user.getPhoneNumber());
                    preparedStatement.setString(5,user.getRole());
                    preparedStatement.setString(6,user.getPassword());
                    preparedStatement.executeUpdate();
                    new Alert(Alert.AlertType.CONFIRMATION,"User Added!").show();
                }
                else {
                    new Alert(Alert.AlertType.WARNING,"User Found!").show();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }else {
            new Alert(Alert.AlertType.WARNING,"Password not match!").show();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadCmb();
    }

    public void loadCmb() {
        userRoleHashMap.put("Admin",0);
        userRoleHashMap.put("User",1);
        userRoleHashMap.put("Customer",2);
        ObservableList<String> userRoleObservableArrayList = FXCollections.observableArrayList(userRoleHashMap.keySet());
        cmbUserRole.setItems(userRoleObservableArrayList);
    }

    @FXML
    public void btnLoginOnAction(ActionEvent actionEvent) {

        try {
            Stage stage = new Stage();
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/userLoginForm.fxml"))));
            stage.show();
            Stage curentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            curentStage.close();
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "Failed to open Login Form!").show();
        }

    }
}
