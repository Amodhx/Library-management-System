package lk.ijse.librarymanagementsystem.dao;

import javafx.scene.control.Alert;
import lk.ijse.librarymanagementsystem.config.FactoryConfiguration;
import lk.ijse.librarymanagementsystem.entity.Admin;
import lk.ijse.librarymanagementsystem.entity.User;
import org.hibernate.Session;

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
}
