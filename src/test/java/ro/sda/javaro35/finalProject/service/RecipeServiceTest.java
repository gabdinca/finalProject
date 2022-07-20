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

import java.util.List;

import static java.util.List.of;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

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
        List<Ingredient> firstIngredientList =of(new Ingredient());
        firstRecipe.setDescription("description");
        firstRecipe.setPreparationInstructions("instruction");
        firstRecipe.setApprovedState(true);
        firstRecipe.setTitle("title");
        firstRecipe.setIngredients(firstIngredientList);
        Recipe secondRecipe = new Recipe();
        List<Ingredient> secondIngredientList = of(new Ingredient());
        secondRecipe.setDescription("another description");
        secondRecipe.setPreparationInstructions("another instruction");
        secondRecipe.setApprovedState(true);
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
}
