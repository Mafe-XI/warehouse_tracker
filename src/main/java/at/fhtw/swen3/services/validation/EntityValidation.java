package at.fhtw.swen3.services.validation;

import at.fhtw.swen3.persistence.entities.EntityBase;
import at.fhtw.swen3.persistence.entities.RecipientEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

@Service
public class EntityValidation {

    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = factory.getValidator();

    public boolean validate(EntityBase entity) {
        Set<ConstraintViolation<EntityBase>> violations = validator.validate(entity);
        for (ConstraintViolation<EntityBase> violation : violations) {
            System.out.println(violation.getMessage());
        }
        return !violations.isEmpty();
    }

    public boolean conditionalValidate(RecipientEntity recipientEntity) {
        Set<ConstraintViolation<EntityBase>> violations = validator.validate(recipientEntity);
        if (!(recipientEntity.getCountry() == "Austria" || recipientEntity.getCountry() == "Österreich")) {
            //violations.remove();
        }
        for (ConstraintViolation<EntityBase> violation : violations) {
            System.out.println(violation.getMessage());
        }
        return !violations.isEmpty();
    }
}
