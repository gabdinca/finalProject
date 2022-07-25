package ro.sda.javaro35.finalProject.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sda.javaro35.finalProject.dto.IngredientDto;
import ro.sda.javaro35.finalProject.entities.Ingredient;
import ro.sda.javaro35.finalProject.repository.IngredientRepository;

@Service
public class IngredientMapper implements Mapper<Ingredient, IngredientDto> {
    @Autowired
    IngredientRepository ingredientRepository;
    @Override
    public IngredientDto convertToDto(Ingredient entity) {
        IngredientDto ingredientDto = new IngredientDto();
        ingredientDto.setId(entity.getId());
        ingredientDto.setName(entity.getName());
        return ingredientDto;
    }

    @Override
    public Ingredient convertToEntity(IngredientDto dto) {
        Ingredient ingredient = ingredientRepository.findById(dto.getId()).orElse(new Ingredient());
        ingredient.setName(dto.getName());
        return ingredient;
    }
}
