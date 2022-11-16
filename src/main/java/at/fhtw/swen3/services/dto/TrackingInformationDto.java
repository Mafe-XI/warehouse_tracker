package at.fhtw.swen3.services.dto;

import at.fhtw.swen3.persistence.TrackingInformation;
import at.fhtw.swen3.persistence.entities.HopArrival;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TrackingInformationDto {
    private TrackingInformation.StateEnum state;
    private List<HopArrival> visitedHops = new ArrayList<>();
    private List<HopArrival> futureHops = new ArrayList<>();
}
