package ro.sda.javaro35.finalProject.controller;

import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import ro.sda.javaro35.finalProject.FinalProjectApplication;
import ro.sda.javaro35.finalProject.repository.UserRepository;

import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@SpringBootTest(classes = FinalProjectApplication.class)
@AutoConfigureMockMvc(addFilters = false)
@TestInstance(PER_CLASS)
public class UserControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    UserRepository userRepository;
}
