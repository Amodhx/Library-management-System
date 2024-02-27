package lk.ijse.librarymanagementsystem.service;

import lk.ijse.librarymanagementsystem.dao.BookDAOImpl;
import lk.ijse.librarymanagementsystem.dto.BookDTO;
import lk.ijse.librarymanagementsystem.entity.Book;

import java.util.ArrayList;
import java.util.List;

public class BookService {

    BookDAOImpl bookDAO = new BookDAOImpl();
    public boolean saveBook(BookDTO bookDTO){
        return bookDAO.saveBook(new Book(bookDTO.getId(), bookDTO.getTitle(), bookDTO.getAuthor(),
                bookDTO.getGenre(), bookDTO.getStatus(), bookDTO.getUrl()));
    }
    public ArrayList<BookDTO> getAllBooks(){
        List<Book> allBooks = bookDAO.getAllBooks();
        ArrayList<BookDTO> arrayList = new ArrayList<>();
        for (Book b : allBooks){
            arrayList.add(new BookDTO(b.getId(),b.getTitle(),b.getAuthor(),b.getGenre(),b.getStatus(),b.getUrl()));
        }
        return arrayList;
    }
}
