package at.fhtw.swen3.persistence.entities;

import at.fhtw.swen3.persistence.entities.HopArrival;
import at.fhtw.swen3.persistence.Recipient;
import at.fhtw.swen3.persistence.TrackingInformation;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class Parcel {
    //NewParcelInfo
    @Column
    @Id
    private String trackingId;
    //Parcel
    @Column
    private Float weight;
    @Embedded
    @Column
    private Recipient sender;
    @Embedded
    @Column
    private Recipient recipient;
    //TrackingInformation
    @Column
    private TrackingInformation.StateEnum state;
    @Column
    @OneToMany(cascade = CascadeType.ALL)
    private List<HopArrival> visitedHops = new ArrayList<>();
    @Column
    @OneToMany(cascade = CascadeType.ALL)
    private List<HopArrival> futureHops = new ArrayList<>();

}
