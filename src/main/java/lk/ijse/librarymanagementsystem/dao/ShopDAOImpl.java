package lk.ijse.librarymanagementsystem.dao;

import javafx.scene.control.Alert;
import lk.ijse.librarymanagementsystem.config.FactoryConfiguration;
import lk.ijse.librarymanagementsystem.entity.Branches;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ShopDAOImpl {
    public List<Branches> getAllShops(){
        Session session = null;
        List<Branches> list = null;
        try {
            session = FactoryConfiguration.getFactoryConfiguration().getSession();
            list = session.createQuery("from Branches ").getResultList();
        }catch (Exception e){
            new Alert(Alert.AlertType.ERROR,"Cant get Braches Values").show();
        }finally {
            session.close();
        }
        return list;
    }
    public boolean saveShop(Branches branches){
        Session session = null;
        int x = 0 ;
        try {
            session = FactoryConfiguration.getFactoryConfiguration().getSession();
            Transaction transaction = session.beginTransaction();
            x = (int) session.save(branches);
            transaction.commit();
        }catch (Exception e){
            new Alert(Alert.AlertType.ERROR,"Cant save Shop values").show();
        }finally {
            session.close();
        }
        return x > 0 ;
    }
}
