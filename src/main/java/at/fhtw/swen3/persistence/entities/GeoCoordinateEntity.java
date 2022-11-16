package at.fhtw.swen3.persistence.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "geo_coordinate")
public class GeoCoordinateEntity {
    @Column(name = "ID")
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "LAT")
    private Double lat;

    @Column(name = "LON")
    private Double lon;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "HOP_ID")
    private HopEntity hop;
}
