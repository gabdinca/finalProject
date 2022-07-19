package ro.sda.javaro35.finalProject.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ro.sda.javaro35.finalProject.dto.UserDto;
import ro.sda.javaro35.finalProject.entities.User;
import ro.sda.javaro35.finalProject.exceptions.EntityNotFoundError;
import ro.sda.javaro35.finalProject.repository.UserRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public List<User> findAll() {
        return userRepository.findAll();
    }

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
