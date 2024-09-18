package com.selenium.address_service.controllers;

import com.selenium.address_service.entities.Address;
import com.selenium.address_service.repositories.AddressRepository;
import com.selenium.address_service.response.AddressResponse;
import com.selenium.address_service.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AddressController {

    @Autowired
    AddressService addressService;

    @GetMapping("address/{employeeId}")
    public ResponseEntity<AddressResponse> getAddressByEmployeeId(@PathVariable int employeeId){
        AddressResponse addressResponse = addressService.getAddressByEmployeeId(employeeId);
        return ResponseEntity.status(HttpStatus.OK).body(addressResponse);
    }

    @PostMapping("address")
    public Address createAddress(@RequestBody Address address){

        return addressService.createAddress(address);
    }
}
