package ro.sda.javaro35.finalProject.dto;

import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private Integer age;
}
