package ua.synyak.dima.project2.department;


import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by root on 7/6/15.
 */
@Entity(name = "person")
@Proxy(lazy = false)
public class Person {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "person_id")
    private Long person_id;

    @Column(name = "department_id", insertable = true, updatable = true)
    private int department_id;

    @Column(name = "education_id",insertable = true, updatable = true)
    private int education_id;

    @Column(name = "position_id",insertable = true, updatable = true)
    private int position_id;

    private String firstName;
    private String lastName;
    private String middle;

    @Embedded
    private Card card;

    @Embedded
    private Address address;

    @ManyToOne
    @JoinColumn(name = "position_id", insertable = false, updatable = false)
    private Position position;

    @ManyToOne
    @JoinColumn(name = "education_id", insertable = false, updatable = false)
    private Education education;

    @ManyToOne
    @JoinColumn(name = "department_id", insertable = false, updatable = false)
    private Department department;

    public Long getPerson_id() {
        return person_id;
    }

    public void setPerson_id(Long person_id) {
        this.person_id = person_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddle() {
        return middle;
    }

    public void setMiddle(String middle) {
        this.middle = middle;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public int getEducation_id() {
        return education_id;
    }

    public void setEducation_id(int education_id) {
        this.education_id = education_id;
    }

    public int getPosition_id() {
        return position_id;
    }

    public void setPosition_id(int position_id) {
        this.position_id = position_id;
    }

    @OneToMany(mappedBy = "person")
    private Collection<LastPositions> lastPositions;

    public Collection<LastPositions> getLastPositions() {
        return lastPositions;
    }

    public void setLastPositions(Collection<LastPositions> lastPositions) {
        this.lastPositions = lastPositions;
    }
}
