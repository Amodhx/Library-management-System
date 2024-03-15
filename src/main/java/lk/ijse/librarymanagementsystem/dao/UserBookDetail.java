package lk.ijse.librarymanagementsystem.dao;

import javafx.scene.control.Alert;
import lk.ijse.librarymanagementsystem.config.FactoryConfiguration;
import lk.ijse.librarymanagementsystem.dto.BorrowingDetailDTO;
import lk.ijse.librarymanagementsystem.entity.Book;
import lk.ijse.librarymanagementsystem.entity.BorrowingDetails;
import lk.ijse.librarymanagementsystem.entity.User;
import lk.ijse.librarymanagementsystem.service.BookService;
import lk.ijse.librarymanagementsystem.service.LogginService;
import lk.ijse.librarymanagementsystem.service.ServiceFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.time.LocalDate;

public class UserBookDetail {

    BookService bookService = (BookService) ServiceFactory.getServiceFactory().getService(ServiceFactory.ServiceTypes.BOOKService);
    LogginService logginService = (LogginService) ServiceFactory.getServiceFactory().getService(ServiceFactory.ServiceTypes.LOGGINService);
    public boolean bookBook(int id, String status, BorrowingDetailDTO borrowingDetailDTO){
        Book bookUsingID = bookService.getBookUsingID(borrowingDetailDTO.getBookID());
        User userById = logginService.getUserById(borrowingDetailDTO.getUserID());
        Session session = null;
        int x = 0 ;
        try {
            session = FactoryConfiguration.getFactoryConfiguration().getSession();
            Transaction transaction = session.beginTransaction();
            session.save(new BorrowingDetails(borrowingDetailDTO.getId(),borrowingDetailDTO.getBorrowingDate(),borrowingDetailDTO.getDueDate(),borrowingDetailDTO.getStatus(),userById,bookUsingID));
            Query query = session.createQuery("update Book set status = :Sta where id = :ID");
            query.setParameter("Sta",status);
            query.setParameter("ID",id);
             x = 1;
            transaction.commit();
        }catch (Exception e){
            new Alert(Alert.AlertType.ERROR).show();
        }finally {
            session.close();
        }
        return x > 0 ;
    }
}
