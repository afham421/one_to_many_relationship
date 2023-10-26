package com.dbCRUD.controller;

import com.dbCRUD.dao.ClothDao;
import com.dbCRUD.dao.PersonDao;
import com.dbCRUD.entity.Cloth;
import com.dbCRUD.services.ClothService;
import com.dbCRUD.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cloth")
public class ClothController {


    @Autowired
    private PersonService personService;
    @Autowired
    private ClothService clothService;
    @Autowired
    private PersonDao personDao;
    @Autowired
    private ClothDao clothDao;

    @GetMapping("/get")
//    @ResponseBody
    public ResponseEntity<Iterable<Cloth>> getCloth() {
//        System.out.println("if you wants to print all as it is then you need to put @ResponseBody annotation but if you use @RestController then you dont need @ResponseBody");

        Iterable<Cloth> allCloth = clothService.getAllCloth();


        return ResponseEntity.status(HttpStatus.OK).body(allCloth);
    }


    @GetMapping("/get/{id}")
    public ResponseEntity<Optional<Cloth>> getCloth(@PathVariable("id") int id){

        Optional<Cloth> clothById = clothService.findClothById(id);
//        Optional<Cloth> cloths = clothService.findClothById(id);

        if (clothById.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(clothById);
    }



    @PostMapping("/add")
    public ResponseEntity<String> addCloth(@RequestBody Cloth cloth) {
        try {
            clothService.addCloth(cloth);
            return ResponseEntity.status(HttpStatus.CREATED).body("Address successfully added");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Cloth> updateCloth(@RequestBody Cloth cloth, @PathVariable("id") int id) {
        try {
            clothService.updateCloth(cloth, id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Cloth> deleteCloth(@PathVariable("id") int id) {
        try {
            clothService.deleteCloth(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
