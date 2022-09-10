package ro.sda.javaro35.finalProject.services;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sda.javaro35.finalProject.dto.IngredientDto;
import ro.sda.javaro35.finalProject.dto.RecipeDto;
import ro.sda.javaro35.finalProject.entities.Ingredient;
import ro.sda.javaro35.finalProject.entities.Recipe;
import ro.sda.javaro35.finalProject.exceptions.EntityNotFoundError;
import ro.sda.javaro35.finalProject.mapper.IngredientMapper;
import ro.sda.javaro35.finalProject.mapper.RecipeMapper;
import ro.sda.javaro35.finalProject.repository.IngredientRepository;
import ro.sda.javaro35.finalProject.repository.RecipeRepository;
import ro.sda.javaro35.finalProject.validators.RecipeValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static lombok.AccessLevel.PRIVATE;

@Service
@AllArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class RecipeService {
    IngredientRepository ingredientRepository;
    @Autowired
    RecipeRepository recipeRepository;
    @Autowired
    RecipeValidator recipeValidator;
    IngredientMapper ingredientMapper;
    @Autowired
    RecipeMapper recipeMapper;
    @NonFinal
    public  List<IngredientDto> listWhithoutOneIngredient;

    public List<RecipeDto> findByIngredients(List<IngredientDto> ingredientDtoList) {
        List<Ingredient> ingredients = ingredientDtoList.stream()
                .map(ingredientMapper::convertToEntity)
                .collect(toList());
        List<RecipeDto> recipeDtoList = recipeRepository.findRecipesByIngredientsIn(ingredients)
                .stream()
                .map(recipeMapper::convertToDto)
                .distinct()
                .collect(toList());
        List<RecipeDto> finalList = new ArrayList<>();
        for (RecipeDto recipeDto : recipeDtoList) {
            if (recipeDto.getIngredients().equals(ingredientDtoList)) {
                finalList.add(recipeDto);
            }
        }
        return finalList;
    }

    public List<RecipeDto> getAllRecipe() {
        return recipeRepository.findAll().stream()
                .map(recipeMapper::convertToDto)
                .collect(toList());
    }

    public RecipeDto getRecipeById(final long id) {
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
        recipeValidator.validateRecipeCanBeUpdateOrDeleted(id);
        recipeRepository.save(recipe);
    }

    public void deleteRecipe(final long id) {
        recipeValidator.validateRecipeCanBeUpdateOrDeleted(id);
        recipeRepository.deleteById(id);
    }

    public String createRecipe(RecipeDto recipeDto) {
        List<IngredientDto> ingredients = recipeDto.getIngredients();
        Recipe recipe = recipeMapper.convertToEntity(recipeDto);
        recipeRepository.save(recipe);
        return "recipe save";
    }

    public List<RecipeDto> getRecipeWithoutOneIngredient(List<IngredientDto> ingredientDtoList) {
        List<Ingredient> ingredients = ingredientDtoList.stream()
                .map(ingredientMapper::convertToEntity)
                .collect(toList());

        List<RecipeDto> recipeDtoList = recipeRepository.findRecipesByIngredientsIn(ingredients)
                .stream()
                .map(recipeMapper::convertToDto)
                .filter(i -> i.getIngredients().size() == (ingredientDtoList.size() - 1))
                .distinct()
                .collect(toList());

        listWhithoutOneIngredient = recipeRepository.findRecipesByIngredientsIn(ingredients)
                .stream()
                .map(recipeMapper::convertToDto)
                .filter(i -> i.getIngredients().size() == (ingredientDtoList.size() - 1))
                .distinct()
                .flatMap(recipeDto -> recipeDto.getIngredients().stream())
                .collect(toList());

        return recipeDtoList;

    }
}
