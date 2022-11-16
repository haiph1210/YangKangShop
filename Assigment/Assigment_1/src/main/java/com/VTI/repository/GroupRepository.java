package com.VTI.repository;

import com.VTI.entity.Group;
import com.VTI.utils.HibernateUtils;
import org.hibernate.Session;

import java.util.List;

public class GroupRepository {
    public boolean existsByID(int id) {
        try (Session session = HibernateUtils.openSession()) {
            return session.get(Group.class, id) != null;
        }
    }

    public boolean existsByName(String name) {
        try (Session session = HibernateUtils.openSession()) {
            String hql = "FROM Group WHERE name = :searchname";
            return session.createQuery(hql, Group.class)
                    .setParameter("searchname", name)
                    .uniqueResult() != null;
        }
    }

    public List<Group> findAll() {
        try (Session session = HibernateUtils.openSession()) {
            String hql = "From Group";
            return session.createQuery(hql, Group.class).getResultList();
        }
    }

    public Group findByID(int id) {
        try (Session session = HibernateUtils.openSession()) {
            return session.get(Group.class, id);
        }
    }

    public Group findByName(String name) {
        try (Session session = HibernateUtils.openSession()) {
            String hql = "From Group Where name = :searchname";
            return session.createQuery(hql, Group.class)
                    .setParameter("searchname", name)
                    .uniqueResult();
        }
    }

    public void create(Group group) {
        if (existsByName(group.getName())) {
            return;
        }
        try (Session session = HibernateUtils.openSession()) {
            session.beginTransaction();
            session.persist(group);
            session.getTransaction().commit();
        }
    }

    public void update(Group group) {
        if (!existsByID(group.getId()) || existsByName(group.getName())) {
            return;
        }
        try (Session session = HibernateUtils.openSession()) {
            session.beginTransaction();
            session.merge(group);
            session.getTransaction().commit();
        }
    }

    public void deleteByID(int id) {
        Group old = findByID(id);
        if (old == null) {
            return;
        }
        try (Session session = HibernateUtils.openSession()) {
            session.beginTransaction();
            session.remove(old);
            session.getTransaction().commit();
        }
    }
}


















