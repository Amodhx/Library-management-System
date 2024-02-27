package lk.ijse.librarymanagementsystem.controller.admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lombok.SneakyThrows;

public class BooksManageformController {
    @FXML
    private AnchorPane ancpane;

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

    @SneakyThrows
    @FXML
    void onAddBookClick(ActionEvent event) {
        Stage stage = new Stage();
        addBookformController.anchorPane = ancpane;
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/admin/addBook.fxml"))));
        stage.setResizable(false);
        stage.show();
    }

}
