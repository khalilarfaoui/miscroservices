package com.selenium.employee_service.services;

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


    RestTemplate restTemplate;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    ModelMapper modelMapper;




    public EmployeeService(@Value("${addressservice.base.url}") String addressBaseURL ,RestTemplateBuilder builder){
        this.restTemplate = builder
                            .rootUri(addressBaseURL)
                            .build();
    }

    public EmployeeResponse getEmployeeById(int id){

        Employee employee = employeeRepository.findById(id).get();
        EmployeeResponse employeeResponse = modelMapper.map(employee ,EmployeeResponse.class);

        AddressResponse addressResponse = restTemplate.getForObject("/address/{id}" , AddressResponse.class ,id);
        employeeResponse.setAddressResponse(addressResponse);
        return employeeResponse;
    }

    public Employee createEmployee(Employee employee){
        return employeeRepository.save(employee);
    }
}
