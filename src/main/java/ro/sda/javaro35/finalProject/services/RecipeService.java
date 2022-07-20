package ro.sda.javaro35.finalProject.services;

import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import ro.sda.javaro35.finalProject.dto.RecipeDto;
import ro.sda.javaro35.finalProject.entities.Recipe;
import ro.sda.javaro35.finalProject.exceptions.EntityNotFoundError;
import ro.sda.javaro35.finalProject.repository.RecipeRepository;
import ro.sda.javaro35.finalProject.validators.RecipeValidator;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static lombok.AccessLevel.PRIVATE;

@Service
@AllArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class RecipeService {
    RecipeRepository recipeRepository;
    RecipeValidator recipeValidator;
    RecipeMapper recipeMapper;

    public List<RecipeDto> getAllRecipe() {
        return recipeRepository.findAll().stream()
                .map(recipeMapper::convertToDto)
                .collect(toList());
    }

    public RecipeDto getById(final long id) {
        Recipe recipe = recipeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundError(id + "was not found"));
        return recipeMapper.convertToDto(recipe);  // return recipeMapper.map(recipe,RecipeDto.class)
    }

    public RecipeDto saveRecipe(final RecipeDto recipeDto) {
        Recipe recipe = recipeMapper.convertToEntity(recipeDto);
        recipe = recipeRepository.save(recipe);
        return recipeMapper.convertToDto(recipe);
    }

    public void updateRecipe(final Recipe recipe, final long id) {
        recipeValidator.validateRecipeCanBeUpdated(id);
        recipeRepository.save(recipe);
    }

    public void deleteById(final long id) {
        recipeValidator.validateRecipeCanBeUpdated(id);
        recipeRepository.deleteById(id);
    }
}
