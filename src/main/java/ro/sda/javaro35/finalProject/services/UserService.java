package ro.sda.javaro35.finalProject.services;

import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import ro.sda.javaro35.finalProject.dto.UserDto;
import ro.sda.javaro35.finalProject.entities.User;
import ro.sda.javaro35.finalProject.exceptions.EntityNotFoundError;
import ro.sda.javaro35.finalProject.repository.UserRepository;

import static lombok.AccessLevel.PRIVATE;

@Service
@AllArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class UserService {
    UserRepository userRepository;
    UserMapper userMapper;

    //
    public void createUser(UserDto userDto) {
        User user = userMapper.convertToEntity(userDto);
        userRepository.save(user);
    }

    public UserDto findById(long id) {
        User entityUser = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundError(String.format("User with id %s does not exist ", id)));
        return userMapper.convertToDto(entityUser);
    }

    public void deleteById(long id) {
        userRepository.findById(id).orElseThrow(() -> new EntityNotFoundError(String.format("User with id %s does not exist", id)));
        userRepository.deleteById(id);
    }
}
