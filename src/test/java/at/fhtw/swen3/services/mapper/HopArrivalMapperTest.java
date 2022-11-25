package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.HopArrivalEntity;
import at.fhtw.swen3.services.dto.HopArrival;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class HopArrivalMapperTest {
    private final String CODE =  "code123";
    private final String DESCRIPTION =  "description";
    private final OffsetDateTime DATETIME =  OffsetDateTime.now();

    @Test
    void entityToDTO() {
        HopArrivalEntity hopArrivalEntity = new HopArrivalEntity(CODE, DESCRIPTION, DATETIME);

        HopArrival hopArrival = HopArrivalMapper.INSTANCE.entityToDTO(hopArrivalEntity);

        assertEquals( CODE, hopArrival.getCode());
        assertEquals( DESCRIPTION, hopArrival.getDescription());
        assertEquals( DATETIME, hopArrival.getDateTime());
    }

    @Test
    void dtoToEntity() {
        HopArrival hopArrival = new HopArrival(CODE, DESCRIPTION, DATETIME);

        HopArrivalEntity hopArrivalEntity = HopArrivalMapper.INSTANCE.dtoToEntity(hopArrival);

        assertEquals( CODE, hopArrivalEntity.getCode());
        assertEquals( DESCRIPTION, hopArrivalEntity.getDescription());
        assertEquals( DATETIME, hopArrivalEntity.getDateTime());
    }
}
