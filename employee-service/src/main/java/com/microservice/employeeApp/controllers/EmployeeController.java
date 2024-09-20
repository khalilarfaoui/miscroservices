package com.microservice.employeeApp.controllers;

import com.microservice.employeeApp.entities.Employee;
import com.microservice.employeeApp.response.EmployeeResponse;
import com.microservice.employeeApp.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService ;

    @GetMapping("employee/{id}")
    public ResponseEntity<EmployeeResponse> getEmployeeById(@PathVariable int id){
        EmployeeResponse employeeResponse = employeeService.getEmployeeById(id);
        return ResponseEntity.status(HttpStatus.OK).body(employeeResponse);
    }

    @PostMapping("employee")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeService.createEmployee(employee);
    }
}
