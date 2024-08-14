package cl.gvidal.HexApi.adapter.in.web;

import cl.gvidal.HexApi.application.port.in.SendMoneyCommand;
import cl.gvidal.HexApi.application.port.in.SendMoneyPort;
import cl.gvidal.HexApi.common.WebAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@WebAdapter
@RestController
public class MoneyTransferController {

    @Autowired
    private SendMoneyPort sendMoneyPort;

    @PostMapping(path = "/accounts/transfer/{sourceAccountId}/{targetAccountId}/{amount}")
    void transfer(
            @PathVariable("sourceAccountId") Long sourceAccountId,
            @PathVariable("targetAccountId") Long targetAccountId,
            @PathVariable("amount") BigDecimal amount) {

        SendMoneyCommand command = new SendMoneyCommand(
                sourceAccountId,
                targetAccountId,
                amount);

        sendMoneyPort.send(command);
    }
}
