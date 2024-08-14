package cl.gvidal.HexApi.adapter.out.persistence;

import cl.gvidal.HexApi.application.port.out.LoadAccountPort;
import cl.gvidal.HexApi.application.port.out.UpdateAccountPort;
import cl.gvidal.HexApi.common.PersistenceAdapter;
import cl.gvidal.HexApi.domain.Account;
import org.springframework.stereotype.Repository;

@PersistenceAdapter
public class AccountPersistenceAdapter implements LoadAccountPort, UpdateAccountPort {

    private final SpringAccountRepository accountRepository;

    public AccountPersistenceAdapter(SpringAccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    @Override
    public Account load(Long id) {
        return accountRepository
                .findById(id)
                .map(AccountMapper::entityToDomain)
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public void update(Account account) {
        accountRepository.save(AccountMapper.domainToEntity(account));
    }
}
