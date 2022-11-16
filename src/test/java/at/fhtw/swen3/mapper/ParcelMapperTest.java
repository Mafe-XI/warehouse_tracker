package at.fhtw.swen3.mapper;

import at.fhtw.swen3.persistence.Recipient;
import at.fhtw.swen3.persistence.entities.HopArrivalEntity;
import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.services.dto.NewParcelInfo;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.dto.TrackingInformation;
import at.fhtw.swen3.services.mapper.ParcelMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ParcelMapperTest {
    Recipient sender = new Recipient("Shop", "Shopping Street", "A-1200", "Vienna", "Austria");
    Recipient recipient = new Recipient("Fritz", "Schulgasse 1", "A-4020", "Linz", "Austria");

    List<HopArrivalEntity> visitedHops = new ArrayList<HopArrivalEntity>() {
        {
            add(new HopArrivalEntity("123", "visited1", OffsetDateTime.now()));
            add(new HopArrivalEntity("456", "visited2", OffsetDateTime.now()));
            add(new HopArrivalEntity("789", "visited3", OffsetDateTime.now()));
        }
    };

    List<HopArrivalEntity> futureHops = new ArrayList<HopArrivalEntity>() {
        {
            add(new HopArrivalEntity("123", "future1", OffsetDateTime.now()));
            add(new HopArrivalEntity("456", "future2", OffsetDateTime.now()));
            add(new HopArrivalEntity("789", "future3", OffsetDateTime.now()));
        }
    };

    @Test
    void parcelEntityToNewParcelInfoDto() {
        ParcelEntity parcel = new ParcelEntity("123456", 12.0f, sender, recipient, at.fhtw.swen3.persistence.TrackingInformation.StateEnum.INTRANSPORT, visitedHops, futureHops);

        NewParcelInfo newParcelInfoDto = ParcelMapper.INSTANCE.parcelEntityToNewParcelInfoDto(parcel);

        assertEquals( "123456", newParcelInfoDto.getTrackingId());
    }

    @Test
    void parcelEntityToParcelDto() {
        ParcelEntity parcel = new ParcelEntity("123456", 12.0f, sender, recipient, at.fhtw.swen3.persistence.TrackingInformation.StateEnum.INTRANSPORT, visitedHops, futureHops);

        Parcel parcelDto = ParcelMapper.INSTANCE.parcelEntityToParcelDto(parcel);

        assertEquals( 12.0f, parcelDto.getWeight());
        assertEquals( "Shop", parcelDto.getSender().getName());
        assertEquals( "Fritz", parcelDto.getRecipient().getName());
    }

    @Test
    void parcelEntityToTrackingDto() {
        ParcelEntity parcel = new ParcelEntity("123456", 12.0f, sender, recipient, at.fhtw.swen3.persistence.TrackingInformation.StateEnum.INTRANSPORT, visitedHops, futureHops);

        TrackingInformation trackingInformationDto = ParcelMapper.INSTANCE.parcelEntityToTrackingDto(parcel);

        assertEquals( "InTransport", trackingInformationDto.getState().getValue());
        assertEquals( "123", trackingInformationDto.getVisitedHops().get(0).getCode());
        assertEquals( "future1", trackingInformationDto.getFutureHops().get(0).getDescription());
    }

    @Test
    void dtoToParcelEntity() {
        NewParcelInfo newParcelInfoDto = new NewParcelInfo("123456");
        Parcel parcelDto = new Parcel(12.0f, sender, recipient);
        TrackingInformation trackingInformationDto = new TrackingInformation(at.fhtw.swen3.persistence.TrackingInformation.StateEnum.INTRANSPORT, visitedHops, futureHops);

        ParcelEntity parcel = ParcelMapper.INSTANCE.dtoToParcelEntity(newParcelInfoDto, parcelDto, trackingInformationDto);

        assertEquals("123456", parcel.getTrackingId());
        assertEquals(12.0f, parcel.getWeight());
        assertEquals("A-1200", parcel.getSender().getPostalCode());
        assertEquals("A-4020", parcel.getRecipient().getPostalCode());
        assertEquals( "InTransport", parcel.getState().getValue());
        assertEquals( "visited1", parcel.getVisitedHops().get(0).getDescription());
        assertEquals( "789", parcel.getFutureHops().get(2).getCode());
    }

}
