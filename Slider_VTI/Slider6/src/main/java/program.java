import entity.Account;
import entity.Department;
import repository.AccountRepository;
import repository.DepartmentRepository;
import utils.HibernateUtils;

import java.util.List;

public class program {
    public static void main(String[] args) {
        DepartmentRepository departmentRepository = new DepartmentRepository();
        AccountRepository accountRepository = new AccountRepository();


        System.out.println("=======================Create =============================");
        departmentRepository.create(new Department("Java Basic"));
        departmentRepository.create(new Department("Java Advance"));
        departmentRepository.create(new Department("Java Fontend"));

        accountRepository.create(new Account("Hair",new Department(1)));
        accountRepository.create(new Account("Nhungg",new Department(2)));
        accountRepository.create(new Account("Hiếu",new Department(3)));
        accountRepository.create(new Account("Hằng",new Department(1)));
        accountRepository.create(new Account("Cúc",new Department(2)));
        accountRepository.create(new Account("SOn",new Department(3)));
        accountRepository.create(new Account("Harry",new Department(2)));
        accountRepository.create(new Account("Thương",new Department(1)));

        System.out.println("=======================Show===============================");
        List<Department> departments = departmentRepository.findAll();
        for (Department department : departments) {
            System.out.println("department = " + department);

//            for (Account account : department.getAccounts()) {
//                System.out.println("account = " + account);
//            }
        }

        for (Account account : accountRepository.findAll()) {
            System.out.println("account = " + account);
        }
        HibernateUtils.closeFactory();
    }
 }
