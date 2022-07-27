package ro.sda.javaro35.finalProject.mapper;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ro.sda.javaro35.finalProject.dto.RecipeDto;
import ro.sda.javaro35.finalProject.entities.Recipe;

import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RecipeMapper implements Mapper<Recipe, RecipeDto> {
    IngredientMapper ingredientMapper;
    @Override
    public RecipeDto convertToDto(Recipe entity) {
        RecipeDto recipeDto = new RecipeDto();
        recipeDto.setDescription(entity.getDescription());
        recipeDto.setTitle(entity.getTitle());
        recipeDto.setPreparationInstructions(entity.getPreparationInstructions());
        recipeDto.setIngredients(entity.getIngredients().stream().map(i->ingredientMapper.convertToDto(i)).collect(Collectors.toList()));
        return recipeDto;
    }

    @Override
    public Recipe convertToEntity(RecipeDto dto) {
        Recipe recipe = new Recipe();
        recipe.setTitle(dto.getTitle());
        recipe.setPreparationInstructions(dto.getPreparationInstructions());
        recipe.setDescription(dto.getDescription());
        recipe.setIngredients(dto.getIngredients().stream().map(i->ingredientMapper.convertToEntity(i)).collect(Collectors.toList()));
        return recipe;
    }
}
