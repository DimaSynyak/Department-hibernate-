package ua.synyak.dima.project2.department.DAO.ImplDAO;

import org.hibernate.Session;
import ua.synyak.dima.project2.department.DAO.PersonDAO;
import ua.synyak.dima.project2.department.Person;
import ua.synyak.dima.project2.department.hibernateUtil.HibernateUtil;

/**
 * Created by root on 7/6/15.
 */
public class PersonImpl implements PersonDAO{
    @Override
    public boolean addPerson(Person person) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(person);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return false;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return true;
    }

    @Override
    public boolean updatePersone(Person person) {
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(person);
            session.beginTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return false;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return true;
    }

    @Override
    public boolean removePerson(Person person) {
        return false;
    }

    @Override
    public Person getPerson(Long person_id) {
        Session session = null;
        Person person = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            person = (Person) session.load(Person.class, person_id);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return person;
    }
}
