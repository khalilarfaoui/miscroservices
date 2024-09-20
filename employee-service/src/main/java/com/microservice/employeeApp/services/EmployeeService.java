package com.microservice.employeeApp.services;

import com.microservice.employeeApp.client.AdressClient;
import com.microservice.employeeApp.entities.Employee;
import com.microservice.employeeApp.repositories.EmployeeRepository;
import com.microservice.employeeApp.response.AddressResponse;
import com.microservice.employeeApp.response.EmployeeResponse;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {




    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    ModelMapper modelMapper;


    @Autowired
    private AdressClient adressClient;



    public EmployeeResponse getEmployeeById(int id){

        Employee employee = employeeRepository.findById(id).get();
        EmployeeResponse employeeResponse = modelMapper.map(employee ,EmployeeResponse.class);
        AddressResponse addressResponse = adressClient.getAddressByEmployeeId(id).getBody();
        employeeResponse.setAddressResponse(addressResponse);
        return employeeResponse;
    }

    public Employee createEmployee(Employee employee){
        return employeeRepository.save(employee);
    }
}
