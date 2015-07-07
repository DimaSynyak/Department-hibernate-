package ua.synyak.dima.project2.department;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 7/6/15.
 */
@Entity(name = "department")
public class Department {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "department_id")
    private int department_id;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Position> positions = new ArrayList<>();

    @Column(name = "departmentName")
    private String departmentName;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Person> persons = new ArrayList<Person>();

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public void addPersons(Person person) {
        this.persons.add(person);
    }

    public Person getPerson(int id) {
        return persons.get(id);
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public List<Position> getPositions() {
        return positions;
    }

    public Position getPosition(String positionName) {
        for (Position position : positions){
            if (positionName.equals(position.getPositionName())){
                return position;
            }
        }
        return null;
    }

    public boolean containPosition(String positionName) {
        for (Position position : positions){
            if (positionName.equals(position.getPositionName())){
                return true;
            }
        }
        return false;
    }

    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }
}
