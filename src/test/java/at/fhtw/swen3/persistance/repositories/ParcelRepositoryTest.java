package at.fhtw.swen3.persistance.repositories;

import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.persistence.repositories.ParcelRepository;
import at.fhtw.swen3.services.dto.Recipient;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestPropertySource("/application-test.properties")
public class ParcelRepositoryTest {
    private final String TRACKING_ID = "ABC123DE4";
    private final Recipient SENDER = Recipient.builder().name("sender").build();
    private final Recipient RECIPIENT = Recipient.builder().name("recipient").build();
    private ParcelEntity parcelEntity;

    @Autowired
    private ParcelRepository parcelRepository;

    @BeforeEach
    void createDummyData() {
        //Arrange
        parcelEntity = ParcelEntity.builder().trackingId(TRACKING_ID).sender(SENDER).recipient(RECIPIENT).build();
        parcelRepository.save(parcelEntity);
    }

    @AfterEach
    void cleanUpData() {
        parcelRepository.delete(parcelEntity);
    }

    @Test
    void findByTrackingId() {
        //Act
        ParcelEntity result = parcelRepository.findByTrackingId(parcelEntity.getTrackingId());
        //Assert
        assertEquals(TRACKING_ID, result.getTrackingId());
        assertEquals(SENDER, result.getSender());
        assertEquals(RECIPIENT, result.getRecipient());
    }

    @Test
    void findBySender() {
        //Act
        List<ParcelEntity> result = parcelRepository.findBySender(parcelEntity.getSender());
        //Assert
        assertEquals(TRACKING_ID, result.get(0).getTrackingId());
        assertEquals(SENDER, result.get(0).getSender());
        assertEquals(RECIPIENT, result.get(0).getRecipient());
    }

    @Test
    void findByRecipient() {
        //Act
        List<ParcelEntity> result = parcelRepository.findByRecipient(parcelEntity.getRecipient());
        //Assert
        assertEquals(TRACKING_ID, result.get(0).getTrackingId());
        assertEquals(SENDER, result.get(0).getSender());
        assertEquals(RECIPIENT, result.get(0).getRecipient());
    }
}
