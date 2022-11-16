package EnumConversterAndIDConverter.entity;

import EnumConversterAndIDConverter.repository.AccountRepository;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;

public class AccountIDGenerator implements IdentifierGenerator {
    private AccountRepository repository ;

    public AccountIDGenerator() {
        repository = new AccountRepository();
    }

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        Account account = (Account) object;
        Account.Address address = account.getAddress();
        long count = repository.getCountByAddress(account.getAddress());
         return String.format("%c-%d",address.getId(),count+1);
    }
}
