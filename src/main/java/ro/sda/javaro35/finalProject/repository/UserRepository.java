package ro.sda.javaro35.finalProject.repository;

import org.springframework.data.repository.CrudRepository;
import ro.sda.javaro35.finalProject.entities.User;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findAll();
}
