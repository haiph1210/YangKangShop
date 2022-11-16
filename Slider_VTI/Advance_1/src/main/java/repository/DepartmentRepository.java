package repository;

import entity.Department;
import org.hibernate.Session;
import utils.HibernateUtils;

import java.util.List;

public class DepartmentRepository {
    public List<Department> findAll() {
        try (Session session = HibernateUtils.openSession()) {
            String hql = "FROM Department";
            return session.createQuery(hql, Department.class).getResultList();
        }
    }

    public Department findByID(int id) {
        try (Session session = HibernateUtils.openSession()) {
            return session.get(Department.class, id);
        }
    }

    public Department findByName(String name) {

        try (Session session = HibernateUtils.openSession()) {
            String hql = "FROM Department WHERE name = :searchname";
            return session.createQuery(hql, Department.class)
                    .setParameter("searchname", name)
                    .uniqueResult();
        }
    }

    public void create(Department department) {
        if (existsByName(department.getName())) {
            return;
        }
        try (Session session = HibernateUtils.openSession()) {
            session.beginTransaction();
            session.persist(department);
            session.getTransaction().commit();

        }
    }

    public void update(Department department) {
        if (!existsByID(department.getId()) || existsByName(department.getName())) {
            return;
        }
        try (Session session = HibernateUtils.openSession()) {
            session.beginTransaction();
            session.merge(department);
            session.getTransaction().commit();
        }
    }

    public void deletebyID(int id) {
        Department old = findByID(id);
        if (old == null) {
            return;
        }
        try (Session session = HibernateUtils.openSession()) {
            session.beginTransaction();
            session.remove(old);
            session.getTransaction().commit();
        }
    }

    public boolean existsByID(int id) {
        try (Session session = HibernateUtils.openSession()) {
            return session.get(Department.class, id) != null;
        }
    }

    public boolean existsByName(String name) {
        try (Session session = HibernateUtils.openSession()) {
            String hql = "FROM Department WHERE name = :searchname";
            return session.createQuery(hql, Department.class)
                    .setParameter("searchname", name)
                    .uniqueResult() != null;
        }
    }

}











