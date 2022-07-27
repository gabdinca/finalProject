package ro.sda.javaro35.finalProject.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ro.sda.javaro35.finalProject.dto.IngredientDto;
import ro.sda.javaro35.finalProject.services.IngredientService;

import java.util.List;

import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping(path = "ingredient")
@AllArgsConstructor
public class IngredientController {
    @Autowired
    private final IngredientService ingredientService;

    @GetMapping(path = "ingredients")
    public String getAllIngredient(final Model model) {
        List<IngredientDto> ingredients = ingredientService.getAllIngredient();
        model.addAttribute("ingredients", ingredients);
        return "listOfIngredient";
    }

    @PutMapping(path = "/update/{ingredientId}")
    @ResponseStatus(NO_CONTENT)
    public String updateIngredient(@PathVariable("ingredientId") final long id, final Model model) {
        IngredientDto ingredientDto = ingredientService.getByIngredientById(id);
        model.addAttribute("ingredientDto", ingredientDto);
        return "ingredient_update";
    }

    @DeleteMapping("/delete/{ingredientId}")
    @ResponseStatus(NO_CONTENT)
    public String deleteIngredient(@PathVariable("ingredientId") final long id) {
        ingredientService.deleteIngredient(id);
        return "redirect:/ingredient";
    }
}