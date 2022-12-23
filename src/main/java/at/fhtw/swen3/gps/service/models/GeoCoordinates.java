package at.fhtw.swen3.gps.service.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GeoCoordinates {
    private String lat;
    private String lon;
}
