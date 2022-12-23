package at.fhtw.swen3.gps.service.impl;

import at.fhtw.swen3.gps.service.GeoEncodingService;
import at.fhtw.swen3.gps.service.models.Address;
import at.fhtw.swen3.gps.service.models.GeoCoordinates;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class OpenStreetMapsEncodingProxy implements GeoEncodingService {

    /*
    public static final String OPENSTREETMAP_URL = "https://nominatim.openstreetmap.org/search";
    public static final String FORMAT = "jsonv2";
    public static final String FORMAT_PARAM = "format";
    public static final String COUNTRY_PARAM = "country";
    public static final String CITY_PARAM = "city";
    public static final String POSTALCODE_PARAM = "postalcode";
    public static final String STREET_PARAM = "street";
*/
    @Override
    public Optional<GeoCoordinates> encodeAddress(Address address) {
        return null;
    }
}
