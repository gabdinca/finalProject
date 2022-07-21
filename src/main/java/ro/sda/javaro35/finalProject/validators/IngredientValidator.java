package ro.sda.javaro35.finalProject.validators;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ro.sda.javaro35.finalProject.exceptions.EntityNotFoundError;
import ro.sda.javaro35.finalProject.repository.IngredientRepository;

@Component
@RequiredArgsConstructor
@Slf4j
public class IngredientValidator {
    private final IngredientRepository ingredientRepository;

    public void validateIngredientCanBeUpdateOrDeleted(final long id) {
        if (!ingredientRepository.existsById(id)) {
            log.warn("{} does not exist in the database", id);
            throw new EntityNotFoundError(id + " was not found");
        }
    }
}
