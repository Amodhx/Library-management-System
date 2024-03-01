package lk.ijse.librarymanagementsystem.service;

import lk.ijse.librarymanagementsystem.dao.BorrowingDAOImpl;
import lk.ijse.librarymanagementsystem.dto.BorrowingDetailDTO;
import lk.ijse.librarymanagementsystem.entity.Book;
import lk.ijse.librarymanagementsystem.entity.BorrowingDetails;
import lk.ijse.librarymanagementsystem.entity.User;

import java.util.ArrayList;
import java.util.List;

public class BorrowingDetailsService {
    BorrowingDAOImpl borrowingDAO = new BorrowingDAOImpl();
    BookService bookService = new BookService();
    LogginService logginService = new LogginService();
    public boolean updateDueTransaction(int id){
        return borrowingDAO.updateDueDate(id);
    }
    public List<BorrowingDetails> getDetails(int id){
        List<BorrowingDetails> list = borrowingDAO.getDetailsBYid(id);
       return list;
    }
    public boolean saveBorrowingDetails(BorrowingDetailDTO borrowingDetailDTO){
        Book bookUsingID = bookService.getBookUsingID(borrowingDetailDTO.getBookID());
        User userById = logginService.getUserById(borrowingDetailDTO.getUserID());
        return borrowingDAO.saveBorrowingDetail(new BorrowingDetails(borrowingDetailDTO.getId(),borrowingDetailDTO.getBorrowingDate(),borrowingDetailDTO.getDueDate(),borrowingDetailDTO.getStatus(),userById,bookUsingID));
    }

    public boolean updateStatus(int id) {

        return borrowingDAO.updateStatus(id);
    }
}
