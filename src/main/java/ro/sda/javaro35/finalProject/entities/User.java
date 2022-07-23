package ro.sda.javaro35.finalProject.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ro.sda.javaro35.finalProject.enums.UserRole;

import javax.persistence.*;

import java.util.Collection;
import java.util.Collections;

import static javax.persistence.GenerationType.AUTO;
import static lombok.AccessLevel.PRIVATE;


@Entity(name = "user")
@NoArgsConstructor
@Data
@FieldDefaults(level = PRIVATE)
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = AUTO)
    Long id;

    String firstname;
    String lastname;
    String email;
    String password;
    Integer age;
    @Enumerated(EnumType.STRING)
    UserRole userRole;
    Boolean locked = false;
    Boolean enabled = false;

    public User(String firstname, String lastname, String email, String password, Integer age, UserRole userRole) {

        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.age = age;
        this.userRole = userRole;

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(userRole.name());
        return Collections.singletonList(authority);
    }

    @Override
    public String getPassword(){
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    public String getFirstName() {
        return firstname;
    }

    public String getLastName() {
        return lastname;
    }

    public void setFirstName(String firstName) {
        this.firstname = firstName;
    }

    public void setLastName(String lastName) {
        this.lastname = lastName;
    }

}