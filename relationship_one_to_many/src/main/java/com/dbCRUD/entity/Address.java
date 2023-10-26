package com.dbCRUD.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String city;

    private int country;

    @ManyToOne
    @JoinColumn(name = "person_id")
    @JsonBackReference
    // jab hm value ko assign krin gy means postman per post krin gy jaisy person mian laptop ki detail or phir laptop main person ki id is terha loop chal jay gi is ko
    private Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Address() {
    }

    public Address(long id, String city, int country, Person person) {
        this.id = id;
        this.city = city;
        this.country = country;
        this.person = person;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCountry() {
        return country;
    }

    public void setCountry(int country) {
        this.country = country;
    }


    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", country=" + country +
                ", person=" + person +
                '}';
    }
}
