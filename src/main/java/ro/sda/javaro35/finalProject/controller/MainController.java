package ro.sda.javaro35.finalProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ro.sda.javaro35.finalProject.dto.RecipeDto;
import ro.sda.javaro35.finalProject.dto.SearchFormDto;
import ro.sda.javaro35.finalProject.services.IngredientService;
import ro.sda.javaro35.finalProject.services.RecipeService;

@Controller
public class MainController {
    @Autowired
    RecipeService recipeService;
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

    @GetMapping(path = "/new-recipe")
    public String showNewRecipePage(@ModelAttribute RecipeDto recipeDto, Model model) {
        return "new-recipe";
    }

    @PostMapping(path = "/new-recipe")
    @Transactional
    public String createRecipe(@ModelAttribute RecipeDto recipeDto, Model model, @ModelAttribute SearchFormDto searchFormDto) {
        model.addAttribute("ingredients", ingredientService.getAllIngredient());
        model.addAttribute("searchForm", new SearchFormDto());
        return recipeService.createRecipe(recipeDto);
    }
}
