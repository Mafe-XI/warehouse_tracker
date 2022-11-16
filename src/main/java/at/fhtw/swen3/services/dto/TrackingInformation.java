package at.fhtw.swen3.services.dto;

import at.fhtw.swen3.persistence.entities.HopArrivalEntity;
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
public class TrackingInformation {
    private at.fhtw.swen3.persistence.TrackingInformation.StateEnum state;
    private List<HopArrivalEntity> visitedHops = new ArrayList<>();
    private List<HopArrivalEntity> futureHops = new ArrayList<>();
}
