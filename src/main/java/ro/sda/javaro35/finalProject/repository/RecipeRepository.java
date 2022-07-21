package ro.sda.javaro35.finalProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.sda.javaro35.finalProject.entities.Recipe;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    List<Recipe> findAll();

    Boolean aproveRecipe();

    Boolean declineRecipe();
//    List<Recipe> findRecipeWithoutOneIngredient();
}
