package com.microservice.addressApp.controllers;

import com.microservice.addressApp.entities.Address;
import com.microservice.addressApp.response.AddressResponse;
import com.microservice.addressApp.services.AddressService;
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
