package ua.synyak.dima.project2.department.DAO.ImplDAO;

import org.hibernate.Session;
import ua.synyak.dima.project2.department.DAO.LastPositionDAO;
import ua.synyak.dima.project2.department.LastPositions;
import ua.synyak.dima.project2.department.Person;
import ua.synyak.dima.project2.department.Position;
import ua.synyak.dima.project2.department.hibernateUtil.HibernateUtil;

import java.util.List;

/**
 * Created by root on 7/6/15.
 */
public class LastPositionImpl implements LastPositionDAO {
    @Override
    public List<Position> getPositions(Person person) {
        return null;
    }

    @Override
    public boolean addLastPosition(LastPositions lastPositions) {
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(lastPositions);
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
    public List<Person> getPersons(Position position) {
        return null;
    }
}
