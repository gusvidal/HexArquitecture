package cl.gvidal.HexApi.application.port.in;

public interface SendMoneyPort {
    public boolean send(SendMoneyCommand command);
}