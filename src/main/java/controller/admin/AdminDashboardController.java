package controller.admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminDashboardController {

    Stage stage = new Stage();

    @FXML
    void handleCategoryManagement(ActionEvent event) {

    }

    @FXML
    void handleProductManagement(ActionEvent event) {

    }

    @FXML
    void handleUserManagement(ActionEvent event) {
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/admin/user/userRegister.fxml"))));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
