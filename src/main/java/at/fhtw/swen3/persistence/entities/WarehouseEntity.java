package at.fhtw.swen3.persistence.entities;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@Entity
public class WarehouseEntity extends HopEntity {
    @Column(name = "LEVEL")
    private Integer level;

    @Singular
    @NotNull
    @Valid
    @OneToMany(mappedBy = "warehouse", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<WarehouseNextHopsEntity> nextHops = new ArrayList<>();

    /*
    @Builder
    public WarehouseEntity(Long id, String hopType, String code, String description, Integer processingDelayMins, String locationName, @NotNull GeoCoordinateEntity locationCoordinates, Integer level, List<WarehouseNextHopsEntity> nextHops) {
        super(id, hopType, code, description, processingDelayMins, locationName, locationCoordinates);
        this.level = level;
        this.nextHops = nextHops;
    }
    */
}
