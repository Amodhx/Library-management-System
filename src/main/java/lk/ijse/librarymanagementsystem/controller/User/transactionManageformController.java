package lk.ijse.librarymanagementsystem.controller.User;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.librarymanagementsystem.dto.tm.TransactionTM;
import lk.ijse.librarymanagementsystem.entity.BorrowingDetails;
import lk.ijse.librarymanagementsystem.service.BorrowingDetailsService;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class transactionManageformController implements Initializable {
    public static int id;


    @FXML
    private TableColumn<TransactionTM, Integer> bookIDField;

    @FXML
    private TableColumn<TransactionTM, String> bookTitleFIeld;

    @FXML
    private TableColumn<TransactionTM, String> dueDatefield;

    @FXML
    private TableColumn<TransactionTM, String> getDatefield;

    @FXML
    private TableColumn<TransactionTM, Integer> transIdField;

    @FXML
    private TableColumn<TransactionTM, Integer> userIdField;
    @FXML
    private TableView<TransactionTM> table;
    BorrowingDetailsService borrowingDetailsService = new BorrowingDetailsService();

    @FXML
    void transHistoryButton(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setColumns();
        loadValues();
    }

    private void loadValues() {
        List<BorrowingDetails> details = borrowingDetailsService.getDetails(id);
        ObservableList<TransactionTM> observableList = FXCollections.observableArrayList();
        for (BorrowingDetails b : details){
            observableList.add(new TransactionTM(b.getId(),b.getUser().getId(),b.getBook().getId(),b.getBook().getTitle(),b.getBorrowingDate(),b.getDueDate()));
        }
        table.setItems(observableList);
    }

    private void setColumns() {
        transIdField.setCellValueFactory(new PropertyValueFactory<TransactionTM,Integer>("transID"));
        userIdField.setCellValueFactory(new PropertyValueFactory<TransactionTM,Integer>("userID"));
        bookIDField.setCellValueFactory(new PropertyValueFactory<TransactionTM,Integer>("bookId"));
        bookTitleFIeld.setCellValueFactory(new PropertyValueFactory<TransactionTM,String>("bookTitle"));
        getDatefield.setCellValueFactory(new PropertyValueFactory<TransactionTM,String>("getDate"));
        dueDatefield.setCellValueFactory(new PropertyValueFactory<TransactionTM,String>("dueDate"));
    }
}
