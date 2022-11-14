package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.Parcel;
import at.fhtw.swen3.services.dto.NewParcelInfoDto;
import at.fhtw.swen3.services.dto.ParcelDto;
import at.fhtw.swen3.services.dto.TrackingInformationDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface WholeParcelMapper {
    WholeParcelMapper INSTANCE = Mappers.getMapper(WholeParcelMapper.class);

    TrackingInformationDto parcelEntityToTrackingDto(Parcel parcel);
    ParcelDto parcelEntityToParcelDto(Parcel parcel);
    NewParcelInfoDto parcelEntityToNewParcelInfoDto(Parcel parcel);
    Parcel dtoToParcelEntity(NewParcelInfoDto newParcelInfoDto, ParcelDto parcelDto, TrackingInformationDto trackingInformationDto);
}