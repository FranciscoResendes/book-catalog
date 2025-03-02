package books.catalog.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Users {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String password;
    private String email;
    private String role;
    @OneToMany
    private List<Book> books;
    private LocalDate created_at;
    private String sessionId;

    public Users() {}

    public Users(String username, String password, String email, String role, LocalDate created_at) {

        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.books = new ArrayList<>();
        this.created_at = created_at;
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public List<Book> getBooks() {
        return books;
    }

    public LocalDate getCreated_at() {
        return created_at;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void addBooks(Book book) {
        if(this.books.contains(book))  this.books.remove(book);

        this.books.add(book);
    }

    public void setCreated_at(LocalDate created_at) {
        this.created_at = created_at;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
