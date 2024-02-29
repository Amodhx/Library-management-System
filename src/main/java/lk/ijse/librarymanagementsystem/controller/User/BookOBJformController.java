package lk.ijse.librarymanagementsystem.controller.User;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import lk.ijse.librarymanagementsystem.dto.BookDTO;
import lk.ijse.librarymanagementsystem.service.BookService;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class BookOBJformController implements Initializable {

    @FXML
    private ImageView addIcon;

    @FXML
    private Label authorfield;

    @FXML
    private ImageView imageview;

    @FXML
    private Label titleField;
    public static int x;
    BookService bookService = new BookService();
    public  static ArrayList<BookDTO> allBooks = null;

    @FXML
    void onAddIconClick(MouseEvent event) {

    }

    @FXML
    void mouseEnter(MouseEvent event) {
        addIcon.setVisible(true);
    }

    @FXML
    void mouseExit(MouseEvent event) {
        addIcon.setVisible(false);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setValues();
    }

    private void setValues() {
        if (allBooks.get(x).getUrl() != null){
            imageview.setImage(new Image(allBooks.get(x).getUrl()));
        }
        titleField.setText(allBooks.get(x).getTitle());
        authorfield.setText(allBooks.get(x).getAuthor());
    }
}
