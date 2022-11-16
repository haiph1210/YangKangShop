package EnumConversterAndIDConverter.repository;

import EnumConversterAndIDConverter.entity.Account;
import EnumConversterAndIDConverter.utils.HibernateUtils;
import org.hibernate.Query;
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

    public long getCountByAddress(Account.Address address){
        try( Session session = HibernateUtils.openSession()) {
            String hql = "SELECT COUNT(address) FROM Account WHERE address : typeaddress";
            return  session.createQuery(hql, Long.class).setParameter("typeaddress",address).uniqueResult();

        }
    }

}
