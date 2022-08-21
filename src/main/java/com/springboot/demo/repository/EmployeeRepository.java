package com.springboot.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springboot.demo.model.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
}
