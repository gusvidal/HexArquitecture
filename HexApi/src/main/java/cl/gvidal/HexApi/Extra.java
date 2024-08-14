package cl.gvidal.HexApi;

import cl.gvidal.HexApi.adapter.out.persistence.AccountEntity;
import cl.gvidal.HexApi.adapter.out.persistence.SpringAccountRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class Extra implements InitializingBean {

    @Autowired
    SpringAccountRepository springAccountRepository;

    /*
    private final SpringAccountRepository springAccountRepository;

    public Extra(SpringAccountRepository extra) {
        this.springAccountRepository = extra;
    }*/

    @Override
    public void afterPropertiesSet() throws Exception {
        this.springAccountRepository.save(new AccountEntity(1L, BigDecimal.valueOf(200)));
        this.springAccountRepository.save(new AccountEntity(2L, BigDecimal.valueOf(300)));
    }
}
