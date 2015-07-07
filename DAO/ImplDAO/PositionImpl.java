package ua.synyak.dima.project2.department.DAO.ImplDAO;

import org.hibernate.Session;
import ua.synyak.dima.project2.department.DAO.PositionDAO;
import ua.synyak.dima.project2.department.Department;
import ua.synyak.dima.project2.department.Position;
import ua.synyak.dima.project2.department.hibernateUtil.HibernateUtil;

/**
 * Created by root on 7/6/15.
 */
public class PositionImpl implements PositionDAO{
    @Override
    public boolean addPosition(Position position) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.save(position);
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
    public boolean removePosition(Position position) {
        return false;
    }

    @Override
    public Position getPosition(String positionName) {
        Session session = null;
        Position position = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            position = (Position) session
                    .createQuery("from ua.synyak.dima.project2.department.Position as pos where pos.positionName = ?")
                    .setString(0, positionName)
                    .uniqueResult();

            session.beginTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return position;
    }
}
