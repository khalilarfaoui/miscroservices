package com.selenium.employee_service.repositories;

import com.selenium.employee_service.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee , Integer> {
}
