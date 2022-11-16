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
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
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
    @Id @NotNull
    @Pattern(regexp = "^[A-Z0-9]{9}$", message = "Trackingnumber should be 9 characters long and use only upper letters and digits")
    private String trackingId;
    //Parcel
    @Column
    @Min(value = 0L, message = "Weight has to be at least 0")
    @NotNull
    private Float weight;
    @Embedded
    @Column
    @Valid
    @NotNull
    private Recipient sender;
    @Embedded
    @Column
    @Valid
    @NotNull
    private Recipient recipient;
    //TrackingInformation
    @Column
    @NotNull
    private TrackingInformation.StateEnum state;
    @Column
    @OneToMany(cascade = CascadeType.ALL)
    @NotNull
    private List<HopArrival> visitedHops = new ArrayList<>();
    @Column
    @OneToMany(cascade = CascadeType.ALL)
    @NotNull
    private List<HopArrival> futureHops = new ArrayList<>();

}
