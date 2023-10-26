package com.dbCRUD.services;

import com.dbCRUD.dao.AddresssDao;
import com.dbCRUD.dao.ClothDao;
import com.dbCRUD.entity.Address;
import com.dbCRUD.entity.Cloth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClothService {


    @Autowired
    private ClothDao clothDao;

    public Iterable<Cloth> getAllCloth(){
        List<Cloth> all = clothDao.findAll();
        return all;
    }
    public Optional<Cloth> findClothById(int id){
        Optional<Cloth> cloth = null;
        try {
            cloth = clothDao.findById((long) id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return cloth;

    }

    public void addCloth(Cloth cloth){
        try {
            clothDao.save(cloth);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Cloth updateCloth(Cloth cloth , int id){

        cloth.setId(id); // ab agr user jo id dy ga woh is address ko assign ho jay gi // or wohi id wala address update ho ga
        Cloth update = clothDao.save(cloth);
        return update;
    }


    public void deleteCloth(int id){
        clothDao.deleteById((long) id);
    }
}
