package ro.sda.javaro35.finalProject.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ro.sda.javaro35.finalProject.registration.RegistrationRequestDto;
import ro.sda.javaro35.finalProject.services.RegistrationService;

@RestController
@RequestMapping(path = "/user/registration")
@AllArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping
    public String register(@RequestBody RegistrationRequestDto request){
        return registrationService.register(request);
    }
    @GetMapping
    public String register() {
       //TODO
        return "register";
    }

    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token){
        return registrationService.confirmToken(token);
    }
}
