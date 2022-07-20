package ro.sda.javaro35.finalProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.sda.javaro35.finalProject.entities.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
