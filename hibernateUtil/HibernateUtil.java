package ua.synyak.dima.project2.department.hibernateUtil;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * Created by root on 7/6/15.
 */
public class HibernateUtil {
    private static SessionFactory sessionFactory = null;

    static {
        try {
            //creates the session factory from hibernate.cfg.xml
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
