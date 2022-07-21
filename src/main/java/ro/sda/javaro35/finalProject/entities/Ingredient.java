package ro.sda.javaro35.finalProject.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.AUTO;
import static lombok.AccessLevel.PRIVATE;

@Entity(name = "ingredient")
@Data
@FieldDefaults(level = PRIVATE)
@NoArgsConstructor
public class Ingredient {
    @Id
    @GeneratedValue(strategy = AUTO)
    Long id;
    @Column(nullable = false)
    String name;
    @ManyToMany(fetch = LAZY)
    List<Recipe> recipeList;


}
