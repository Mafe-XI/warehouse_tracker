package at.fhtw.swen3.mapper;

import at.fhtw.swen3.persistence.entities.Parcel;
import at.fhtw.swen3.services.dto.NewParcelInfoDto;
import at.fhtw.swen3.services.dto.ParcelDto;
import at.fhtw.swen3.services.dto.TrackingInformationDto;
import at.fhtw.swen3.services.mapper.WholeParcelMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class WholeParcelMapperTest {

    private final Parcel parcel = new Parcel(1L, LocalDateTime.now(), "Schulweg 1", "Schulweg 2", "123A", 1234);

    @Test
    void parcelEntityToTrackingDto() {
        TrackingInformationDto trackingInformationDto = WholeParcelMapper.INSTANCE.parcelEntityToTrackingDto(parcel);

        assertEquals( 1234, trackingInformationDto.getTrackingNumber());
    }

    @Test
    void parcelEntityToParcelDto() {
        ParcelDto parcelDto = WholeParcelMapper.INSTANCE.parcelEntityToParcelDto(parcel);

        assertEquals( "123A", parcelDto.getOrderNumber());
    }

    @Test
    void parcelEntityToNewParcelInfoDto() {
        NewParcelInfoDto newParcelInfoDto = WholeParcelMapper.INSTANCE.parcelEntityToNewParcelInfoDto(parcel);

        assertEquals( 1L, newParcelInfoDto.getId());
        assertEquals( "Schulweg 1", newParcelInfoDto.getSenderAddress());
        assertEquals( "Schulweg 2", newParcelInfoDto.getReceiverAddress());
    }

    @Test
    void dtoToParcelEntity() {
        NewParcelInfoDto newParcelInfoDto = new NewParcelInfoDto(1L, "Schulweg 1", "Schulweg 2");
        ParcelDto parcelDto = new ParcelDto("123A");
        TrackingInformationDto trackingInformationDto = new TrackingInformationDto(1234);

        Parcel parcel = WholeParcelMapper.INSTANCE.dtoToParcelEntity(newParcelInfoDto, parcelDto, trackingInformationDto);

        assertEquals(1L, parcel.getId());
        assertEquals("Schulweg 1", parcel.getSenderAddress());
        assertEquals("Schulweg 2", parcel.getReceiverAddress());
        assertEquals("123A", parcel.getOrderNumber());
        assertEquals( 1234, parcel.getTrackingNumber());
    }
}
