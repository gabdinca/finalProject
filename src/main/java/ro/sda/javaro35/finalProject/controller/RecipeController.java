package ro.sda.javaro35.finalProject.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ro.sda.javaro35.finalProject.dto.IngredientDto;
import ro.sda.javaro35.finalProject.dto.RecipeDto;
import ro.sda.javaro35.finalProject.dto.SearchFormDto;
import ro.sda.javaro35.finalProject.entities.Ingredient;
import ro.sda.javaro35.finalProject.entities.Recipe;
import ro.sda.javaro35.finalProject.services.IngredientService;
import ro.sda.javaro35.finalProject.services.RecipeService;

import javax.naming.directory.SearchControls;
import java.util.List;

@Controller
@RequestMapping(path = "/recipe")
@AllArgsConstructor
public class RecipeController {
    private final RecipeService recipeService;
    private final IngredientService ingredientService;

    @GetMapping()
    public String getRecipeById() {
        // TODO: IMPLEMENT METHOD GET recipe
        return "allRecipe";
    }

    @PostMapping(path = "/search")
    @Transactional
    public String searchRecipes(@ModelAttribute SearchFormDto searchFormDto, Model model) {
        List<IngredientDto> ingredientDtoList = ingredientService.getAllIngredientsByIds(searchFormDto.getIngredientsListIds());
        List<RecipeDto> recipeDtos = recipeService.findByIngredients(ingredientDtoList);
        model.addAttribute("searchResult", recipeDtos);
        model.addAttribute("searchForm", new SearchFormDto());
        model.addAttribute("ingredients", ingredientService.getAllIngredient());
        model.addAttribute("ingredientsString", ingredientService.ingredientsToString(ingredientDtoList));

        List<RecipeDto> searchResultWithoutOneIngredient = recipeService.getRecipeWithoutOneIngredient(ingredientDtoList);
        model.addAttribute("searchResultWithoutOneIngredient", searchResultWithoutOneIngredient);
        model.addAttribute("ingredientsToString", ingredientService.ingredientsToString(recipeService.listWithoutOneIngredient));
        return "homepage";
    }
}