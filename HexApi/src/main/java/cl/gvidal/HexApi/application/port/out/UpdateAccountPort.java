package cl.gvidal.HexApi.application.port.out;

import cl.gvidal.HexApi.domain.Account;

public interface UpdateAccountPort {
    void update(Account account);
}
