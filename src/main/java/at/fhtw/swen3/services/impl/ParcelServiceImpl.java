package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.services.ParcelService;
import at.fhtw.swen3.services.dto.NewParcelInfo;
import at.fhtw.swen3.services.dto.TrackingInformation;
import org.springframework.stereotype.Service;

@Service
public class ParcelServiceImpl implements ParcelService {
    public void reportParcelDelivery(String trackingId) {

    }

    public void reportParcelHop(String trackingId, String code) {

    }

    public NewParcelInfo submitParcel(ParcelEntity parcel) {
        return new NewParcelInfo();
    }

    public TrackingInformation trackParcel(String trackingId) {
        return new TrackingInformation();
    }

    public NewParcelInfo transitionParcel(ParcelEntity parcel) {
        return new NewParcelInfo();
    }

}
