package books.catalog.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import books.catalog.entities.Book;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RestApiController {
    
    @GetMapping
    public ResponseEntity<List<Book>> getBooks() {
        List<Book> books = null;
        return new ResponseEntity<>(books, HttpStatus.OK);
    }
}
