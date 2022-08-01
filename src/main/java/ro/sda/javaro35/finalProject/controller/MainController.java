package ro.sda.javaro35.finalProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/login")
    public String showLoginForm() {
        return "login_demo";
    }
    @GetMapping("/")
    public String showHomePage() {
        return "homepage";
    }
}
