package lk.ijse.librarymanagementsystem.controller.admin;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.librarymanagementsystem.dto.tm.ShopsTM;

import java.net.URL;
import java.util.ResourceBundle;

public class ShopsformController implements Initializable {

    @FXML
    private TableColumn<ShopsTM, String> addresscolumn;

    @FXML
    private TableColumn<ShopsTM, String> citycolumn;

    @FXML
    private TableColumn<ShopsTM, JFXButton> deletecolumn;

    @FXML
    private TableColumn<ShopsTM, String> idcolumn;

    @FXML
    private TableColumn<ShopsTM, String> namecolumn;

    @FXML
    private TableColumn<ShopsTM, String> poscodecolumn;

    @FXML
    private TableView<ShopsTM> table;

    @FXML
    private TableColumn<ShopsTM, JFXButton> updatecolumn;

    @FXML
    void onAddBookClick(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setColumns();
    }

    private void setColumns() {
        idcolumn.setCellValueFactory(new PropertyValueFactory<ShopsTM,String>("id"));
        namecolumn.setCellValueFactory(new PropertyValueFactory<ShopsTM,String>("name"));
        citycolumn.setCellValueFactory(new PropertyValueFactory<ShopsTM,String>("city"));
        addresscolumn.setCellValueFactory(new PropertyValueFactory<ShopsTM,String>("address"));
        poscodecolumn.setCellValueFactory(new PropertyValueFactory<ShopsTM,String>("postalCode"));
        updatecolumn.setCellValueFactory(new PropertyValueFactory<ShopsTM,JFXButton>("update"));
        deletecolumn.setCellValueFactory(new PropertyValueFactory<ShopsTM,JFXButton>("delete"));
    }
}
