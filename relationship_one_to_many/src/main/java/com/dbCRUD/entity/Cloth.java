package com.dbCRUD.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cloth")
public class Cloth {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;
    public String color;


//    @JoinColumn(name = "person_id")  // pahly tu database main laptop table main person.person_id name aana tha but ab yeh aay ga jo hm ny idhar write kiya hy
    @ManyToMany(mappedBy = "clothList" , cascade = CascadeType.ALL)
    @MapsId("id")
    @JsonIgnore
    @JsonBackReference // jab hm value ko assign krin gy means postman per post krin gy jaisy person mian laptop ki detail or phir laptop main person ki id is terha loop chal jay gi is ko
     List<Person> personList = new ArrayList<>();


    public Cloth() {
    }


    public Cloth(long id, String color, List<Person> personList) {
        this.id = id;
        this.color = color;
        this.personList = personList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }



    @Override
    public String toString() {
        return "Cloth{" +
                "id=" + id +
                ", color='" + color + '\'' +
                ", personList=" + personList +
                '}';
    }
}
