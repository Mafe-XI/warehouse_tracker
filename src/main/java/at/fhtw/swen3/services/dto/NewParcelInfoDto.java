package at.fhtw.swen3.services.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NewParcelInfoDto {
    private Long id;
    private String senderAddress;
    private String receiverAddress;
}
