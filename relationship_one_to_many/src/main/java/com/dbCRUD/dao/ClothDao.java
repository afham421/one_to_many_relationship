package com.dbCRUD.dao;

import com.dbCRUD.entity.Cloth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClothDao extends JpaRepository<Cloth , Long> {

}
