package at.fhtw.swen3.persistence.entities;

import at.fhtw.swen3.services.dto.Recipient;
import at.fhtw.swen3.services.dto.TrackingInformation;
import lombok.*;

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
@Builder
@Table(name = "parcel")
public class ParcelEntity implements EntityBase {
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
