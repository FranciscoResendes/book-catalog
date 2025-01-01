package books.catalog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import books.catalog.entities.Book;
import books.catalog.repositories.BookRepository;

@Service
public class BookService {
    
    @Autowired BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public void updateBook(Book book) {
        bookRepository.save(book);
    }
}
