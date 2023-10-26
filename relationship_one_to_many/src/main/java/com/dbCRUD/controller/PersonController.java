package com.dbCRUD.controller;

import com.dbCRUD.entity.Person;
import com.dbCRUD.services.ClothService;
import com.dbCRUD.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
//@Controller   // it is for mvc or normal reponse or page
public class PersonController {


    private ClothService clothService;
    @Autowired
    private PersonService personService;
    @GetMapping("/get")
//    @ResponseBody
    public ResponseEntity<List<Person>> getPerson(){
//        System.out.println("if you wants to print all as it is then you need to put @ResponseBody annotation but if you use @RestController then you dont need @ResponseBody");

        List<Person> allPerson = personService.getAllPerson();
        if (allPerson.size()<=0){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.of(Optional.of(allPerson));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Optional<Person>> getPerson(@PathVariable("id") long id){

        Optional<Person> personById = personService.findPersonById(id);
        if (personById==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(personById);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addPerson(@RequestBody Person person){
        try {
            personService.addPerson(person);
            return ResponseEntity.status(HttpStatus.CREATED).body("person successfully added");
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Person> updatePerson(@RequestBody  Person person , @PathVariable("id") long id) {
        try {
            personService.updatePerson(person, id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Person> deletePerson(@PathVariable("id") long id){
        try {
            personService.deletePerson(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}
