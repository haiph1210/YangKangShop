package com.VTI.repository;

import com.VTI.entity.Department;
import com.VTI.utils.HibernateUtils;
import org.hibernate.Session;

import java.util.List;

public class DepartmentRepository {
    public List<Department> findAll(){
        try(Session session = HibernateUtils.openSession()) {
           return session.createQuery("From Department",Department.class).getResultList();
        }
    }

    public Department findByID(int id){
        try(Session session =HibernateUtils.openSession()) {
        String hql = "From Department Where id = :searchId";
        return session.createQuery(hql,Department.class).setParameter("searchId",id).uniqueResult();
        }
    }

    public Department findByName(String name){
        try(Session session =HibernateUtils.openSession()) {
            String hql = "From Department Where name = :searchName";
           return session.createQuery(hql,Department.class).setParameter("searchName",name).uniqueResult();
        }
    }
    public void create(Department department){
        try(Session session = HibernateUtils.openSession()) {
            session.beginTransaction();
            session.persist(department);
            session.getTransaction().commit();
        }
    }

    public int update(int id,String newName){
        try(Session session = HibernateUtils.openSession()) {
            String hql = "Update Department Set name = :searchName Where id = :searchId";
            session.beginTransaction();
          int rows=  session.createQuery(hql).setParameter("searchName",newName).setParameter("searchId",id).executeUpdate();
            session.getTransaction().commit();
            return rows;
        }
    }

    public int deleteByID(int id){
        try(Session session = HibernateUtils.openSession()) {
            String hql = "Delete From Department Where id = :searchId";
            session.beginTransaction();
            int rows =  session.createQuery(hql).setParameter("searchId",id).executeUpdate();
            session.getTransaction().commit();
            return rows;
        }
    }

    public int deleteByName(String name){
        try(Session session = HibernateUtils.openSession()) {
            String hql = "Delete From Department Where name = :searchName";
            session.beginTransaction();
            int rows = session.createQuery(hql).setParameter("searchName",name).executeUpdate();
            session.getTransaction().commit();
            return rows;
        }
    }

    public List<Department> findAllWithPaging(int page,int size){
        int start = (page - 1)  * size + 1;
        try(Session session = HibernateUtils.openSession()) {
//            return session.createQuery("From Department Limit :size OffSet :start",Department.class)
//                    .setParameter("size",size)
//                    .setParameter("start",start)
            return session.createQuery("From Department",Department.class)
                    .setFirstResult(start)
                    .setMaxResults(size)
                    .getResultList();
        }
    }





}
