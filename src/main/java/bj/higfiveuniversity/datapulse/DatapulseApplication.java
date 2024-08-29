package bj.higfiveuniversity.datapulse;
import java.time.LocalDateTime;
import bj.higfiveuniversity.datapulse.model.User;
import bj.higfiveuniversity.datapulse.repository.UserRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DatapulseApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatapulseApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(UserRepository userRepository){
		return (args) -> {
			//Sauvegarder Jhone Doe dans la base de donnée
			 User JohnDoe = User.builder()
			 .email("Johndoe@gmail.com")
			 .username("John Doe")
			 .password("123")
			 .createdAt(LocalDateTime.now())
			 .updatedAt(LocalDateTime.now())
			 .build();
			 userRepository.save(JohnDoe);
			 User John = new User(null,
			 "John Doe",
			 "arg@gmail.com",
			 "123",
			 LocalDateTime.now(),
			 LocalDateTime.now()
			 );
			 userRepository.save(John);
		};
	}

}
