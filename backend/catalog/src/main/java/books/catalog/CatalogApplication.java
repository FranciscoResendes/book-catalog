package books.catalog;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import books.catalog.service.DataLoaderService;

@SpringBootApplication
public class CatalogApplication {



	public static void main(String[] args) {
		SpringApplication.run(CatalogApplication.class, args);
	}
	@Bean
    public CommandLineRunner demo(DataLoaderService dataLoaderService) {
        return (args) -> {
            dataLoaderService.loadUsersFromCsv();
            dataLoaderService.loadBooksFromCsv();
            dataLoaderService.loadAuthorsFromCsv();
        };
    }
}
