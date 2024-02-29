package lk.ijse.librarymanagementsystem.controller.admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class ShopsformController implements Initializable {

    @FXML
    private TableColumn<?, ?> addresscolumn;

    @FXML
    private TableColumn<?, ?> citycolumn;

    @FXML
    private TableColumn<?, ?> deletecolumn;

    @FXML
    private TableColumn<?, ?> idcolumn;

    @FXML
    private TableColumn<?, ?> namecolumn;

    @FXML
    private TableColumn<?, ?> poscodecolumn;

    @FXML
    private TableView<?> table;

    @FXML
    private TableColumn<?, ?> updatecolumn;

    @FXML
    void onAddBookClick(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
