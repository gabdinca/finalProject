package ro.sda.javaro35.finalProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.javaro35.finalProject.entities.Ingredient;
import ro.sda.javaro35.finalProject.entities.Recipe;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    List<Recipe> findAll();

    @Transactional
    @Modifying
    @Query("select r from recipe r WHERE r.ingredients = ?1")
    List<Recipe> findByListOfIngredients(List<Ingredient> ingredients);
//    @Query(value = "SELECT recipe from recipe join ingredient i where i.id = :ingredientList")
//    List<Recipe> findAllByIngredientsContaining(List<Ingredient> ingredientList);
//    List<Recipe> findByDescriptionContainingIgnoreCase(String description);
//    List<Recipe> findRecipeWithoutOneIngredient();
}
