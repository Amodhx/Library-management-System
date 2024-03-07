package lk.ijse.librarymanagementsystem.controller.admin;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import lombok.SneakyThrows;

public class adminMainformController {

    @FXML
    private Label totalbooklbl;

    @FXML
    private Label totalshoplbl;

    @FXML
    private Label totaluserlbl;

    @SneakyThrows
    @FXML
    void onAddAdminClick(MouseEvent event) {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/admin/AddAdmin.fxml"))));
        stage.setResizable(false);
        stage.show();
    }

}
