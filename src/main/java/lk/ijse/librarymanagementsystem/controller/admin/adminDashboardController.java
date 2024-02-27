package lk.ijse.librarymanagementsystem.controller.admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class adminDashboardController implements Initializable {

    @FXML
    private ImageView accountIcon;

    @FXML
    private AnchorPane ancpane;

    @FXML
    private AnchorPane booksPane;

    @FXML
    private AnchorPane dashBoardPane;

    @FXML
    private AnchorPane settingPane;

    @FXML
    private AnchorPane shopPane;

    @FXML
    void onAccountIconClick(MouseEvent event) {

    }

    @FXML
    void onBookManageCLick(ActionEvent event) {
        setPaneColor(booksPane);
    }

    @FXML
    void onSettingsClick(ActionEvent event) {
        setPaneColor(settingPane);
    }

    @FXML
    void onShopManageClick(ActionEvent event) {
        setPaneColor(shopPane);
    }

    @FXML
    void ondashBoardClick(ActionEvent event) {
        setPaneColor(dashBoardPane);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        paneclrChange();
        ancpane.requestFocus();
    }
    private void setPaneColor(AnchorPane pane){
        paneclrChange();
        pane.setStyle("-fx-background-color: Black");
    }

    private void paneclrChange() {
        dashBoardPane.setStyle("-fx-background-color: white");
        booksPane.setStyle("-fx-background-color: white");
        shopPane.setStyle("-fx-background-color: white");
        settingPane.setStyle("-fx-background-color: white");
    }
}
