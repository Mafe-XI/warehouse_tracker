package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.persistence.entities.RecipientEntity;
import at.fhtw.swen3.services.dto.Recipient;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class RecipientMapperTest {
    private final Long ID =  1L;
    private final String NAME =  "Max Mustermann";
    private final String STREET =  "Handelskai";
    private final String POSTALCODE =  "1200";
    private final String CITY =  "Vienna";
    private final String COUNTRY =  "Austria";
    private final ParcelEntity PARCEL = new ParcelEntity();

    @Test
    void entityToDTO() {
        RecipientEntity recipientEntity = new RecipientEntity(ID, NAME, STREET, POSTALCODE, CITY, COUNTRY, PARCEL);

        Recipient recipient = RecipientMapper.INSTANCE.entityToDTO(recipientEntity);

        //id?
        assertEquals( NAME, recipient.getName());
        assertEquals( STREET, recipient.getStreet());
        assertEquals( POSTALCODE, recipient.getPostalCode());
        assertEquals( CITY, recipient.getCity());
        assertEquals( COUNTRY, recipient.getCountry());
        //parcel?
    }

    @Test
    void dtoToEntity() {
        Recipient recipient = new Recipient(NAME, STREET, POSTALCODE, CITY, COUNTRY);

        RecipientEntity recipientEntity = RecipientMapper.INSTANCE.dtoToEntity(recipient);

        assertEquals( NAME, recipientEntity.getName());
        assertEquals( STREET, recipientEntity.getStreet());
        assertEquals( POSTALCODE, recipientEntity.getPostalCode());
        assertEquals( CITY, recipientEntity.getCity());
        assertEquals( COUNTRY, recipientEntity.getCountry());
    }
}
