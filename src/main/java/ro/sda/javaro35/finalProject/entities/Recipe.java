package ro.sda.javaro35.finalProject.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import static javax.persistence.GenerationType.AUTO;
import static lombok.AccessLevel.PRIVATE;

@Entity
@Data
@FieldDefaults(level = PRIVATE)
@NoArgsConstructor
public class Recipe {

    @Id
    @GeneratedValue(strategy = AUTO)
    Long id;
    String recipeName;
    String approvedState;
    String ingredient1;
    String ingredient2;
    String ingredient3;
    String ingredient4;
    String ingredient5;
    String ingredient6;
}
