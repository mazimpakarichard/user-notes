package rw.user.notes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"rw.user"})
public class UserNotesApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserNotesApplication.class, args);
	}

}
