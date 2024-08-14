package cl.gvidal.HexApi.application.service;

import cl.gvidal.HexApi.application.port.in.SendMoneyCommand;
import cl.gvidal.HexApi.application.port.in.SendMoneyPort;
import cl.gvidal.HexApi.application.port.out.LoadAccountPort;
import cl.gvidal.HexApi.application.port.out.UpdateAccountPort;
import cl.gvidal.HexApi.common.UseCase;
import cl.gvidal.HexApi.domain.Account;
import jakarta.transaction.Transactional;

@UseCase
public class SendMoneyService implements SendMoneyPort {

    private final LoadAccountPort loadAccountPort;
    private final UpdateAccountPort updateAccountPort;

    public SendMoneyService(LoadAccountPort loadAccountPort, UpdateAccountPort updateAccountPort){
        this.loadAccountPort = loadAccountPort;
        this.updateAccountPort = updateAccountPort;
    }

    @Transactional
    @Override
    public boolean send(SendMoneyCommand command) {

        // Cargamos los datos de ambos clientes
        Account source = loadAccountPort.load(command.getSourceId());
        Account target = loadAccountPort.load(command.getTargetId());

        if(!source.cuentaConDinero(command.getAmount())) {
            throw new RuntimeException("La cuenta del depositante, no cuenta con dinero suficiente ... ");
        }
        // sumamos el deposito a quien recibe la transferencia
        target.suma(command.getAmount());

        // restamos el deposito a quien realiza la transferencia
        source.resta(command.getAmount());

        // actulaizamos los saldos en la base de datos
        updateAccountPort.update(source);
        updateAccountPort.update(target);

        return true;
    }
}
