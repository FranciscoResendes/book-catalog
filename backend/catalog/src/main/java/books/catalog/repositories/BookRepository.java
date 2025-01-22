package books.catalog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import books.catalog.entities.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
	
    Book findByIsbn(String isbn);
    
    List<Book> findByTitle(String title);
}
