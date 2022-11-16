package at.fhtw.swen3.entity;

import at.fhtw.swen3.persistence.Recipient;
import at.fhtw.swen3.persistence.TrackingInformation;
import at.fhtw.swen3.persistence.entities.HopArrival;
import at.fhtw.swen3.persistence.entities.Parcel;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@SpringBootTest
public class ParcelTest {

    Recipient sender = new Recipient("Shop", "Shopping Street", "A-12005", "Vienna", "Austria");
    Recipient recipient = new Recipient("Fritz", "Schulgasse 1", "D-4020", "Linz", "Austria");

    List<HopArrival> visitedHops = new ArrayList<HopArrival>() {
        {
            add(new HopArrival("123", "visited1", OffsetDateTime.now()));
            add(new HopArrival("456", "visited2", OffsetDateTime.now()));
            add(new HopArrival("789", "visited3", OffsetDateTime.now()));
        }
    };

    List<HopArrival> futureHops = new ArrayList<HopArrival>() {
        {
            add(new HopArrival("123", "future1", OffsetDateTime.now()));
            add(new HopArrival("456", "future2", OffsetDateTime.now()));
            add(new HopArrival("789", "future3", OffsetDateTime.now()));
        }
    };

    @Test
    void validationTest() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Parcel parcel = new Parcel("123456", -1.0f, sender, recipient, TrackingInformation.StateEnum.INTRANSPORT, visitedHops, futureHops);

        Set<ConstraintViolation<Parcel>> violations = validator.validate(parcel);
        for (ConstraintViolation<Parcel> violation : violations) {
            //log.error(violation.getMessage());
            System.out.println(violation.getMessage());
        }
    }
}
