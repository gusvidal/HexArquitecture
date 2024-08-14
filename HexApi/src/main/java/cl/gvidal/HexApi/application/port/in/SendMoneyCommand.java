package cl.gvidal.HexApi.application.port.in;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SendMoneyCommand {
    //Quien transfiere $$
    private Long sourceId;

    //Quien recibe $$
    private Long targetId;

    //Cuanta $$
    private BigDecimal amount;
}
