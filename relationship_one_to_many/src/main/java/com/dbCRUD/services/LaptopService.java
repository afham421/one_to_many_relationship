package com.dbCRUD.services;

import com.dbCRUD.dao.LaptopDao;
import com.dbCRUD.entity.Laptop;
import com.dbCRUD.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.PrintStream;
import java.util.List;
import java.util.Optional;

@Service
public class LaptopService {



    @Autowired
    private LaptopDao laptopdao;

    public Iterable<Laptop> getAllLaptop(){
        Iterable<Laptop> all = laptopdao.findAll();
        return all;
    }
    public Optional<Laptop> findLaptopById(Long id){
        Optional<Laptop> laptop = null;
        try {
            laptop = laptopdao.findById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return laptop;

    }

    public void addLaptop(Laptop laptop){
        try {
            laptopdao.save(laptop);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Laptop updateLaptop(Laptop laptop , Long id){

        laptop.setId(id); // ab agr user jo id dy ga woh is Laptop ko assign ho jay gi // or wohi id wala laptop update ho ga
        Laptop update = laptopdao.save(laptop);
        return update;
    }


    public void deleteLaptop(Long id){
        laptopdao.deleteById(id);
    }


}
