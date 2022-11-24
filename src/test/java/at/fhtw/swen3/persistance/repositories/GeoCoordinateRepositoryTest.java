package at.fhtw.swen3.persistance.repositories;

import at.fhtw.swen3.persistence.entities.GeoCoordinateEntity;
import at.fhtw.swen3.persistence.repositories.GeoCoordinateRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@TestPropertySource("/application-test.properties")
public class GeoCoordinateRepositoryTest {
    //GeoCoordinateEntity
    private final Double LAT = 20.0;
    private final Double LON = 10.0;

    private GeoCoordinateEntity geoCoordinateEntity;

    @Autowired
    private GeoCoordinateRepository geoCoordinateRepository;


    @BeforeEach
    void createDummyData() {
        //Arrange
        geoCoordinateEntity = GeoCoordinateEntity.builder().lat(LAT).lon(LON).hop(null).build();
        geoCoordinateRepository.save(geoCoordinateEntity);
    }

    @AfterEach
    void cleanUpData() {
        geoCoordinateRepository.delete(geoCoordinateEntity);
    }

    @Test
    void findByIdTest() {
        //Act
        Optional<GeoCoordinateEntity> result = geoCoordinateRepository.findById(geoCoordinateEntity.getId());
        //Assert
        assertTrue(result.isPresent());
        assertEquals(LAT, result.get().getLat());
        assertEquals(LON, result.get().getLat());
    }
}
