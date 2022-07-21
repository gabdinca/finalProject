package ro.sda.javaro35.finalProject.entities;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;
import static lombok.AccessLevel.PRIVATE;

@Entity(name = "user")
@Data
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
public class User {
    @Id
    @GeneratedValue(strategy = AUTO)
    Long id;
    @Column(nullable = false)
    String userName;
    @Column(nullable = false)
    String password;
    @Column(nullable = false)
    String firstName;
    @Column(nullable = false)
    String lastName;
    @Column(unique = true, nullable = false)
    String email;
    @Column(nullable = false)
    Integer age;

}
