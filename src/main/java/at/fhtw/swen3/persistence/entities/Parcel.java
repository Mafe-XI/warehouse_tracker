package at.fhtw.swen3.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Parcel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    private Long id;
    @Column
    private LocalDateTime dateTime;
    @Column
    private String senderAddress;
    @Column
    private String receiverAddress;
    @Column
    private String orderNumber;
    @Column
    private int trackingNumber;
}
