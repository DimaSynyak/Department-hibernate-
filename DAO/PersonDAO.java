package ua.synyak.dima.project2.department.DAO;

import ua.synyak.dima.project2.department.Person;

/**
 * Created by root on 7/6/15.
 */
public interface PersonDAO {
    public boolean addPerson(Person person);
    public boolean updatePersone(Person person);
    public boolean removePerson(Person person);
    public Person getPerson(Long person_id);
}
