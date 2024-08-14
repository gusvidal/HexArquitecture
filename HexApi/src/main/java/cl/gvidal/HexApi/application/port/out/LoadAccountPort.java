package cl.gvidal.HexApi.application.port.out;

import cl.gvidal.HexApi.domain.Account;

public interface LoadAccountPort {
    Account load(Long id);
}
