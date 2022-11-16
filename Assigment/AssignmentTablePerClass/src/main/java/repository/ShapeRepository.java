package repository;

import entity.Circle;
import entity.Rectangle;
import org.hibernate.Session;
import utils.HibernateUtils;

import java.util.List;

public class ShapeRepository {
    public List<Circle> findAllCircle(){
        try(Session session = HibernateUtils.openSession()) {
            return session.createQuery("From Circle",Circle.class).getResultList();
        }
    }

    public void createCircle(Circle circle){
        try(Session session = HibernateUtils.openSession()) {
        session.beginTransaction();
        session.persist(circle);
        session.getTransaction().commit();
        }
    }

    public List<Rectangle> findAllRectangle(){
        try(Session session = HibernateUtils.openSession()) {
            return session.createQuery("From Rectangle",Rectangle.class).getResultList();
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
