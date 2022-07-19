package ro.sda.javaro35.finalProject.repository;

import org.springframework.data.repository.CrudRepository;
import ro.sda.javaro35.finalProject.entities.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe,Long> {

}
