package books.catalog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import books.catalog.entities.Author;
import books.catalog.repositories.AuthorRepository;

@Service
public class AuthorService {
    
    @Autowired AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRep) {
        this.authorRepository = authorRep;
    }

    public void updateAuthor(Author author) {
        authorRepository.save(author);
    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Author getAuthorByName(String name) {
        return authorRepository.findByName(name);
    }
}
