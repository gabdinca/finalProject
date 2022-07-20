package ro.sda.javaro35.finalProject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import ro.sda.javaro35.finalProject.dto.UserDto;
import ro.sda.javaro35.finalProject.services.UserService;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.NO_CONTENT;
import static ro.sda.javaro35.finalProject.controller.UserController.BASE_URL;

@Controller
@RequiredArgsConstructor
@RequestMapping(BASE_URL)
public class UserController {
    static final String BASE_URL = "/users";
    private final UserService userService;

    @GetMapping("/create")
    public String userAdd(final Model model) {
        model.addAttribute("userCreate", new UserDto());
        return "user_add";
    }

    @PostMapping("/create")
    public String createUser(@ModelAttribute("userCreate") @Valid final UserDto userDto, final Errors errors, final Model model) {
        if (errors.hasErrors()) {
            return "user_create";
        }
        userService.createUser(userDto);
        return "redirect:" + BASE_URL;
    }

    @PutMapping(path = "/update/{userId}")
    @ResponseStatus(NO_CONTENT)
    public String updateUser(@PathVariable("userId") final long id, final Model model) {
        UserDto userDto = userService.findById(id);
        model.addAttribute("userDto", userDto);
        return "user_create";
    }

    @DeleteMapping("/delete/{userId}")
    @ResponseStatus(NO_CONTENT)
    public String deleteUser(@PathVariable("userId") final long id, final Model model) {
        userService.deleteById(id);
        return "redirect:" + BASE_URL;
    }
}
