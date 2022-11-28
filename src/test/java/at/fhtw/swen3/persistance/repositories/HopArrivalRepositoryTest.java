package at.fhtw.swen3.persistance.repositories;

import at.fhtw.swen3.persistence.entities.HopArrivalEntity;
import at.fhtw.swen3.persistence.repositories.HopArrivalRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestPropertySource("/application-test.properties")
public class HopArrivalRepositoryTest {
    /*
    //HopArrivalEntity
    private final String CODE = "ABCD1234";
    private final String DESCRIPTION = "Description";
    private final OffsetDateTime DATETIME = OffsetDateTime.now();

    private HopArrivalEntity hopArrivalEntity;

    @Autowired
    private HopArrivalRepository hopArrivalRepository;


    @BeforeEach
    void createDummyData() {
        //Arrange
        hopArrivalEntity = HopArrivalEntity.builder().code(CODE).description(DESCRIPTION).dateTime(DATETIME).build();
        hopArrivalRepository.save(hopArrivalEntity);
    }

    @AfterEach
    void cleanUpData() {
        hopArrivalRepository.delete(hopArrivalEntity);
    }

    @Test
    void findByCodeTest() {
        //Act
        HopArrivalEntity result = hopArrivalRepository.findByCode(hopArrivalEntity.getCode());
        //Assert
        assertEquals(DESCRIPTION, result.getDescription());
        assertEquals(DATETIME, result.getDateTime());
    }
    */
    @Test
    void findByIdTestDummy() {

    }
}
