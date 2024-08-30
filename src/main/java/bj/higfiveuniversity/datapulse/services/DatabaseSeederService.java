package bj.higfiveuniversity.datapulse.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.javafaker.Faker;

import bj.higfiveuniversity.datapulse.model.User;
import bj.higfiveuniversity.datapulse.repository.UserRepository;


@Service
public class DatabaseSeederService {
    @Autowired
    UserRepository  userRepository;

    private final Faker faker = new Faker();
    
    public void seedDatabase() {
        // Crée des utilisateurs

        for(int i = 0 ; i < 10 ; i++){
             String username = faker.name().username();
            //  String email = faker.internet().emailAddress();
             String email = username + "@examle.test";
             String password = faker.internet().password();
             User user = User.builder()
             .email(email)
             .username(username)
             .password(password)
             .build();


             userRepository.save(user);
        }
    }
}
