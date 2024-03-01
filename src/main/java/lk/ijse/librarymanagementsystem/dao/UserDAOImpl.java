package lk.ijse.librarymanagementsystem.dao;

import javafx.scene.control.Alert;
import lk.ijse.librarymanagementsystem.config.FactoryConfiguration;
import lk.ijse.librarymanagementsystem.entity.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class UserDAOImpl {
    public User getUserByID(int id){
        Session session = null;
        User user = new User();
        try {
            session = FactoryConfiguration.getFactoryConfiguration().getSession();
            Query query = session.createQuery("from User where id = : ID");
            query.setParameter("ID",id);
            List<User> resultList = query.getResultList();
            user.setId(resultList.get(0).getId());
            user.setUsername(resultList.get(0).getPassword());
            user.setPassword(resultList.get(0).getPassword());
            user.setEmail(resultList.get(0).getEmail());
        }catch (Exception e){
            new Alert(Alert.AlertType.ERROR).show();
        }finally {
            session.close();
        }
        return user;
    }
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
