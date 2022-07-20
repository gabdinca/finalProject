package ro.sda.javaro35.finalProject.services;

import org.springframework.stereotype.Service;
import ro.sda.javaro35.finalProject.dto.IngredientDto;
import ro.sda.javaro35.finalProject.entities.Ingredient;

@Service
public class IngredientMapper implements Mapper<Ingredient, IngredientDto> {
    @Override
    public IngredientDto convertToDto(Ingredient entity) {
        IngredientDto ingredientDto = new IngredientDto();
        ingredientDto.setId(entity.getId());
        ingredientDto.setName(entity.getName());
        return ingredientDto;
    }

    @Override
    public Ingredient convertToEntity(IngredientDto dto) {
        Ingredient ingredient = new Ingredient();
        ingredient.setId(dto.getId());
        ingredient.setName(dto.getName());
        return ingredient;
    }
}
