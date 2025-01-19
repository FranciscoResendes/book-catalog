package books.catalog.service;

import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import books.catalog.entities.Author;
import books.catalog.entities.Book;
import books.catalog.entities.Users;
import books.catalog.repositories.AuthorRepository;
import books.catalog.repositories.BookRepository;
import books.catalog.repositories.UsersRepository;


@Service
public class DataLoaderService {
    private static final String USERS_CSV = "csv/users.csv";
    private static final String BOOKS_CSV = "csv/books.csv";
    private static final String AUTHORS_CSV = "csv/author.csv";

    @Autowired 
    private UsersRepository userRepo;
    @Autowired 
    private BookRepository bookRepo;
    @Autowired
    private AuthorRepository authorRepo;

    public void loadUsersFromCsv() {
        try (CSVReader reader = new CSVReader(new InputStreamReader(new ClassPathResource(USERS_CSV).getInputStream()))) {
            List<String[]> rows = reader.readAll();
            rows.remove(0);

            for (String[] row : rows) {
                Users user = new Users(
                    Long.parseLong(row[0]), row[1], row[2], row[3], row[4], LocalDate.parse(row[5])
                );
                userRepo.save(user);
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }

    public void loadAuthorsFromCsv() {
        try (CSVReader reader = new CSVReader(new InputStreamReader(new ClassPathResource(AUTHORS_CSV).getInputStream()))) {
            List<String[]> rows = reader.readAll();
            rows.remove(0);

            for (String[] row : rows) {
                Author author = new Author(
                    Long.parseLong(row[0]), row[1], row[2], LocalDate.parse(row[3]), row[4]
                );
                authorRepo.save(author);
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }

    public void loadBooksFromCsv() {
        try (CSVReader reader = new CSVReader(new InputStreamReader(new ClassPathResource(BOOKS_CSV).getInputStream()))) {
            List<String[]> rows = reader.readAll();
            rows.remove(0);

            for (String[] row : rows) {
                Author author = authorRepo.findByName(row[3]);
                Book book = new Book(
                    Long.parseLong(row[0]), row[1], row[2], author, row[4], Integer.parseInt(row[5])
                );
                book.setCover(row[6]);
                bookRepo.save(book);
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }
}
