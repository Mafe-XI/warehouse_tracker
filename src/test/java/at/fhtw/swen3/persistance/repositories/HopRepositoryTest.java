package at.fhtw.swen3.persistance.repositories;

import at.fhtw.swen3.persistence.entities.GeoCoordinateEntity;
import at.fhtw.swen3.persistence.entities.HopEntity;
import at.fhtw.swen3.persistence.repositories.HopRepository;
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
public class HopRepositoryTest {
    /*
    //HopEntity
    private final String HOP_TYPE = "Type";
    private final String CODE = "ABCD1234";
    private final String DESCRIPTION = "Description";
    private final Integer PROCESSING_DELAY_MINS = 3;
    private final String LOCATION_NAME = "Location Name";

    //GeoCoordinateEntity
    private final Double LAT = 20.0;
    private final Double LON = 10.0;

    private HopEntity hopEntity;

    @Autowired
    private HopRepository hopRepository;

    @BeforeEach
    void createDummyData() {
        //Arrange
        GeoCoordinateEntity geoCoordinateEntity = GeoCoordinateEntity.builder().lat(LAT).lon(LON).hop(null).build();
        hopEntity = HopEntity.builder()
                .hopType(HOP_TYPE)
                .code(CODE)
                .description(DESCRIPTION)
                .processingDelayMins(PROCESSING_DELAY_MINS)
                .locationName(LOCATION_NAME)
                .locationCoordinates(geoCoordinateEntity)
                .build();
        hopRepository.save(hopEntity);
    }

    @AfterEach
    void cleanUpData() {
        hopRepository.delete(hopEntity);
    }

    @Test
    void findByCodeTest() {
        //Act
        HopEntity result = hopRepository.findByCode(hopEntity.getCode());
        //Assert
        assertEquals(HOP_TYPE, result.getHopType());
        assertEquals(DESCRIPTION, result.getDescription());
        assertEquals(PROCESSING_DELAY_MINS, result.getProcessingDelayMins());
        assertEquals(LOCATION_NAME, result.getLocationName());
        assertEquals(LAT, result.getLocationCoordinates().getLat());
        assertEquals(LON, result.getLocationCoordinates().getLon());
    }

    @Test
    void findByLocationName() {
        //Act
        List<HopEntity> result = hopRepository.findByLocationName(hopEntity.getLocationName());
        //Assert
        assertEquals(HOP_TYPE, result.get(0).getHopType());
        assertEquals(CODE, result.get(0).getCode());
        assertEquals(DESCRIPTION, result.get(0).getDescription());
        assertEquals(PROCESSING_DELAY_MINS, result.get(0).getProcessingDelayMins());
        assertEquals(LAT, result.get(0).getLocationCoordinates().getLat());
        assertEquals(LON, result.get(0).getLocationCoordinates().getLon());
    }
    */
    @Test
    void findByIdTestDummy() {

    }
}
