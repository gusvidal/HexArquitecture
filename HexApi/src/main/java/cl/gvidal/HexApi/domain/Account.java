package cl.gvidal.HexApi.domain;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Account {
    private Long id;
    private BigDecimal amount;

    public Boolean cuentaConDinero(BigDecimal anotherAmount){
        return this.amount.compareTo(anotherAmount) >= 0;
    }

    public void suma(BigDecimal amount){
        this.amount = this.amount.add(amount);
    }

    public void resta(BigDecimal amount){
        this.amount = this.amount.subtract(amount);
    }
}
