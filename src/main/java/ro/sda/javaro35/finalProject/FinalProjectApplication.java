package ro.sda.javaro35.finalProject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ro.sda.javaro35.finalProject.entities.User;
import ro.sda.javaro35.finalProject.repository.UserRepository;

import static java.lang.Boolean.TRUE;
import static ro.sda.javaro35.finalProject.enums.UserRole.USER;

@SpringBootApplication
public class FinalProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinalProjectApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository) {
        return args -> {
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            User firstUser = new User();
            firstUser.setPassword(bCryptPasswordEncoder.encode("password"));
            firstUser.setFirstName("Marcu");
            firstUser.setLastName("Iulian");
            firstUser.setEmail("iulian.marcu@gmail.com");
            firstUser.setAge(25);
            firstUser.setEnabled(TRUE);
            firstUser.setUserRole(USER);
            userRepository.save(firstUser);
            User secondUser = new User();
            secondUser.setPassword(bCryptPasswordEncoder.encode("password"));
            secondUser.setFirstName("Dinca");
            secondUser.setLastName("Gabriel");
            secondUser.setEmail("gaby_gaby@gmail.com");
            secondUser.setAge(32);
            secondUser.setEnabled(TRUE);
            secondUser.setUserRole(USER);
            userRepository.save(secondUser);
        };
    }
}
