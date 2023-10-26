package com.dbCRUD.dao;

import com.dbCRUD.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonDao extends JpaRepository<Person,Long> {

    // is ki implementation nhin likhni springboot khud provide ker dy ga

    // agr yahan spring hota tu phir hmin likhni perti

}
