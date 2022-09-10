package ro.sda.javaro35.finalProject.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Data
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
public class IngredientDto {

    Long id;
    String name;
}

