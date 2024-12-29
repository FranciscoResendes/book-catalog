package books.catalog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import books.catalog.entities.Book;
import books.catalog.entities.Users;
import books.catalog.service.BookService;
import books.catalog.service.UsersService;
import books.catalog.utils.JwtGenerator;

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
    public ResponseEntity<String> deleteUser(@RequestBody String jwt) {
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
}
