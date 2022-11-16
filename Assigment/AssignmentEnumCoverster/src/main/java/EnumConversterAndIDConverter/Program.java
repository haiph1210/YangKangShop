package EnumConversterAndIDConverter;



import EnumConversterAndIDConverter.entity.Account;
import EnumConversterAndIDConverter.repository.AccountRepository;

import java.util.List;

public class Program {
    public static void main(String[] args) {
        AccountRepository repository = new AccountRepository();
        System.out.println("-------------create----------------------");
        repository.create(new Account("Hải", Account.Address.HANOI));
        repository.create(new Account("Khoa", Account.Address.HOCHIMINH));
        repository.create(new Account("Bam", Account.Address.NINHBINH));
        repository.create(new Account("nam", Account.Address.NAMDINH));

//        System.out.println("-------------show-------------------------");
//        List<Account> accounts = repository.findAll();
//        for (Account account : accounts) {
//            System.out.println("account = " + account);
//        }
    }
}
