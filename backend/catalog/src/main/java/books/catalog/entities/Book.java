package books.catalog.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Book {
    @Id
    private long id;

    @Column(unique = true, nullable = false)
    private String isbn;
    
    private String title;
    private String author;
    private String genre;
    private int totalChapters;
    private int chaptersRead;
    private String status;
    private int score;
    private String synopsis;
    private String cover;

    public Book() {}

    public Book(long id, String isbn, String title, String author, String genre, int totalChapters) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.totalChapters = totalChapters;
    }

    public long getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public int getTotalChapters() {
        return totalChapters;
    }

    public int getChaptersRead() {
        return chaptersRead;
    }

    public String getStatus() {
        return status;
    }

    public int getScore() {
        return score;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public String getCover() {
        return cover;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setTotalChapters(int totalChapters) {
        this.totalChapters = totalChapters;
    }

    public void setChaptersRead(int chaptersRead) {
        this.chaptersRead = chaptersRead;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    @Override
    public boolean equals(Object obj) {
        return ((Book) obj).getId() == this.id;
    }
}
