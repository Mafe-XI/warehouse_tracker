package at.fhtw.swen3.persistence.entities;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "geo_coordinate")
public class GeoCoordinateEntity implements EntityBase {
    @Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "LAT")
    private Double lat;

    @Column(name = "LON")
    private Double lon;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "HOP_ID")
    private HopEntity hop;
}
