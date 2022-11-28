package at.fhtw.swen3.persistance.repositories;

import at.fhtw.swen3.persistence.entities.RecipientEntity;
import at.fhtw.swen3.persistence.repositories.ParcelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource("/application-test.properties")
public class ParcelRepositoryTest {
    private final String TRACKING_ID = "ABC123DE4";
    private final RecipientEntity SENDER = RecipientEntity.builder().name("sender").build();
    private final RecipientEntity RECIPIENT = RecipientEntity.builder().name("recipient").build();

    @Autowired
    private ParcelRepository parcelRepository;

}
