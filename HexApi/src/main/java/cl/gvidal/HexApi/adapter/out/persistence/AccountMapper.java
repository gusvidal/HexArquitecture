package cl.gvidal.HexApi.adapter.out.persistence;

import cl.gvidal.HexApi.domain.Account;

public class AccountMapper {

    public static Account entityToDomain(AccountEntity accountEntity){
        Account account = new Account();
        account.setId(accountEntity.getId());
        account.setAmount(accountEntity.getAmount());

        return account;
    }

    public static AccountEntity domainToEntity(Account account){
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setId(account.getId());
        accountEntity.setAmount(account.getAmount());

        return accountEntity;
    }
}
