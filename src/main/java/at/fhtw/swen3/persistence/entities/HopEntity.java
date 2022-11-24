package at.fhtw.swen3.persistence.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "hop")
public class HopEntity {
    @Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "HOP_TYPE")
    private String hopType;

    @Column(name = "CODE")
    @Pattern(regexp = "^[A-Z]{4}\\d{1,4}$", message = "Code should be 8 characters long. First 4 characters should be A-Z and last 4 should be numbers")
    private String code;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "PROCESSING_DELAY_MINS")
    private Integer processingDelayMins;

    @Column(name = "LOCATION_NAME")
    private String locationName;

    @OneToOne(mappedBy = "hop", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @NotNull
    private GeoCoordinateEntity locationCoordinates;
}
