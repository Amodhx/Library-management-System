package lk.ijse.librarymanagementsystem.dao;

import javafx.scene.control.Alert;
import lk.ijse.librarymanagementsystem.config.FactoryConfiguration;
import lk.ijse.librarymanagementsystem.entity.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

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

    public List<Book> getBooksFilterWithGenre(String genre) {
        Session session = null;
        List<Book> list = null;
        try {
            session = FactoryConfiguration.getFactoryConfiguration().getSession();
            Query query = session.createQuery("from Book where genre = :GENRE");
            query.setParameter("GENRE",genre);
            list = query.getResultList();
        }catch (Exception e){
            new Alert(Alert.AlertType.ERROR).show();
        }finally {
            session.close();
        }
        return list;
    }

    public boolean updateBook(int id , String status) {
        Session session = null;
        int x = 0 ;
        try {
            session =FactoryConfiguration.getFactoryConfiguration().getSession();
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("update Book set status = :Sta where id = :ID");
            query.setParameter("Sta",status);
            query.setParameter("ID",id);
            x = query.executeUpdate();
            transaction.commit();
        }catch (Exception e){
            new Alert(Alert.AlertType.ERROR).show();
        }finally {
            session.close();
        }
        return x > 0 ;
    }

    public Book getBookByID(int id) {
        Session session = null;
        Book book = new Book();
        try {
            session = FactoryConfiguration.getFactoryConfiguration().getSession();
            Query query = session.createQuery("from Book  where id = :ID");
            query.setParameter("ID", id);
            List<Book> resultList = query.getResultList();
            book.setId(resultList.get(0).getId());
            book.setTitle(resultList.get(0).getTitle());
            book.setAuthor(resultList.get(0).getAuthor());
            book.setGenre(resultList.get(0).getGenre());
            book.setStatus(resultList.get(0).getStatus());
            book.setUrl(resultList.get(0).getUrl());
        }catch (Exception e){

        }finally {
            session.close();
        }
        return book;
    }

    public boolean deleteBook(String id) {
        Session session = null;
        int x = 0 ;
        try {
            session = FactoryConfiguration.getFactoryConfiguration().getSession();
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("delete Book where id = :ID");
            query.setParameter("ID",id);
            x = query.executeUpdate();
            transaction.commit();
        }catch (Exception e){
            new Alert(Alert.AlertType.ERROR).show();
        }finally {
            session.close();
        }
        return x > 0 ;
    }

    public boolean Update(Book book) {
        Session session = null;
        int x = 0 ;
        try {
            session = FactoryConfiguration.getFactoryConfiguration().getSession();
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(book);
            transaction.commit();
        }catch (Exception e){
            new Alert(Alert.AlertType.ERROR).show();
        }finally {
            session.close();
        }
        return true;
    }
}
