package at.fhtw.swen3.persistance.repositories;

import at.fhtw.swen3.persistence.entities.RecipientEntity;
import at.fhtw.swen3.persistence.repositories.RecipientRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestPropertySource("/application-test.properties")
public class RecipientRepositoryTest {
    //RecipientEntity
    private final String NAME = "MaxMuster";
    private final String STREET = "Teststraße 1";
    private final String CITY = "Vienna";
    private final String COUNTRY = "Austria";
    private final String POSTALCODE = "A-1234";

    private RecipientEntity recipientEntity;

    @Autowired
    private RecipientRepository recipientRepository;


    @BeforeEach
    void createDummyData() {
        //Arrange
        recipientEntity = RecipientEntity.builder().name(NAME).street(STREET).city(CITY).country(COUNTRY).postalCode(POSTALCODE).parcel(null).build();
        recipientRepository.save(recipientEntity);
    }

    @AfterEach
    void cleanUpData() {
        recipientRepository.delete(recipientEntity);
    }

    @Test
    void findByIdTest() {
        //Act
        Optional<RecipientEntity> result = recipientRepository.findById(recipientEntity.getId());
        //Assert
        assertTrue(result.isPresent());
    }

    @Test
    void findByNameTest() {
        //Act
        List<RecipientEntity> result = recipientRepository.findByName(NAME);
        //Assert
        assertEquals(NAME, result.get(0).getName());
        assertEquals(STREET, result.get(0).getStreet());
        assertEquals(CITY, result.get(0).getCity());
        assertEquals(COUNTRY, result.get(0).getCountry());
        assertEquals(POSTALCODE, result.get(0).getPostalCode());
    }

}
