package com.vti.repository;

import com.vti.entity.Account;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountRepository implements IAccountRepository {
    @Override
    public List<Account> findAll() {
        try (Session session = HibernateUtils.openSession()) {
            String hql = "FROM Account";
            return session.createQuery(hql, Account.class).getResultList();
        }

    }

    @Override
    public Account findByID(int id) {
        try (Session session = HibernateUtils.openSession()) {
            return session.get(Account.class, id);
        }
    }

    @Override
    public Account findByName(String name) {
        try (Session session = HibernateUtils.openSession()) {
            String hql = "FROM Account WHERE name = :name";
            return session.createQuery(hql, Account.class).setParameter("name", name).uniqueResult();
        }
    }

    @Override
    public void createAccount(Account account) {
        try (Session session = HibernateUtils.openSession()) {
            session.beginTransaction();
            session.persist(account);
            session.getTransaction().commit();
        }
    }

    @Override
    public void updateAccount(Account account) {
        try (Session session = HibernateUtils.openSession()) {
            session.beginTransaction();
            session.merge(account);
            session.getTransaction().commit();
        }
    }

    @Override
    public void deleteByID(int id) {
        try (Session session = HibernateUtils.openSession()) {
            session.beginTransaction();
            Account account = session.get(Account.class, id);
            session.remove(account);
            session.getTransaction().commit();
        }
    }

    @Override
    public void deletebyName(String name) {
        try (Session session = HibernateUtils.openSession()) {

        }
    }
}
