package lk.ijse.librarymanagementsystem.controller.User;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import lk.ijse.librarymanagementsystem.dto.tm.TransactionTM;
import lk.ijse.librarymanagementsystem.entity.BorrowingDetails;
import lk.ijse.librarymanagementsystem.service.BorrowingDetailsService;
import lombok.SneakyThrows;

import java.net.URL;
import java.time.LocalDate;
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
    @FXML
    private TableColumn<TransactionTM, JFXButton> returncolumn;
    BorrowingDetailsService borrowingDetailsService = new BorrowingDetailsService();

    @SneakyThrows
    @FXML
    void transHistoryButton(ActionEvent event) {
        transactionHistoryController.id = id;
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/user/transactionHistory.fxml"))));
        stage.setResizable(false);
        stage.show();
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
            if (!b.getStatus().equals("Returned")) {
                observableList.add(new TransactionTM(b.getId(), b.getUser().getId(), b.getBook().getId(), b.getBook().getTitle(), b.getBorrowingDate(), b.getDueDate(), new JFXButton("Return")));
            }
        }
        table.setItems(observableList);

        for (int i = 0; i < observableList.size(); i++) {
            int id = observableList.get(i).getTransID();
            observableList.get(i).getReturnBtn().setStyle("-fx-background-color: blue; -fx-text-fill: white");
            observableList.get(i).getReturnBtn().setOnAction(event -> {
                borrowingDetailsService.updateDueTransaction(id);
                boolean b = borrowingDetailsService.updateStatus(id);
                if (b){
                    new Alert(Alert.AlertType.INFORMATION,"Book returned!").show();
                }else {
                    new Alert(Alert.AlertType.ERROR).show();
                }
            });
        }
    }

    private void setColumns() {
        transIdField.setCellValueFactory(new PropertyValueFactory<TransactionTM,Integer>("transID"));
        userIdField.setCellValueFactory(new PropertyValueFactory<TransactionTM,Integer>("userID"));
        bookIDField.setCellValueFactory(new PropertyValueFactory<TransactionTM,Integer>("bookId"));
        bookTitleFIeld.setCellValueFactory(new PropertyValueFactory<TransactionTM,String>("bookTitle"));
        getDatefield.setCellValueFactory(new PropertyValueFactory<TransactionTM,String>("getDate"));
        dueDatefield.setCellValueFactory(new PropertyValueFactory<TransactionTM,String>("dueDate"));
        returncolumn.setCellValueFactory(new PropertyValueFactory<TransactionTM,JFXButton>("returnBtn"));

    }
}
