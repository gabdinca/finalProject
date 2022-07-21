package ro.sda.javaro35.finalProject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ro.sda.javaro35.finalProject.entities.User;
import ro.sda.javaro35.finalProject.repository.UserRepository;

@SpringBootApplication
public class FinalProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinalProjectApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository) {
        return args -> {
            User firstUser = new User();
            firstUser.setUserName("iulian.marcu");
            firstUser.setPassword("Mrc7883!");
            firstUser.setFirstName("Marcu");
            firstUser.setLastName("Iulian");
            firstUser.setEmail("iulian.marcu@gmail.com");
            firstUser.setAge(25);
            userRepository.save(firstUser);
            User secondUser = new User();
            secondUser.setUserName("gabi.dinca");
            secondUser.setPassword("gabi!@!@");
            secondUser.setFirstName("Dinca");
            secondUser.setLastName("Gabriel");
            secondUser.setEmail("gaby_gaby@gmail.com");
            secondUser.setAge(32);
            userRepository.save(secondUser);
        };
    }
}
