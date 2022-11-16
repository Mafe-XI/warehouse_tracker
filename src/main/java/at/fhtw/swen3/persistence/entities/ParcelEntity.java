package at.fhtw.swen3.persistence.entities;

import at.fhtw.swen3.persistence.Recipient;
import at.fhtw.swen3.persistence.TrackingInformation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "parcel")
public class ParcelEntity {
    //NewParcelInfo
    @Column
    @Id @NotNull
    @Pattern(regexp = "^[A-Z0-9]{9}$", message = "Trackingnumber should be 9 characters long and use only upper letters and digits")
    private String trackingId;
    //Parcel
    @Column
    @DecimalMin(value = "0", message = "Weight has to be at least 0")
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
    private List<HopArrivalEntity> visitedHops = new ArrayList<>();
    @Column
    @OneToMany(cascade = CascadeType.ALL)
    @NotNull
    private List<HopArrivalEntity> futureHops = new ArrayList<>();
}
