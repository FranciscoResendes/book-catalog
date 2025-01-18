package books.catalog.entities;



import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
 public class Author {

    @Id
    private Long id;
    private String name;
    private String bio;
    private LocalDate born;

    public Author() {}

    public Author(Long id, String name, String bio, LocalDate born) {
        this.id = id;
        this.name = name;
        this.bio = bio;
        this.born = born;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBio() {
        return bio;
    }

    public LocalDate getBorn() {
        return born;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setBorn(LocalDate born) {
        this.born = born;
    }
    
}