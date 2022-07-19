package ro.sda.javaro35.finalProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.sda.javaro35.finalProject.entities.Author;

public interface UserRepository extends JpaRepository<Author, Long> {

}
