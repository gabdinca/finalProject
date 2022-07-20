package ro.sda.javaro35.finalProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.sda.javaro35.finalProject.entities.Recipe;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe,Long> {

    List<Recipe> findAll();
}
