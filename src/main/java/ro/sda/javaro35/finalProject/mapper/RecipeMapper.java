package ro.sda.javaro35.finalProject.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sda.javaro35.finalProject.dto.RecipeDto;
import ro.sda.javaro35.finalProject.entities.Ingredient;
import ro.sda.javaro35.finalProject.entities.Recipe;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class RecipeMapper implements Mapper<Recipe, RecipeDto> {
    @Autowired
    IngredientMapper ingredientMapper;
    @Override
    public RecipeDto convertToDto(Recipe entity) {
        RecipeDto recipeDto = new RecipeDto();
        recipeDto.setDescription(entity.getDescription());
        recipeDto.setTitle(entity.getTitle());
        recipeDto.setPreparationInstructions(entity.getPreparationInstructions());
        if (entity.getIngredients()!=null){
            recipeDto.setIngredientsIds(entity.getIngredients().stream().map(i -> ingredientMapper.convertToDto(i)).collect(Collectors.toList()));
        }
        return recipeDto;
    }

    @Override
    public Recipe convertToEntity(RecipeDto dto) {
        Recipe recipe = new Recipe();
        recipe.setTitle(dto.getTitle());
        recipe.setPreparationInstructions(dto.getPreparationInstructions());
        recipe.setDescription(dto.getDescription());
        if (dto.getIngredientsIds()!=null){
            recipe.setIngredients(dto.getIngredientsIds().stream().map(i-> ingredientMapper.convertToEntity(i)).collect(Collectors.toList()));
        }
        return recipe;
    }
}
