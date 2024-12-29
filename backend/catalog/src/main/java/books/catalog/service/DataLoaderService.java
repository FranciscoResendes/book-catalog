package books.catalog.service;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import books.catalog.entities.Book;
import books.catalog.entities.Users;
import books.catalog.repositories.BookRepository;
import books.catalog.repositories.UsersRepository;


@Service
public class DataLoaderService {
    private static final String USERS_CSV = "csv/users.csv";
    private static final String BOOKS_CSV = "csv/books.csv";

    @Autowired 
    private UsersRepository userRepo;
    @Autowired 
    private BookRepository bookRepo;

    public void loadUsersFromCsv() {
        try (CSVReader reader = new CSVReader(new InputStreamReader(new ClassPathResource(USERS_CSV).getInputStream()))) {
            List<String[]> rows = reader.readAll();
            rows.remove(0);

            for (String[] row : rows) {
                Users user = new Users(
                    Long.parseLong(row[0]), row[1], row[2], row[3], row[4], new Date()
                );
                userRepo.save(user);
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
                Book book = new Book(
                    Long.parseLong(row[0]), row[1], row[2], row[3], row[4], Integer.parseInt(row[5])
                );
                bookRepo.save(book);
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }
}
