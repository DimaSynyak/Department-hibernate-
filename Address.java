package ua.synyak.dima.project2.department;

import javax.persistence.Embeddable;

/**
 * Created by root on 7/6/15.
 */
@Embeddable
public class Address {

    private String city;
    private String state;
    private String post;
    private int homeNumber;
    private int phone;


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public int getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(int homeNumber) {
        this.homeNumber = homeNumber;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
}
