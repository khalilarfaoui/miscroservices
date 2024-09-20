package com.microservice.addressApp.services;

import com.microservice.addressApp.entities.Address;
import com.microservice.addressApp.repositories.AddressRepository;
import com.microservice.addressApp.response.AddressResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    ModelMapper modelMapper;

    public AddressResponse getAddressByEmployeeId(int employeeId){
        Address address = addressRepository.findAddressByEmployeeId(employeeId);
        return modelMapper.map(address , AddressResponse.class);
    }

    public Address createAddress(Address address){
        return addressRepository.save(address);
    }
}
