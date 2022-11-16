package at.fhtw.swen3.services.dto;

import at.fhtw.swen3.persistence.Recipient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Parcel {
    private Float weight;
    private Recipient sender;
    private Recipient recipient;
}
