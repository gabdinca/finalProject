package ro.sda.javaro35.finalProject.registration;

import lombok.*;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Data
@FieldDefaults(makeFinal = true, level = PRIVATE)
public class RegistrationRequestDto {
    String firstName;
    String lastName;
    String email;
    String password;
    Integer age;
}
