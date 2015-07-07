package ua.synyak.dima.project2.department.DAO;

import ua.synyak.dima.project2.department.Department;
import ua.synyak.dima.project2.department.Person;
import ua.synyak.dima.project2.department.Position;

/**
 * Created by root on 7/6/15.
 */
public interface DepartmentDAO {
    public boolean addDepartment(Department department);
    public boolean removeDepartment(Department department);
    public boolean updateDepartment(Department department);
    public Department getDepartment(Person person);
    public Department getDepartment(String departmentName);
    public Department getDepartment(Position position);
}
