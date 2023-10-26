package com.dbCRUD.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "person")
@Data
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id; //handle kerny kliye yeh likhain gy // or is sy jo data diya ho ga wohi aay ga like id auto ho tu id show ni ho gi

    private String f_name;

    private String l_name;

    private String city;

    private String status;
                                            //agr yahan mappedBy na likhain gy or oneToone likhain gy tu dono table mian faron key generate ho gi
//    @OneToOne(mappedBy = "person",cascade = CascadeType.ALL)         // but ab aik hi faron key generate ho gi laptop table main or kam dono ly sakin gy
    @OneToOne(mappedBy = "person",cascade = CascadeType.ALL)         // but ab aik hi faron key generate ho gi laptop table main or kam dono ly sakin gy
    @JsonBackReference // jab hm value ko assign krin gy means postman per post krin gy jaisy person mian laptop ki detail or phir laptop main person ki id is terha loop chal jay gi is ko
    private Laptop laptop;  // yahn pr cascade is liye use kiya k jab hm person store krin tu laptop bhi save ho jain or jab person delete krin tu laptop delete bhi ho jain
//                           // cascadetype main ap akeela save bhi use ker sakty hain or akeela remove bhi , jo sirf save kry ga or jo sirf delete kery ga
    @OneToMany(mappedBy = "person" , cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn  //the @PrimaryKeyJoinColumn annotation, which indicates that the primary key of the User entity is used as the foreign key value for the associated Address entity.
    private List<Address> addressList = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @MapsId("id")
    @JoinTable(
            name = "cloth_person",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "cloth_id"))
     List<Cloth> clothList = new ArrayList<>();


    public Person() {
    }



    public Person(long id, String f_name, String l_name, String city, String status, Laptop laptop, List<Address> addressList, List<Cloth> clothList) {
        this.id = id;
        this.f_name = f_name;
        this.l_name = l_name;
        this.city = city;
        this.status = status;
        this.laptop = laptop;
        this.addressList = addressList;
        this.clothList = clothList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getL_name() {
        return l_name;
    }

    public void setL_name(String l_name) {
        this.l_name = l_name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    public List<Cloth> getClothList() {
        return clothList;
    }

    public void setClothList(List<Cloth> clothList) {
        this.clothList = clothList;
    }



    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", f_name='" + f_name + '\'' +
                ", l_name='" + l_name + '\'' +
                ", city='" + city + '\'' +
                ", status='" + status + '\'' +
                ", laptop=" + laptop +
                ", addressList=" + addressList +
                ", clothList=" + clothList +
                '}';
    }
}
