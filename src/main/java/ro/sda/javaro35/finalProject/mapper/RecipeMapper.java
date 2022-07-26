package ro.sda.javaro35.finalProject.mapper;

import org.springframework.stereotype.Service;
import ro.sda.javaro35.finalProject.dto.RecipeDto;
import ro.sda.javaro35.finalProject.entities.Recipe;

@Service
public class RecipeMapper implements Mapper<Recipe, RecipeDto> {
    @Override
    public RecipeDto convertToDto(Recipe entity) {
        RecipeDto recipeDto = new RecipeDto();
        recipeDto.setDescription(entity.getDescription());
        recipeDto.setTitle(entity.getTitle());
        recipeDto.setPreparationInstructions(entity.getPreparationInstructions());
        recipeDto.setIngredients(entity.getIngredients());
        return recipeDto;
    }

    @Override
    public Recipe convertToEntity(RecipeDto dto) {
        Recipe recipe = new Recipe();
        recipe.setTitle(dto.getTitle());
        recipe.setPreparationInstructions(dto.getPreparationInstructions());
        recipe.setDescription(dto.getDescription());
        recipe.setIngredients(dto.getIngredients());
        return recipe;
    }
}
