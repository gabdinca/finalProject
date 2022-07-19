package ro.sda.javaro35.finalProject.entities;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import static javax.persistence.GenerationType.AUTO;
import static lombok.AccessLevel.PRIVATE;

@Entity(name = "user")
@NoArgsConstructor
@Data
@FieldDefaults(level = PRIVATE)
public class User {
    @Id
    @GeneratedValue(strategy = AUTO)
    Long id;
    String userName;
    String password;
    String firstName;
    String lastName;
    String email;
    Integer age;

}
