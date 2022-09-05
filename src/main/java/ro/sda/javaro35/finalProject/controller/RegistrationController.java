package ro.sda.javaro35.finalProject.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ro.sda.javaro35.finalProject.dto.UserDto;
import ro.sda.javaro35.finalProject.services.RegistrationService;

@Controller
@RequestMapping(path = "/user/registration")
@AllArgsConstructor
public class RegistrationController {
    private final RegistrationService registrationService;

    @PostMapping
    public String register( UserDto request){
         registrationService.register(request);
         return "homepage";
    }
    @GetMapping
    public String register(Model model) {
       //TODO
        model.addAttribute("request", new UserDto());
        return "register";
    }

    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token, Model model){
        try {
            String result = registrationService.confirmToken(token);
            model.addAttribute("result", result);
        }catch (IllegalStateException e){
            model.addAttribute("result", e.getMessage());
        }
        return "confirmation";
    }
}
