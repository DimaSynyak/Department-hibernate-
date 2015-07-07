package ua.synyak.dima.project2.department;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

/**
 * Created by root on 7/6/15.
 */
@Entity
@Table(name = "last_positions")
public class LastPositions {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "lastPositions_id")
    private int lastPositions_id;

    @Column(name = "person_id", insertable = true, updatable = true)
    private int person_id;

    @Column(name = "position_id", insertable = true, updatable = true)
    private int position_id;

    @ManyToOne
    @JoinColumn(name = "position_id", insertable = false, updatable = false)
    private Position position;

    @ManyToOne
    @JoinColumn(name = "person_id", insertable = false, updatable = false)
    private Person person;

    public int getLastPositions_id() {
        return lastPositions_id;
    }

    public void setLastPositions_id(int lastPositions_id) {
        this.lastPositions_id = lastPositions_id;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getPerson_id() {
        return person_id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public int getPosition_id() {
        return position_id;
    }

    public void setPosition_id(int position_id) {
        this.position_id = position_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }
}
