package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.TruckEntity;
import at.fhtw.swen3.services.dto.Truck;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TruckMapperTest {
    private String REGION_GEO_JSON = "Region";
    private String NUMBER_PLATE = "W-12345";

    @Test
    void entityToDTO() {
        TruckEntity truckEntity = new TruckEntity();
        truckEntity.setRegionGeoJson(REGION_GEO_JSON);
        truckEntity.setNumberPlate(NUMBER_PLATE);

        Truck truck = TruckMapper.INSTANCE.entityToDTO(truckEntity);

        assertEquals( REGION_GEO_JSON, truck.getRegionGeoJson());
        assertEquals( NUMBER_PLATE, truck.getNumberPlate());
    }

    @Test
    void dtoToEntity() {
        Truck truck = new Truck();
        truck.setRegionGeoJson(REGION_GEO_JSON);
        truck.setNumberPlate(NUMBER_PLATE);

        TruckEntity truckEntity = TruckMapper.INSTANCE.dtoToEntity(truck);

        assertEquals( REGION_GEO_JSON, truckEntity.getRegionGeoJson());
        assertEquals( NUMBER_PLATE, truckEntity.getNumberPlate());
    }
}
