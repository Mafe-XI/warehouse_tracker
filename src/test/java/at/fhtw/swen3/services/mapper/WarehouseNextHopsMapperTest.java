package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.*;
import at.fhtw.swen3.services.dto.GeoCoordinate;
import at.fhtw.swen3.services.dto.Hop;
import at.fhtw.swen3.services.dto.Truck;
import at.fhtw.swen3.services.dto.WarehouseNextHops;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import sun.security.krb5.internal.crypto.Des;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class WarehouseNextHopsMapperTest {
    //GeoCoordinate
    private final Double LAT = 10.0;
    private final Double LON = 20.0;
    //HopEntity
    private final Long HOP_ID = 1L;
    private final String HOP_TYPE = "hopType";
    private final String CODE = "code";
    private final String DESCRIPTION = "description";
    private final int DELAY = 10;
    private final String LOCATION = "location";
    //WarehouseEntity
    private final Long ID = 1L;
    private final Integer TRAVELTIME_MINS = 2;
    private final HopEntity HOP = new HopEntity(HOP_ID, HOP_TYPE, CODE, DESCRIPTION, DELAY, LOCATION, new GeoCoordinateEntity());
    private final WarehouseEntity WAREHOUSE = new WarehouseEntity();

    @Test
    void entityToDTO() {
        WarehouseNextHopsEntity warehouseNextHopsEntity = new WarehouseNextHopsEntity();
        warehouseNextHopsEntity.setId(ID);
        warehouseNextHopsEntity.setTraveltimeMins(TRAVELTIME_MINS);
        warehouseNextHopsEntity.setHop(HOP);
        warehouseNextHopsEntity.setWarehouse(WAREHOUSE);

        WarehouseNextHops warehouseNextHops = WarehouseNextHopsMapper.INSTANCE.entityToDTO(warehouseNextHopsEntity);

        assertEquals( TRAVELTIME_MINS, warehouseNextHops.getTraveltimeMins());
        assertEquals( HOP_TYPE, warehouseNextHops.getHop().getHopType());
        assertEquals( CODE, warehouseNextHops.getHop().getCode());
        assertEquals(DESCRIPTION, warehouseNextHops.getHop().getDescription());
        assertEquals(DELAY, warehouseNextHops.getHop().getProcessingDelayMins());
        assertEquals(LOCATION, warehouseNextHops.getHop().getLocationName());
    }

    @Test
    void dtoToEntity() {
        WarehouseNextHops warehouseNextHops = new WarehouseNextHops();
        warehouseNextHops.setTraveltimeMins(TRAVELTIME_MINS);
        warehouseNextHops.setHop(createHop());

        WarehouseNextHopsEntity warehouseNextHopsEntity = WarehouseNextHopsMapper.INSTANCE.dtoToEntity(warehouseNextHops);

        assertEquals( TRAVELTIME_MINS, warehouseNextHopsEntity.getTraveltimeMins());
        assertEquals( CODE, warehouseNextHopsEntity.getHop().getCode());
        assertEquals( DESCRIPTION, warehouseNextHopsEntity.getHop().getDescription());
        assertEquals( HOP_TYPE, warehouseNextHopsEntity.getHop().getHopType());
        assertEquals( LAT, warehouseNextHopsEntity.getHop().getLocationCoordinates().getLat());
        assertEquals( LON, warehouseNextHopsEntity.getHop().getLocationCoordinates().getLon());
        assertEquals( LOCATION, warehouseNextHopsEntity.getHop().getLocationName());
        assertEquals( DELAY, warehouseNextHopsEntity.getHop().getProcessingDelayMins());
    }

    private Hop createHop() {
        return new Hop()
            .code(CODE)
            .description(DESCRIPTION)
            .hopType(HOP_TYPE)
            .locationCoordinates(new GeoCoordinate().lat(LAT).lon(LON))
            .locationName(LOCATION)
            .processingDelayMins(DELAY);
    }
}
