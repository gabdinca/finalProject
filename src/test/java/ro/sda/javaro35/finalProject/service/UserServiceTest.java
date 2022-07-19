package ro.sda.javaro35.finalProject.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import ro.sda.javaro35.finalProject.repository.UserRepository;
import ro.sda.javaro35.finalProject.services.UserMapper;
import ro.sda.javaro35.finalProject.services.UserService;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    UserRepository userRepository;
    @InjectMocks
    UserService userService;
    @Spy
    UserMapper userMapper;

}
