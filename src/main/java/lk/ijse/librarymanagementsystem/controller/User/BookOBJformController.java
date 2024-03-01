package lk.ijse.librarymanagementsystem.controller.User;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import lk.ijse.librarymanagementsystem.dto.BookDTO;
import lk.ijse.librarymanagementsystem.dto.BorrowingDetailDTO;
import lk.ijse.librarymanagementsystem.service.BookService;
import lk.ijse.librarymanagementsystem.service.BorrowingDetailsService;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class BookOBJformController implements Initializable {

    @FXML
    private ImageView addIcon;
    public static int userID;


    @FXML
    private Label authorfield;

    @FXML
    private ImageView imageview;

    @FXML
    private Label titleField;
    public static int x;
    BookService bookService = new BookService();
    BorrowingDetailsService borrowingDetailsService = new BorrowingDetailsService();
    public  static ArrayList<BookDTO> allBooks = null;
    String status ;
    int id;

    @FXML
    void onAddIconClick(MouseEvent event) {
        status = "Booked";
        String bdate = String.valueOf(LocalDate.now());
        LocalDate now = LocalDate.now();
        LocalDate localDate = now.plusDays(10);
        String dueDate = String.valueOf(localDate);
        boolean b = bookService.updateBookStatus(id, status);
        boolean b1 = borrowingDetailsService.saveBorrowingDetails(new BorrowingDetailDTO(0, bdate, dueDate, userID, id));
        if (b1){
            new Alert(Alert.AlertType.INFORMATION,"Book booked!!").show();
        }
    }

    @FXML
    void mouseEnter(MouseEvent event) {
        if (status.equals("Available")){
            addIcon.setVisible(true);
        }
    }

    @FXML
    void mouseExit(MouseEvent event) {
        addIcon.setVisible(false);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setValues();
        addIcon.setVisible(false);
    }

    private void setValues() {
        if (allBooks.get(x).getUrl() != null){
            imageview.setImage(new Image(allBooks.get(x).getUrl()));
        }
        status = allBooks.get(x).getStatus();
        id = allBooks.get(x).getId();
        titleField.setText(allBooks.get(x).getTitle());
        authorfield.setText(allBooks.get(x).getAuthor());
    }
}
