package books.catalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import books.catalog.entities.Author;

public interface  AuthorRepository extends JpaRepository<Author, Long> {
    
    Author findByName(String name);
}
