package repository;

import entity.Department;
import org.hibernate.Session;
import utils.HibernateUtils;

import java.util.List;

public class DepartmentRepository {
    public List<Department> findAll(){
        try (Session session = HibernateUtils.openSeesion()){
        String hql = "FROM Department";
        return  session.createQuery(hql, Department.class).getResultList();
        }
    }
    public void create(Department department){
        try (Session session = HibernateUtils.openSeesion()){
        session.beginTransaction();
        session.persist(department);
        session.getTransaction().commit();
        }
    }

    public long countByType(Department.Type type) {
        try (Session session = HibernateUtils.openSeesion()) {
            String hql = "SELECT COUNT(code) FROM Department WHERE type = :type";
            return session.createQuery(hql, Long.class)
                    .setParameter("type", type)
                    .uniqueResult();
        }
    }

}
