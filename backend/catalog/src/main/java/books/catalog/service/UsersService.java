package books.catalog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import books.catalog.entities.Users;
import books.catalog.repositories.UsersRepository;
import books.catalog.utils.JwtGenarator;

@Service
public class UsersService {
    
    @Autowired UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public Users checkUser(String username, String password) {
        return usersRepository.findByUsernameAndPassword(username, password);
    }

    public String createJwt(){
        return JwtGenarator.generateJwt(JwtGenarator.generateSessionId());
    }
}
