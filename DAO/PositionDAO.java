package ua.synyak.dima.project2.department.DAO;

import ua.synyak.dima.project2.department.Position;

/**
 * Created by root on 7/6/15.
 */
public interface PositionDAO {
    public boolean addPosition(Position position);
    public boolean removePosition(Position position);
    public Position getPosition(String positionName);
}
