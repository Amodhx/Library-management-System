package lk.ijse.librarymanagementsystem.dao;

import javafx.scene.control.Alert;
import lk.ijse.librarymanagementsystem.config.FactoryConfiguration;
import lk.ijse.librarymanagementsystem.entity.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BookDAOImpl {
    public boolean saveBook(Book book){
        Session session = null;
        try {
            session = FactoryConfiguration.getFactoryConfiguration().getSession();
            Transaction transaction = session.beginTransaction();
            boolean b = (boolean) session.save(book);
            transaction.commit();
            return b;
        }catch (Exception e){
            new Alert(Alert.AlertType.ERROR,"Cant save book Detail!!").show();
        }finally {
            session.close();

        }
        return false;
    }
}
