package ua.synyak.dima.project2.department.DAO;

import ua.synyak.dima.project2.department.LastPositions;
import ua.synyak.dima.project2.department.Person;
import ua.synyak.dima.project2.department.Position;

import java.util.List;

/**
 * Created by root on 7/6/15.
 */
public interface LastPositionDAO {
    public List<Position> getPositions(Person person);
    public boolean addLastPosition(LastPositions lastPositions);
    public List<Person> getPersons(Position position);
}
