package repository;

import entity.GroupStudent;
import org.hibernate.Session;
import org.hibernate.query.Query;
import utils.HibernateUtils;

import java.util.List;

public class GroupStudentRepository {
    public List<GroupStudent> getAll() {
        try (Session session = HibernateUtils.openSeesion()) {
            String hql = "FROM GroupStudent";
            Query<GroupStudent> query = session.createQuery(hql, GroupStudent.class);
            return query.getResultList();
        }
    }

    public void create(GroupStudent groupStudent) {
        try (Session session = HibernateUtils.openSeesion()) {
            session.beginTransaction();
            session.persist(groupStudent);
            session.getTransaction().commit();
        }
    }

}
