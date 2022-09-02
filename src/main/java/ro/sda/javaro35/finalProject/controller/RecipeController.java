package ro.sda.javaro35.finalProject.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ro.sda.javaro35.finalProject.dto.IngredientDto;
import ro.sda.javaro35.finalProject.dto.RecipeDto;
import ro.sda.javaro35.finalProject.entities.Ingredient;
import ro.sda.javaro35.finalProject.entities.Recipe;
import ro.sda.javaro35.finalProject.services.RecipeService;

import java.util.List;

@RestController
@RequestMapping(path = "/recipe")
@AllArgsConstructor
public class RecipeController {
    private final RecipeService recipeService;

    @GetMapping()
    public String getRecipeById() {
        // TODO: IMPLEMENT METHOD GET recipe
        return "allRecipe";
    }

    @PostMapping(path = "/search")
    @Transactional
    public String searchRecipes(@RequestBody List<IngredientDto> ingredientDtoList){
        List<RecipeDto> recipeDtos = recipeService.findByIngredients(ingredientDtoList);
        return "recipelist";
    }

    @Transactional
    @PostMapping
    public String createRecipe(@RequestBody RecipeDto recipeDto) {
        return recipeService.createRecipe(recipeDto);
    }
}