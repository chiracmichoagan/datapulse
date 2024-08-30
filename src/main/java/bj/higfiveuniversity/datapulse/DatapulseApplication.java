package bj.higfiveuniversity.datapulse;

import java.time.LocalDateTime;

import bj.higfiveuniversity.datapulse.model.User;
import bj.higfiveuniversity.datapulse.repository.UserRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import bj.higfiveuniversity.datapulse.services.DatabaseSeederService;

@SpringBootApplication
public class DatapulseApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatapulseApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(DatabaseSeederService databaseSeederService) {
		return (args) -> {
			databaseSeederService.seedDatabase();
		};
	}

}
