package lk.ijse.librarymanagementsystem.service;

import lk.ijse.librarymanagementsystem.dao.BookDAOImpl;
import lk.ijse.librarymanagementsystem.dto.BookDTO;
import lk.ijse.librarymanagementsystem.entity.Book;

public class BookService {

    BookDAOImpl bookDAO = new BookDAOImpl();
    public boolean saveBook(BookDTO bookDTO){
        return bookDAO.saveBook(new Book(bookDTO.getId(), bookDTO.getTitle(), bookDTO.getAuthor(),
                bookDTO.getGenre(), bookDTO.getStatus(), bookDTO.getUrl()));
    }
}
