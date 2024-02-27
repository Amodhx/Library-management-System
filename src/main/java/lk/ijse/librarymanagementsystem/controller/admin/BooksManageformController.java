package lk.ijse.librarymanagementsystem.controller.admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class BooksManageformController {

    @FXML
    private TableColumn<?, ?> authorcolumn;

    @FXML
    private TableColumn<?, ?> deletecolumn;

    @FXML
    private TableColumn<?, ?> genrecolumn;

    @FXML
    private TableColumn<?, ?> idcolumn;

    @FXML
    private TableColumn<?, ?> statuscolumn;

    @FXML
    private TableView<?> table;

    @FXML
    private TableColumn<?, ?> titlecolumn;

    @FXML
    private TableColumn<?, ?> updatecolumn;

    @FXML
    void onAddBookClick(ActionEvent event) {

    }

}
