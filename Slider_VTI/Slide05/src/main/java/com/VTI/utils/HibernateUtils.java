package com.VTI.utils;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

//@Component
public class HibernateUtils {
    private SessionFactory factory;

    public Session openSession(){
        if (factory == null || factory.isClosed()) {
            factory = new Configuration().configure().buildSessionFactory();
        }
        return factory.openSession();
    }

    public void closeFactory(){
        if (factory != null){
            factory.isClosed();
        }
    }
}
