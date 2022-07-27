package ro.sda.javaro35.finalProject.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import ro.sda.javaro35.finalProject.entities.Ingredient;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Data
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
public class RecipeDto {
    String title;
    String description;
    String preparationInstructions;
    List<IngredientDto> ingredients;
}
