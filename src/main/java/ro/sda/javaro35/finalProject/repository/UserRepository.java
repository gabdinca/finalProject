package ro.sda.javaro35.finalProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.javaro35.finalProject.entities.User;

import java.util.Optional;


@Transactional(readOnly = true)
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    @Transactional
    @Modifying
    @Query("UPDATE user a SET a.enabled = TRUE WHERE a.email = ?1")
    int enableUser(String email);

}

