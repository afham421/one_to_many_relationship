package com.dbCRUD.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "laptop")
public class Laptop {
    @Id
    private long id;
    private String brand;
    private int size;

    @OneToOne
    @JoinColumn(name = "person_id" )     // pahly tu database main laptop table main person.person_id name aana tha but ab yeh aay ga jo hm ny idhar write kiya hy
//    @PrimaryKeyJoinColumn  //  agr yeh na lagain gy tu jab duplicate values aain gi tu error a jay ga
    @JsonBackReference   // jab hm value ko assign krin gy means postman per post krin gy jaisy person mian laptop ki detail or phir laptop main person ki id is terha loop chal jay gi is ko
    private Person person;//handle kerny kliye yeh likhain gy  // or is sy jo data diya ho ga wohi aay ga like id auto ho tu id show ni ho gi

    public Laptop() {
    }

    public Laptop(long id, String brand, int size, Person person) {
        this.id = id;
        this.brand = brand;
        this.size = size;
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", size=" + size +
                ", person=" + person +
                '}';
    }
}
