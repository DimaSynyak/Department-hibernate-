package ua.synyak.dima.project2.department.DAO.ImplDAO;

import org.hibernate.Session;
import ua.synyak.dima.project2.department.DAO.DepartmentDAO;
import ua.synyak.dima.project2.department.Department;
import ua.synyak.dima.project2.department.Person;
import ua.synyak.dima.project2.department.Position;
import ua.synyak.dima.project2.department.hibernateUtil.HibernateUtil;

import java.util.List;

/**
 * Created by root on 7/6/15.
 */
public class DepartmentImpl implements DepartmentDAO{
    @Override
    public boolean addDepartment(Department department) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(department);
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
    public boolean removeDepartment(Department department) {
        return false;
    }

    @Override
    public boolean updateDepartment(Department department) {
        return false;
    }

    @Override
    public Department getDepartment(Person person) {
        return null;
    }

    @Override
    public Department getDepartment(String departmentName) {
        Session session = null;
        Department department = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            department = (Department) session.createQuery("from ua.synyak.dima.project2.department.Department as dep where dep.departmentName = ?").setString(0, departmentName).uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return department;
    }

    @Override
    public Department getDepartment(Position position) {
     /*
        Session session = null;
        Department department = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            department = (Department) session.createQuery("from ua.synyak.dima.project2.department.Department as dep where dep.departmentName = ?").setString(0, departmentName).uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return department;
        */
        return null;
    }
}
