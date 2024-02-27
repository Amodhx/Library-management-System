package lk.ijse.librarymanagementsystem.dao;

import javafx.scene.control.Alert;
import lk.ijse.librarymanagementsystem.config.FactoryConfiguration;
import lk.ijse.librarymanagementsystem.entity.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class BookDAOImpl {
    public boolean saveBook(Book book){
        Session session = null;
        int x = 0 ;
        try {
            session = FactoryConfiguration.getFactoryConfiguration().getSession();
            Transaction transaction = session.beginTransaction();
            x = (int) session.save(book);
            transaction.commit();
        }catch (Exception e){
            new Alert(Alert.AlertType.ERROR,"cant Save book detail!!").show();
        }finally {
            session.close();
        }
        return x > 0 ;
    }
    public List<Book> getAllBooks(){
        Session session = null;
        List resultList = null;
        try {
            session = FactoryConfiguration.getFactoryConfiguration().getSession();
            resultList = session.createQuery("from Book").getResultList();
        }catch (Exception e){
            new Alert(Alert.AlertType.ERROR,"Cant load Books").show();
        }finally {
            session.close();
        }
        return resultList;
    }
}
