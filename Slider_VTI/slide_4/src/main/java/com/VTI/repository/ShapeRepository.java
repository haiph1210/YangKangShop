package com.VTI.repository;

import com.VTI.entity.Circle;
import com.VTI.entity.Rectangle;
import com.VTI.utils.HibernateUtils;
import org.hibernate.Hibernate;
import org.hibernate.Session;

import java.util.List;

public class ShapeRepository {
    public List<Circle> findAllCircles(){
        try(Session session = HibernateUtils.openSession()) {
            return session.createQuery("From Circle",Circle.class).getResultList();
        }
    }

    public List<Rectangle> findAllRectangles(){
        try(Session session = HibernateUtils.openSession()) {
            return session.createQuery("From Rectangle",Rectangle.class).getResultList();
        }
    }

    public void createCircle(Circle circle){
        try(Session session = HibernateUtils.openSession()) {
            session.beginTransaction();
            session.persist(circle);
            session.getTransaction().commit();
        }
    }

    public void createRectangle(Rectangle rectangle){
        try(Session session = HibernateUtils.openSession()) {
            session.beginTransaction();
            session.persist(rectangle);
            session.getTransaction().commit();
        }
    }
}
