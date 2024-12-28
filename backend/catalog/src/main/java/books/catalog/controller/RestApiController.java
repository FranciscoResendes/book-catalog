package books.catalog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import books.catalog.entities.Book;
import books.catalog.entities.Users;
import books.catalog.service.BookService;
import books.catalog.service.UsersService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RestApiController {

    @Autowired BookService bookService;
    @Autowired UsersService usersService;
    
    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks() {
        List<Book> books = bookService.getAllBooks();
        System.out.println(books.size());
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @PostMapping("/user")
    public ResponseEntity<String> getUser(@RequestBody Users credentials) {
        return  usersService.checkUser(credentials.getUsername(), credentials.getPassword()) != null ? 
            new ResponseEntity<>(usersService.createJwt(), HttpStatus.OK) : new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
}
