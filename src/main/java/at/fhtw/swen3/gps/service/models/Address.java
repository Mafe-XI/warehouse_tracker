package at.fhtw.swen3.gps.service.models;

import lombok.Data;

@Data
public class Address {
    private String postalcode;
    private String city;
    private String street;
    private String country;
}
