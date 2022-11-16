package at.fhtw.swen3.persistence.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "recipient")
public class RecipientEntity {
    @Column(name = "ID")
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "NAME")
    @Pattern(regexp = ".*")
    private String name;

    @Column(name = "STREET")
    @Pattern(regexp = "^[a-zA-Z]\\s\\d+[/a-zA-Z\\d]$", message = "Only use characters a-z, numbers, whitespaces and '/' characters")
    private String street;

    @Column(name = "POSTAL_CODE")
    @Pattern(regexp = "^A-\\d{4}$", message = "Postalcode has to start with 'A-' followed by 4 digits")
    private String postalCode;

    @Column(name = "CITY")
    @Pattern(regexp = "^\\p{Lu}[a-zA-Z-*\\s*\\/*]*$", message = "City name has to start with an upper letter and only use a-z and '-' or '/' characters")
    private String city;

    @Column(name = "COUNTRY")
    private String country;

    @OneToOne(fetch = FetchType.LAZY)
    private ParcelEntity parcel;
}
