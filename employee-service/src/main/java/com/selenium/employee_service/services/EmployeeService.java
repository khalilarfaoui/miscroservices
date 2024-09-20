package com.selenium.employee_service.services;

import com.selenium.employee_service.client.AdressClient;
import com.selenium.employee_service.entities.Employee;
import com.selenium.employee_service.repositories.EmployeeRepository;
import com.selenium.employee_service.response.AddressResponse;
import com.selenium.employee_service.response.EmployeeResponse;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
        System.out.println(employeeResponse);
        AddressResponse addressResponse = adressClient.getAddressByEmployeeId(id).getBody();
        employeeResponse.setAddressResponse(addressResponse);
        return employeeResponse;
    }

    public Employee createEmployee(Employee employee){
        return employeeRepository.save(employee);
    }
}
