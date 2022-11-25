package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.TransferwarehouseEntity;
import at.fhtw.swen3.services.dto.Transferwarehouse;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TransferwarehouseMapperTest {
    private String REGION_GEO_JSON = "Region";
    private String LOGISTIC_PARTNER = "Logistik-Partner";
    private String LOGISTIC_PARTNER_URL = "Logistik-Partner-URL";

    @Test
    void entityToDTO() {
        TransferwarehouseEntity transferwarehouseEntity = new TransferwarehouseEntity();
        transferwarehouseEntity.setRegionGeoJson(REGION_GEO_JSON);
        transferwarehouseEntity.setLogisticsPartner(LOGISTIC_PARTNER);
        transferwarehouseEntity.setLogisticsPartnerUrl(LOGISTIC_PARTNER_URL);

        Transferwarehouse transferwarehouse = TransferwarehouseMapper.INSTANCE.entityToDTO(transferwarehouseEntity);

        assertEquals( REGION_GEO_JSON, transferwarehouse.getRegionGeoJson());
        assertEquals( LOGISTIC_PARTNER, transferwarehouse.getLogisticsPartner());
        assertEquals( LOGISTIC_PARTNER_URL, transferwarehouse.getLogisticsPartnerUrl());
    }

    @Test
    void dtoToEntity() {
        Transferwarehouse transferwarehouse = new Transferwarehouse();
        transferwarehouse.setRegionGeoJson(REGION_GEO_JSON);
        transferwarehouse.setLogisticsPartner(LOGISTIC_PARTNER);
        transferwarehouse.setLogisticsPartnerUrl(LOGISTIC_PARTNER_URL);

        TransferwarehouseEntity transferwarehouseEntity = TransferwarehouseMapper.INSTANCE.dtoToEntity(transferwarehouse);

        assertEquals( REGION_GEO_JSON, transferwarehouseEntity.getRegionGeoJson());
        assertEquals( LOGISTIC_PARTNER, transferwarehouseEntity.getLogisticsPartner());
        assertEquals( LOGISTIC_PARTNER_URL, transferwarehouseEntity.getLogisticsPartnerUrl());
    }
}
