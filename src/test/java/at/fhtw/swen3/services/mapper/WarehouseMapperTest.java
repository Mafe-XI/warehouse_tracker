package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.*;
import at.fhtw.swen3.services.dto.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class WarehouseMapperTest {
    private final Integer LEVEL = 3;
    private final String NEXT_HOP = "nextHop";
    private final Long WAREHOUSE_NEXTHOP_ID = 1L;
    private final int TRAVELTIME_MINS = 2;
    private final String WAREHOUSE_CODE = "warehouse";
    private final String DESCRIPTION = "description";
    private final String HOP_TYPE = "hopType";
    private final String LOCATION_NAME = "locationName";
    private final int DELAY = 2;
    private final double LAT = 1.0;
    private final double LON = 2.0;

    private List<WarehouseNextHopsEntity> nextHops = new ArrayList<WarehouseNextHopsEntity>() {
        {
            //add(new WarehouseNextHopsEntity(WAREHOUSE_NEXTHOP_ID, TRAVELTIME_MINS, new HopEntity(), new WarehouseEntity()));
        }
    };

    @Test
    void entityToDTO() {

    }

    @Test
    void dtoToEntity() {

    }

    private Warehouse buildWarehouse() {
        return new Warehouse()
                .code(WAREHOUSE_CODE)
                .description(DESCRIPTION)
                .hopType(HOP_TYPE)
                .locationCoordinates(new GeoCoordinate().lat(LAT).lon(LON))
                .locationName(LOCATION_NAME)
                .processingDelayMins(DELAY)
                .level(LEVEL);
    }

    private Hop createHop() {
        return new Hop()
                .code(NEXT_HOP)
                .description(DESCRIPTION)
                .hopType(HOP_TYPE)
                .locationCoordinates(new GeoCoordinate().lat(LAT).lon(LON))
                .locationName(LOCATION_NAME)
                .processingDelayMins(DELAY);
    }
}
