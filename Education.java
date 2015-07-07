package ua.synyak.dima.project2.department;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 7/6/15.
 */
@Entity(name = "education")
public class Education {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "education_id")
    private int education_id;

    @Column(name = "educationName")
    private String educationName;

    @OneToMany(mappedBy = "education", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Person> persons = new ArrayList<>();

    public int getEducation_id() {
        return education_id;
    }

    public void setEducation_id(int education_id) {
        this.education_id = education_id;
    }

    public String getEducationName() {
        return educationName;
    }

    public void setEducationName(String educationName) {
        this.educationName = educationName;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public void addPerson(Person person) {
        this.persons.add(person);
    }
}
