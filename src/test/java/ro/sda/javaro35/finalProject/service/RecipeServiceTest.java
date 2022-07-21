package ro.sda.javaro35.finalProject.service;

import lombok.val;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import ro.sda.javaro35.finalProject.entities.Ingredient;
import ro.sda.javaro35.finalProject.entities.Recipe;
import ro.sda.javaro35.finalProject.repository.RecipeRepository;
import ro.sda.javaro35.finalProject.services.RecipeMapper;
import ro.sda.javaro35.finalProject.services.RecipeService;
import ro.sda.javaro35.finalProject.validators.RecipeValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import static java.util.List.of;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static ro.sda.javaro35.finalProject.enums.RecipeStatus.APROVED;

@ExtendWith(MockitoExtension.class)
public class RecipeServiceTest {
    @Mock
    RecipeRepository recipeRepository;
    @Mock
    RecipeValidator recipeValidator;
    @InjectMocks
    RecipeService recipeService;
    @Spy
    RecipeMapper recipeMapper;

    @Test
    void getAllRecipeSuccessful() {
        // given
        Recipe firstRecipe = new Recipe();
        List<Ingredient> firstIngredientList = new ArrayList<>(of(new Ingredient(), new Ingredient()));
//        firstIngredientList.add
        List<String> list = of("Ana","Are","Mere");
        firstRecipe.setDescription("description");
        firstRecipe.setPreparationInstructions("instruction");
        firstRecipe.setRecipeStatus(APROVED);
        firstRecipe.setTitle("title");
        firstRecipe.setIngredients(firstIngredientList);
        Recipe secondRecipe = new Recipe();
        List<Ingredient> secondIngredientList = of(new Ingredient());
        secondRecipe.setDescription("another description");
        secondRecipe.setPreparationInstructions("another instruction");
        secondRecipe.setRecipeStatus(APROVED);
        secondRecipe.setTitle("another title");
        secondRecipe.setIngredients(secondIngredientList);
        val recipeList = of(firstRecipe, secondRecipe);
        when(recipeRepository.findAll()).thenReturn(recipeList);

        // when
        val receivedRecipeList = recipeService.getAllRecipe();

        // then
        assertEquals(receivedRecipeList.get(0).getId(), receivedRecipeList.get(0).getId());
        assertEquals(receivedRecipeList.get(0).getDescription(), receivedRecipeList.get(0).getDescription());
        assertEquals(receivedRecipeList.get(0).getTitle(), receivedRecipeList.get(0).getTitle());
        assertEquals(receivedRecipeList.get(0).getPreparationInstructions(), receivedRecipeList.get(0).getPreparationInstructions());
        assertEquals(receivedRecipeList.get(1).getId(), receivedRecipeList.get(1).getId());
        assertEquals(receivedRecipeList.get(1).getDescription(), receivedRecipeList.get(1).getDescription());
        assertEquals(receivedRecipeList.get(1).getTitle(), receivedRecipeList.get(1).getTitle());
        assertEquals(receivedRecipeList.get(1).getPreparationInstructions(), receivedRecipeList.get(1).getPreparationInstructions());
    }

    @Test
    void getRecipeByIdSuccessful() {
        // given
        Random random = new Random();
        long id = 1 + random.nextLong();
        List<Ingredient> ingredientList = of(new Ingredient());
        Recipe recipe = new Recipe();
        recipe.setTitle("title");
        recipe.setIngredients(ingredientList);
        recipe.setDescription("description");
        recipe.setPreparationInstructions("preparation instruction");
        recipe.setRecipeStatus(APROVED);
        val optionalRecipe = Optional.of(recipe);
        when(recipeRepository.findById(id)).thenReturn((optionalRecipe));

        // when
        val receivedRecipe = recipeService.getRecipeById(id);

        //then
        assertEquals(receivedRecipe.getId(), recipe.getId());
        assertEquals(receivedRecipe.getTitle(), recipe.getTitle());
        assertEquals(receivedRecipe.getDescription(), recipe.getDescription());
        assertEquals(receivedRecipe.getPreparationInstructions(), recipe.getPreparationInstructions());
    }
}
