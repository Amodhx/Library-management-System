package lk.ijse.librarymanagementsystem.dao;

import javafx.scene.control.Alert;
import lk.ijse.librarymanagementsystem.config.FactoryConfiguration;
import lk.ijse.librarymanagementsystem.entity.User;
import org.hibernate.Session;

import java.util.List;

public class UserDAOImpl {
    public List<User> getAllUser(){
        Session session = null;
        List<User> resultList = null;
        try {
             session = FactoryConfiguration.getFactoryConfiguration().getSession();
            resultList = session.createQuery("from User ").getResultList();
        }catch (Exception e){
            new Alert(Alert.AlertType.ERROR,"Cant load Users").show();
        }finally {
            session.close();
            return resultList;
        }
    }
}
