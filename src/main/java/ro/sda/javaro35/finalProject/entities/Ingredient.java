package ro.sda.javaro35.finalProject.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.AUTO;
import static lombok.AccessLevel.PRIVATE;

@Entity(name = "ingredient")
@Data
@FieldDefaults(level = PRIVATE)
@NoArgsConstructor
@ToString(exclude = "recipeList")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = AUTO)
    Long id;
    @Column(nullable = false)
    String name;
    @ManyToMany(cascade = MERGE)
    List<Recipe> recipeList;
}
