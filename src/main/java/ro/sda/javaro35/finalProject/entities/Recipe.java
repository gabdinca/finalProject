package ro.sda.javaro35.finalProject.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import ro.sda.javaro35.finalProject.enums.RecipeStatus;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.AUTO;
import static lombok.AccessLevel.PRIVATE;

@Entity(name = "recipe")
@Data
@FieldDefaults(level = PRIVATE)
@NoArgsConstructor
public class Recipe {

    @Id
    @GeneratedValue(strategy = AUTO)
    Long id;
    @Column(nullable = false)
    String title;
    @Column(nullable = false)
    String description;
    @Column(nullable = false)
    String preparationInstructions;
    @ManyToMany(fetch = LAZY)
    List<Ingredient> ingredients;
    @Enumerated(STRING)
    RecipeStatus recipeStatus;

}
