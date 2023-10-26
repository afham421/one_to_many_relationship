package com.dbCRUD.dao;

import com.dbCRUD.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddresssDao extends JpaRepository<Address,Long> {

}
