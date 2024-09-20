package com.microservice.employeeApp.repositories;

import com.microservice.employeeApp.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee , Integer> {
}
