package ro.sda.javaro35.finalProject.dto;

import lombok.Data;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Data
@FieldDefaults(level = PRIVATE)
public class IngredientDto {
    Long id;
    String name;
}
