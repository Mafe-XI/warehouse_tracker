package at.fhtw.swen3.mapper;

import at.fhtw.swen3.persistence.Recipient;
import at.fhtw.swen3.persistence.TrackingInformation;
import at.fhtw.swen3.persistence.entities.HopArrival;
import at.fhtw.swen3.persistence.entities.Parcel;
import at.fhtw.swen3.services.dto.NewParcelInfoDto;
import at.fhtw.swen3.services.dto.ParcelDto;
import at.fhtw.swen3.services.dto.TrackingInformationDto;
import at.fhtw.swen3.services.mapper.WholeParcelMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class WholeParcelMapperTest {
    Recipient sender = new Recipient("Shop", "Shopping Street", "A-1200", "Vienna", "Austria");
    Recipient recipient = new Recipient("Fritz", "Schulgasse 1", "A-4020", "Linz", "Austria");

    List<HopArrival> visitedHops = new ArrayList<HopArrival>() {
        {
            add(new HopArrival("123", "visited1", OffsetDateTime.now()));
            add(new HopArrival("456", "visited2", OffsetDateTime.now()));
            add(new HopArrival("789", "visited3", OffsetDateTime.now()));
        }
    };

    List<HopArrival> futureHops = new ArrayList<HopArrival>() {
        {
            add(new HopArrival("123", "future1", OffsetDateTime.now()));
            add(new HopArrival("456", "future2", OffsetDateTime.now()));
            add(new HopArrival("789", "future3", OffsetDateTime.now()));
        }
    };

    @Test
    void parcelEntityToNewParcelInfoDto() {
        Parcel parcel = new Parcel("123456", 12.0f, sender, recipient, TrackingInformation.StateEnum.INTRANSPORT, visitedHops, futureHops);

        NewParcelInfoDto newParcelInfoDto = WholeParcelMapper.INSTANCE.parcelEntityToNewParcelInfoDto(parcel);

        assertEquals( "123456", newParcelInfoDto.getTrackingId());
    }

    @Test
    void parcelEntityToParcelDto() {
        Parcel parcel = new Parcel("123456", 12.0f, sender, recipient, TrackingInformation.StateEnum.INTRANSPORT, visitedHops, futureHops);

        ParcelDto parcelDto = WholeParcelMapper.INSTANCE.parcelEntityToParcelDto(parcel);

        assertEquals( 12.0f, parcelDto.getWeight());
        assertEquals( "Shop", parcelDto.getSender().getName());
        assertEquals( "Fritz", parcelDto.getRecipient().getName());
    }

    @Test
    void parcelEntityToTrackingDto() {
        Parcel parcel = new Parcel("123456", 12.0f, sender, recipient, TrackingInformation.StateEnum.INTRANSPORT, visitedHops, futureHops);

        TrackingInformationDto trackingInformationDto = WholeParcelMapper.INSTANCE.parcelEntityToTrackingDto(parcel);

        assertEquals( "InTransport", trackingInformationDto.getState().getValue());
        assertEquals( "123", trackingInformationDto.getVisitedHops().get(0).getCode());
        assertEquals( "future1", trackingInformationDto.getFutureHops().get(0).getDescription());
    }

    @Test
    void dtoToParcelEntity() {
        NewParcelInfoDto newParcelInfoDto = new NewParcelInfoDto("123456");
        ParcelDto parcelDto = new ParcelDto(12.0f, sender, recipient);
        TrackingInformationDto trackingInformationDto = new TrackingInformationDto(TrackingInformation.StateEnum.INTRANSPORT, visitedHops, futureHops);

        Parcel parcel = WholeParcelMapper.INSTANCE.dtoToParcelEntity(newParcelInfoDto, parcelDto, trackingInformationDto);

        assertEquals("123456", parcel.getTrackingId());
        assertEquals(12.0f, parcel.getWeight());
        assertEquals("A-1200", parcel.getSender().getPostalCode());
        assertEquals("A-4020", parcel.getRecipient().getPostalCode());
        assertEquals( "InTransport", parcel.getState().getValue());
        assertEquals( "visited1", parcel.getVisitedHops().get(0).getDescription());
        assertEquals( "789", parcel.getFutureHops().get(2).getCode());
    }

}
