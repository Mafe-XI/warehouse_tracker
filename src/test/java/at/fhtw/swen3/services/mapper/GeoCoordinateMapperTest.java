package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.GeoCoordinateEntity;
import at.fhtw.swen3.persistence.entities.HopEntity;
import at.fhtw.swen3.services.dto.GeoCoordinate;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class GeoCoordinateMapperTest {
    //GeoCoordinateEntity
    private final Long GEO_ID = 1L;
    private final Double LAT = 10.0;
    private final Double LON = 20.0;
    //HopEntity
    private final Long HOP_ID = 1L;
    private final String HOP_TYPE = "hopType";
    private final String CODE = "code";
    private final String DESCRIPTION = "description";
    private final int DELAY = 10;
    private final String LOCATION = "location";

    @Test
    void entityToDTO() {
        GeoCoordinateEntity geoCoordinateEntity = new GeoCoordinateEntity(GEO_ID, LAT, LON, null);
        HopEntity hopEntity = new HopEntity(HOP_ID, HOP_TYPE, CODE, DESCRIPTION, DELAY, LOCATION, geoCoordinateEntity);
        hopEntity.getLocationCoordinates().setHop(hopEntity);
        geoCoordinateEntity.setHop(hopEntity);

        GeoCoordinate geoCoordinate = GeoCoordinateMapper.INSTANCE.entityToDTO(geoCoordinateEntity);

        //id?
        assertEquals( LAT, geoCoordinate.getLat());
        assertEquals( LON, geoCoordinate.getLon());
        //hop?
    }

    @Test
    void dtoToEntity() {
        GeoCoordinate geoCoordinate = new GeoCoordinate();
        geoCoordinate.setLat(LAT);
        geoCoordinate.setLon(LON);

        GeoCoordinateEntity geoCoordinateEntity = GeoCoordinateMapper.INSTANCE.dtoToEntity(geoCoordinate);

        assertEquals( LAT, geoCoordinateEntity.getLat());
        assertEquals( LON, geoCoordinateEntity.getLon());
        //Mapping Probleme?
    }
}
