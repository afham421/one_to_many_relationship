package com.dbCRUD.controller;

import com.dbCRUD.entity.Laptop;
import com.dbCRUD.services.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RequestMapping("/laptop")
@RestController
//@Controller   // it is for mvc or normal reponse or page
public class LaptopController {
    @Autowired
    private LaptopService laptopService;
    private Object allLaptop;

    @GetMapping("/get")
//    @ResponseBody
    public ResponseEntity<Iterable<Laptop>> getLaptop() {
//        System.out.println("if you wants to print all as it is then you need to put @ResponseBody annotation but if you use @RestController then you dont need @ResponseBody");

        Iterable<Laptop> allLaptop = laptopService.getAllLaptop();


        return ResponseEntity.status(HttpStatus.OK).body(allLaptop);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Optional<Laptop>> getLaptop(@PathVariable("id") long id){

        Optional<Laptop> laptopById = laptopService.findLaptopById(id);
        if (laptopById==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(laptopById);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addLaptop(@RequestBody Laptop laptop) {
        try {
            laptopService.addLaptop(laptop);
            return ResponseEntity.status(HttpStatus.CREATED).body("laptop successfully added");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Laptop> updateLaptop(@RequestBody Laptop laptop, @PathVariable("id") Long id) {
        try {
            laptopService.updateLaptop(laptop, id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Laptop> deleteLaptop(@PathVariable("id") Long id) {
        try {
            laptopService.deleteLaptop(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
