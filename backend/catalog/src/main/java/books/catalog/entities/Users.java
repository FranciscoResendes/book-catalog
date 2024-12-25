package books.catalog.entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Users {
    
    @Id
    private long id;
    private String username;
    private String password;
    private String email;
    private String role;
    @OneToMany
    private List<Book> books;
    @Temporal(TemporalType.TIMESTAMP)  
    private Date created_at;

    public Users() {}

    public Users(long id, String username, String password, String email, String role, List<Book> books, Date created_at) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.books = books;
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

    public Date getCreated_at() {
        return created_at;
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
        this.books.add(book);
    }
}
