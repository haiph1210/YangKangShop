package com.vti.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
    private static SessionFactory factory ;

    public static Session openSession(){
            if (factory == null || factory.isClosed()){
                factory = new Configuration().configure().buildSessionFactory();
            }
            return factory.openSession();
    }

    public void closeSession(){
        if (factory != null ){
            factory.close();
        }
    }
}
