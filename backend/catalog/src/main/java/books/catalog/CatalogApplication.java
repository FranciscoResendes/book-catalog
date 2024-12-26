package books.catalog;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import books.catalog.entities.Book;
import books.catalog.entities.Users;
import books.catalog.repositories.BookRepository;
import books.catalog.repositories.UsersRepository;

@SpringBootApplication
public class CatalogApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatalogApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo(BookRepository br, UsersRepository ur) {
		return (args) -> {
			ur.save(new Users(1, "admin", "admin", "", null, null, null));
			ur.save(new Users(2, "user", "user", "", null, null, null));
			br.save(new Book(1,"Book 1", "Author 1", "Description 1", "Genre 1", 1));
			br.save(new Book(2,"Book 2", "Author 2", "Description 2", "Genre 2", 2));
			br.save(new Book(3,"Book 3", "Author 3", "Description 3", "Genre 3", 3));
		};
	}
}
