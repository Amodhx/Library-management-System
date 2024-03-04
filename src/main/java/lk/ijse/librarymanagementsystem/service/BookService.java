package lk.ijse.librarymanagementsystem.service;

import lk.ijse.librarymanagementsystem.dao.BookDAOImpl;
import lk.ijse.librarymanagementsystem.dto.BookDTO;
import lk.ijse.librarymanagementsystem.entity.Book;

import java.util.ArrayList;
import java.util.List;

public class BookService {

    BookDAOImpl bookDAO = new BookDAOImpl();
    public Book getBookUsingID(int id){
        return bookDAO.getBookByID(id);
    }
    public boolean updateBookStatus(int id ,String status){
        return bookDAO.updateBook(id,status);
    }
    public boolean saveBook(BookDTO bookDTO){
        return bookDAO.saveBook(new Book(bookDTO.getId(), bookDTO.getTitle(), bookDTO.getAuthor(),
                bookDTO.getGenre(), bookDTO.getStatus(), bookDTO.getUrl(),new ArrayList<>()));
    }
    public ArrayList<BookDTO> getAllBooks(){
        List<Book> allBooks = bookDAO.getAllBooks();
        ArrayList<BookDTO> arrayList = new ArrayList<>();
        for (Book b : allBooks){
            arrayList.add(new BookDTO(b.getId(),b.getTitle(),b.getAuthor(),b.getGenre(),b.getStatus(),b.getUrl()));
        }
        return arrayList;
    }
    public ArrayList<BookDTO> getBooksFilterWithGenre(String genre){
        List<Book> allBooks = bookDAO.getBooksFilterWithGenre(genre);
        ArrayList<BookDTO> arrayList = new ArrayList<>();
        for (Book b : allBooks){
            arrayList.add(new BookDTO(b.getId(),b.getTitle(),b.getAuthor(),b.getGenre(),b.getStatus(),b.getUrl()));
        }
        return arrayList;
    }

    public boolean deleteBook(String id) {
        return bookDAO.deleteBook(id);
    }

    public boolean updateBook(BookDTO bookDTO) {
        return bookDAO.Update(new Book(bookDTO.getId(),bookDTO.getTitle(),bookDTO.getAuthor(),bookDTO.getGenre(),bookDTO.getStatus(),bookDTO.getUrl(),new ArrayList<>()));
    }
}
