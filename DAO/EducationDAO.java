package ua.synyak.dima.project2.department.DAO;

import ua.synyak.dima.project2.department.Education;

/**
 * Created by root on 7/6/15.
 */
public interface EducationDAO {
    public boolean addEducation(Education education);
    public boolean removeEducation(Education education);
    public boolean updateEducation(Education education);
    public Education getEducation(String educationName);
}
