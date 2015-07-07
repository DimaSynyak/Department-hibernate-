package ua.synyak.dima.project2.department.DAO;

import ua.synyak.dima.project2.department.DAO.ImplDAO.*;

/**
 * Created by root on 7/6/15.
 */
public class Factory {
    private static DepartmentDAO departmentDAO = null;
    private static EducationDAO educationDAO = null;
    private static LastPositionDAO lastPositionDAO = null;
    private static PersonDAO personDAO = null;
    private static PositionDAO positionDAO = null;
    private static Factory instance = null;

    public static synchronized Factory getInstance(){
        if (instance == null){
            instance = new Factory();
        }
        return instance;
    }

    public static DepartmentDAO getDepartmentDAO() {
        if (departmentDAO == null){
            departmentDAO = new DepartmentImpl();
        }
        return departmentDAO;
    }

    public static EducationDAO getEducationDAO() {
        if (educationDAO == null){
           educationDAO = new EducationImpl();
        }
        return educationDAO;
    }

    public static LastPositionDAO getLastPositionDAO() {
        if (lastPositionDAO == null){
            lastPositionDAO = new LastPositionImpl();
        }
        return lastPositionDAO;
    }

    public static PersonDAO getPersonDAO() {
        if (personDAO == null){
            personDAO = new PersonImpl();
        }
        return personDAO;
    }

    public static PositionDAO getPositionDAO() {
        if (positionDAO == null){
            positionDAO = new PositionImpl();
        }
        return positionDAO;
    }
}
