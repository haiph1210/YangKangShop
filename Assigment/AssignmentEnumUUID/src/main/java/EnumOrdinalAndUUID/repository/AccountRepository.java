package EnumOrdinalAndUUID.repository;

import EnumOrdinalAndUUID.entity.Account;
import EnumOrdinalAndUUID.utils.HibernateUtils;

import org.hibernate.Session;

import java.util.List;

public class AccountRepository {
    public List<Account> findAll(){
    try(Session session = HibernateUtils.openSession()) {
        String hql = "From Account";
        return session.createQuery(hql,Account.class).getResultList();
    }
    }

    public void create(Account account){
        try(Session session = HibernateUtils.openSession()) {
            session.beginTransaction();
            session.persist(account);
            session.getTransaction().commit();
        }
    }


}
