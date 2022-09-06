package ro.sda.javaro35.finalProject.services;

import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import ro.sda.javaro35.finalProject.dto.IngredientDto;
import ro.sda.javaro35.finalProject.entities.Ingredient;
import ro.sda.javaro35.finalProject.exceptions.EntityNotFoundError;
import ro.sda.javaro35.finalProject.mapper.IngredientMapper;
import ro.sda.javaro35.finalProject.repository.IngredientRepository;
import ro.sda.javaro35.finalProject.validators.IngredientValidator;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static lombok.AccessLevel.PRIVATE;

@Service
@AllArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class IngredientService {
    IngredientRepository ingredientRepository;
    IngredientMapper ingredientMapper;
    IngredientValidator ingredientValidator;

    public List<IngredientDto> getAllIngredient() {
        return ingredientRepository.findAll().stream()
                .map(ingredientMapper::convertToDto)
                .collect(toList());
    }

    public List<IngredientDto> getAllIngredientsByIds(List<Long> ingredientsIds) {
        return ingredientRepository.findAllByIdIn(ingredientsIds).stream()
                .map(ingredientMapper::convertToDto)
                .collect(toList());
    }

    public IngredientDto getByIngredientById(final long id) {
        Ingredient ingredient = ingredientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundError(id + "was not found"));
        return ingredientMapper.convertToDto(ingredient);
    }

    public IngredientDto saveIngredient(final IngredientDto ingredientDto) {
        Ingredient ingredient = ingredientMapper.convertToEntity(ingredientDto);
        ingredient = ingredientRepository.save(ingredient);
        return ingredientMapper.convertToDto(ingredient);
    }

    public void updateIngredient(final Ingredient ingredient, final long id) {
        ingredientValidator.validateIngredientCanBeUpdateOrDeleted(id);
        ingredientRepository.save(ingredient);
    }

    public void deleteIngredient(final long id) {
        ingredientValidator.validateIngredientCanBeUpdateOrDeleted(id);
        ingredientRepository.deleteById(id);
    }

    public String ingredientsToString(List<IngredientDto> ingredientList) {
        StringBuilder stringBuilder = new StringBuilder();

        for (IngredientDto ingredientDto : ingredientList) {
            stringBuilder.append(ingredientDto.getName()).append("  ");
        }
        return stringBuilder.toString();
    }
}