package at.fhtw.swen3.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.OffsetDateTime;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class HopArrival {
    @Id @NotNull
    @Pattern(regexp = "^[A-Z]{4}\\d{1,4}$", message = "Code should be 8 characters long. First 4 characters should be A-Z and last 4 should be numbers")
    private String code;
    @Column
    @Pattern(regexp = "^[a-zA-Z-/\\s\\d]*$", message = "City name has to start with an upper letter and only use a-z and '-' or '/' characters")
    private String description;
    @Column
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime dateTime;
}
