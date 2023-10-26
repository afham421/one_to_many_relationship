package com.dbCRUD.entity;

import jakarta.persistence.*;

@Entity
public class Cloth_person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;

    @ManyToOne
    @MapsId("id")
    @JoinColumn(name = "person_id")
    Person person;

    @ManyToOne
    @MapsId("id")
    @JoinColumn(name = "cloth_id")
    Cloth cloth;

    public Cloth_person() {
    }

    public Cloth_person(int id, Person person, Cloth cloth) {
        this.id = id;
        this.person = person;
        this.cloth = cloth;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Cloth getCloth() {
        return cloth;
    }

    public void setCloth(Cloth cloth) {
        this.cloth = cloth;
    }
}
