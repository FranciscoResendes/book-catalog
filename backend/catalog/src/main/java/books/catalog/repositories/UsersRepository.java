package books.catalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import books.catalog.entities.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {
    
}
