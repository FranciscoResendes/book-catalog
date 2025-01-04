package books.catalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import books.catalog.entities.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
	
    Book findByIsbn(String isbn);
}
