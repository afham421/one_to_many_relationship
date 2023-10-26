package com.dbCRUD.controller;

import com.dbCRUD.entity.Address;
import com.dbCRUD.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/get")
//    @ResponseBody
    public ResponseEntity<Iterable<Address>> getAddress() {
//        System.out.println("if you wants to print all as it is then you need to put @ResponseBody annotation but if you use @RestController then you dont need @ResponseBody");

        Iterable<Address> allAddress = addressService.getAllAddress();


        return ResponseEntity.status(HttpStatus.OK).body(allAddress);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Optional<Address>> getAddress(@PathVariable("id") long id){

        Optional<Address> addressById = addressService.findAddressById(id);
        if (addressById==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(addressById);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addAddress(@RequestBody Address address) {
        try {
            addressService.addAddress(address);
            return ResponseEntity.status(HttpStatus.CREATED).body("Address successfully added");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Address> updateAddress(@RequestBody Address address, @PathVariable("id") Long id) {
        try {
            addressService.updateAddress(address, id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Address> deleteAddress(@PathVariable("id") Long id) {
        try {
            addressService.deleteAddress(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
