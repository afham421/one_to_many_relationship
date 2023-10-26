package com.dbCRUD.dao;

import com.dbCRUD.entity.Laptop;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopDao extends CrudRepository<Laptop,Long> {


}
