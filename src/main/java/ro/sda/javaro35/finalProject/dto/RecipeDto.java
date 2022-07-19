package ro.sda.javaro35.finalProject.dto;

import lombok.Data;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Data
@FieldDefaults(level = PRIVATE)
public class RecipeDto {
    Long id;
    String recipeName;
    String approvedState;
    String ingredient1;
    String ingredient2;
    String ingredient3;
    String ingredient4;
    String ingredient5;
    String ingredient6;
}
