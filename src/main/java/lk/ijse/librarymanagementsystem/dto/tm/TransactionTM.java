package lk.ijse.librarymanagementsystem.dto.tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionTM {
    private int transID;
    private int userID;
    private int bookId;
    private String bookTitle;
    private String getDate;
    private String dueDate;
}
