package lk.ijse.librarymanagementsystem.dao;

import javafx.scene.control.Alert;
import lk.ijse.librarymanagementsystem.config.FactoryConfiguration;
import lk.ijse.librarymanagementsystem.entity.BorrowingDetails;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class BorrowingDAOImpl {
    public boolean saveBorrowingDetail(BorrowingDetails borrowingDetails){
        Session session = null;
        int x = 0 ;
        try {
            session = FactoryConfiguration.getFactoryConfiguration().getSession();
            Transaction transaction = session.beginTransaction();
            x = (int) session.save(borrowingDetails);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return x > 0 ;
    }

    public List<BorrowingDetails> getDetailsBYid(int id) {
        Session session = null;
        List<BorrowingDetails> list = null;
        try {
            session = FactoryConfiguration.getFactoryConfiguration().getSession();
            Query query = session.createQuery("from BorrowingDetails where User.id = :ID");
            query.setParameter("ID",id);
            list = query.getResultList();
        }catch (Exception e){
            new Alert(Alert.AlertType.ERROR).show();
        }finally {
            session.close();
        }
        return list;
    }
}
