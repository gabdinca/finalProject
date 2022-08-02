package ro.sda.javaro35.finalProject.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ro.sda.javaro35.finalProject.dto.RecipeDto;
import ro.sda.javaro35.finalProject.services.RecipeService;

import java.util.List;

@Controller
@RequestMapping(path = "/recipe")
@AllArgsConstructor
public class RecipeController {
    private final RecipeService recipeService;

    @GetMapping()
    public String getRecipeById() {
        // TODO: IMPLEMENT METHOD GET recipe
        return "allRecipe";
    }

    @Transactional
    @PostMapping
    public String createRecipe(@ModelAttribute RecipeDto recipe) {
        return recipeService.createRecipe(recipe);
    }
}