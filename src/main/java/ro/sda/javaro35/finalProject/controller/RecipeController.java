package ro.sda.javaro35.finalProject.controller;

import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.sda.javaro35.finalProject.dto.RecipeDto;
import ro.sda.javaro35.finalProject.entities.Recipe;
import ro.sda.javaro35.finalProject.services.RecipeService;

@RestController
@RequestMapping(path = "/recipe")
@AllArgsConstructor
public class RecipeController {
    private final RecipeService recipeService;

    @Transactional
    @PostMapping
    public String createRecipe(@RequestBody RecipeDto recipe) {
        return recipeService.createRecipe(recipe);
    }
}