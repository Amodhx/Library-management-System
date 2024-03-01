package lk.ijse.librarymanagementsystem.controller.admin;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lk.ijse.librarymanagementsystem.dto.BookDTO;
import lk.ijse.librarymanagementsystem.service.BookService;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Stack;

public class UpdateBookFormController implements Initializable {
    public static int bid;
    public static String booktitle;
    public static String author;
    public static String genrer;

    @FXML
    private TextField authorNamefield;

    @FXML
    private TextField bookTitleField;

    @FXML
    private JFXButton saveButton;

    @FXML
    private JFXComboBox<String> selectGenreCombo;
    BookService bookService = new BookService();

    @FXML
    void canselClick(ActionEvent event) {
        Stage stage = (Stage) saveButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void onSaveClick(ActionEvent event) {
        canselClick(event);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList observableList = FXCollections.observableArrayList("Historical","Novel","Education","Children");
        selectGenreCombo.setItems(observableList);
        bookTitleField.setText(booktitle);
        authorNamefield.setText(author);
        selectGenreCombo.setValue(genrer);
    }
}
