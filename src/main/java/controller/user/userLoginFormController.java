package controller.user;

import db.DBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.User;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class userLoginFormController {

    @FXML
    private Button Register;

    @FXML
    private TextField txtEmail;

    @FXML
    private PasswordField txtPassword;

    @FXML
    void btnCancelOnAction(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    void btnLoginOnAction(ActionEvent event) {
        String SQL = "SELECT * FROM users WHERE email=" + "'" + txtEmail.getText() + "'";
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL);
            if (resultSet.next()){
                User user = new User(
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7)
                );
                if (txtPassword.getText().equals(user.getPassword())){
                    Stage stage = new Stage();
                    if (user.getRole().equalsIgnoreCase("admin")){
                        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/adminDashBoard.fxml"))));
                    }
                    else {
                        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/userDashBoard.fxml"))));
                    }
                    stage.show();
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void btnRegisterFormOnAction(ActionEvent event) {
        try {
            Stage stage = new Stage();
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/userRegisterForm.fxml"))));
            stage.show();

            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "Failed to open Register Form!").show();
        }
    }

}
