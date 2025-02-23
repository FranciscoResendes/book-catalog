package books.catalog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import books.catalog.entities.Author;
import books.catalog.entities.Book;
import books.catalog.entities.Users;
import books.catalog.service.AuthorService;
import books.catalog.service.BookService;
import books.catalog.service.UsersService;
import books.catalog.utils.JwtGenerator;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RestApiController {

    @Autowired BookService bookService;
    @Autowired UsersService usersService;
    @Autowired AuthorService authorService;

    @GetMapping("/books/{isbn}")
    public ResponseEntity<Book> getBookByIsbn(@PathVariable String isbn) {
        Book book = bookService.getBookByIsbn(isbn);
        if (book != null) {
            return new ResponseEntity<>(book, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks() {
        List<Book> books = bookService.getAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @PutMapping("/books")
    public ResponseEntity<String> addBook(@RequestHeader("Authorization") String jwt, @RequestBody Book book) {
        String sessionId = JwtGenerator.getSessionIdFromJwt(jwt);
        Users user = usersService.checkSessionId(sessionId);

        Book updatedBook = bookService.getBookByIsbn(book.getIsbn());

        if(updatedBook == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
        updatedBook.setStatus(book.getStatus());
        updatedBook.setChaptersRead(book.getChaptersRead());
        updatedBook.setScore(book.getScore());

        if(user != null) {
            user.addBooks(updatedBook);
            usersService.updateUser(user);

            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("books/search/{query}")
    public ResponseEntity<List<Book>> searchBooksByQuery(@PathVariable String query) {
        List<Book> books = bookService.getBooksByQuery(query);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }
    

    @GetMapping("/user")
    public ResponseEntity<Users> validateSession(@RequestHeader("Authorization") String jwt) {
        String sessionId = JwtGenerator.getSessionIdFromJwt(jwt);
        Users user = usersService.checkSessionId(sessionId);

        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/user/new")
    public ResponseEntity<Void> createUser(@RequestBody Users newUser) {
        usersService.updateUser(newUser);
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @PostMapping("/user")
    public ResponseEntity<String> getUser(@RequestBody Users credentials) {
        Users user = usersService.checkUser(credentials.getUsername(), credentials.getPassword());

        if (user != null) {
            String jwt = usersService.createJwt();
            user.setSessionId(JwtGenerator.getSessionIdFromJwt(jwt));

            usersService.updateUser(user);
            return new ResponseEntity<>("{\"token\": \"" + jwt + "\"}", HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @DeleteMapping("/user")
    public ResponseEntity<String> deleteUserSession(@RequestHeader("Authorization") String jwt) {
        String sessionId = JwtGenerator.getSessionIdFromJwt(jwt);
        Users user = usersService.checkSessionId(sessionId);

        if (user != null) {
            user.setSessionId(null);
            usersService.updateUser(user);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @DeleteMapping("/logout")
    public ResponseEntity<String> logout(@RequestHeader("Authorization") String jwt) {
        String sessionId = JwtGenerator.getSessionIdFromJwt(jwt);
        Users user = usersService.checkSessionId(sessionId);

        if (user != null) {
            user.setSessionId(null);
            usersService.updateUser(user);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/authors")
    public ResponseEntity<List<Author>> getAuthors() {
        List<Author> authors = authorService.getAllAuthors();
        return new ResponseEntity<>(authors, HttpStatus.OK);
    }

    @GetMapping("/authors/{name}")
    public ResponseEntity<Author> getAuthorByName(@PathVariable String name) {
        Author author = authorService.getAuthorByName(name);
        if (author != null) {
            return new ResponseEntity<>(author, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
