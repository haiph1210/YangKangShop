package com.vti.repository;

import com.vti.entity.Person;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class PersonRepository implements IPersonRepository {

    @Override
    public List<Person> findAll(){
        try(Session session = HibernateUtils.openSession()) {
            List<Person> people = session.createQuery("FROM Person",Person.class).getResultList();
            return people;
        }
    }
    @Override
    public Person findByID(int id){
        try(Session session = HibernateUtils.openSession()) {
        return session.get(Person.class,id);
        }
    }

    @Override
    public Person findByEmail(String email){
        try(Session session = HibernateUtils.openSession()) {
        String hql = "FROM Person WHERE email = :email";
        return session.createQuery(hql,Person.class)
                .setParameter("email",email)
                .uniqueResult();
        }
    }

    @Override
    public void create(Person person){
        try(Session session = HibernateUtils.openSession()) {
            session.beginTransaction();
            session.persist(person);
            session.getTransaction().commit();
        }
    }
    @Override
    public void update(Person person){
        try(Session session = HibernateUtils.openSession()) {
            session.beginTransaction();
            session.merge(person);
            session.getTransaction().commit();
        }
    }
    @Override
    public void deleteByID(int id){
        try(Session session = HibernateUtils.openSession()) {
            Person person = session.get(Person.class,id);
            session.beginTransaction();
            session.delete(person);
            session.getTransaction().commit();
        }
    }

}
