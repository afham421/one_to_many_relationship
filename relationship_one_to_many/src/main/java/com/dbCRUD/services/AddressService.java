package com.dbCRUD.services;

import com.dbCRUD.dao.AddresssDao;
import com.dbCRUD.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private AddresssDao addresssDao;

    public Iterable<Address> getAllAddress(){
        Iterable<Address> all = addresssDao.findAll();
        return all;
    }
    public Optional<Address> findAddressById(Long id){
        Optional<Address> address = null;
        try {
            address = addresssDao.findById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return address;

    }

    public void addAddress(Address address){
        try {
            addresssDao.save(address);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Address updateAddress(Address address , Long id){

        address.setId(id); // ab agr user jo id dy ga woh is address ko assign ho jay gi // or wohi id wala address update ho ga
        Address update = addresssDao.save(address);
        return update;
    }


    public void deleteAddress(Long id){
        addresssDao.deleteById(id);
    }

}
