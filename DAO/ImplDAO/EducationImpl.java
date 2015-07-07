package ua.synyak.dima.project2.department.DAO.ImplDAO;

import org.hibernate.Session;
import ua.synyak.dima.project2.department.DAO.EducationDAO;
import ua.synyak.dima.project2.department.Department;
import ua.synyak.dima.project2.department.Education;
import ua.synyak.dima.project2.department.hibernateUtil.HibernateUtil;

/**
 * Created by root on 7/6/15.
 */
public class EducationImpl implements EducationDAO {
    @Override
    public boolean addEducation(Education education) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(education);
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
    public boolean removeEducation(Education education) {
        return false;
    }

    @Override
    public boolean updateEducation(Education education) {
        return false;
    }

    @Override
    public Education getEducation(String educationName) {
        Session session = null;
        Education education = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            education = (Education) session.createQuery("from ua.synyak.dima.project2.department.Education as edu where edu.educationName = ?").setString(0, educationName).uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return education;
    }
}
