package com.selenium.address_service.services;

import com.selenium.address_service.entities.Address;
import com.selenium.address_service.repositories.AddressRepository;
import com.selenium.address_service.response.AddressResponse;
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
        System.out.println(address);
        AddressResponse addressResponse = modelMapper.map(address , AddressResponse.class);
        return addressResponse;
    }

    public Address createAddress(Address address){
        return addressRepository.save(address);
    }
}
