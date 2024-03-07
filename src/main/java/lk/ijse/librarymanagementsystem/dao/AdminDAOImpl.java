package lk.ijse.librarymanagementsystem.dao;

import javafx.scene.control.Alert;
import lk.ijse.librarymanagementsystem.config.FactoryConfiguration;
import lk.ijse.librarymanagementsystem.entity.Admin;
import lk.ijse.librarymanagementsystem.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AdminDAOImpl {
    public List<Admin> getAllAdmin(){
        Session session = null;
        List<Admin> resultList = null;
        try {
            session = FactoryConfiguration.getFactoryConfiguration().getSession();
            resultList = session.createQuery("from Admin ").getResultList();
        }catch (Exception e){
            new Alert(Alert.AlertType.ERROR,"Cant load Admins").show();
        }finally {
            session.close();
            return resultList;
        }
    }

    public boolean saveAdmin(Admin admin) {
        Session session = null;
        int x = 0;
        try {
            session = FactoryConfiguration.getFactoryConfiguration().getSession();
            Transaction transaction = session.beginTransaction();
            x = (int) session.save(admin);
            transaction.commit();
        }catch (Exception e ){
            new Alert(Alert.AlertType.ERROR,"Cant save Admin now").show();
        }finally {
            session.close();
        }
        return x > 0 ;

    }
}
