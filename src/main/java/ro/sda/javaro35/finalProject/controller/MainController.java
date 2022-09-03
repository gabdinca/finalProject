package ro.sda.javaro35.finalProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ro.sda.javaro35.finalProject.dto.SearchFormDto;
import ro.sda.javaro35.finalProject.services.IngredientService;

@Controller
public class MainController {
    @Autowired
    IngredientService ingredientService;

    @GetMapping("/login")
    public String showLoginForm() {
        return "login_demo";
    }

    @GetMapping("/")
    public String showHomePage(Model model) {
        model.addAttribute("searchForm", new SearchFormDto());
        model.addAttribute("ingredients", ingredientService.getAllIngredient());

        return "homepage";
    }
}
