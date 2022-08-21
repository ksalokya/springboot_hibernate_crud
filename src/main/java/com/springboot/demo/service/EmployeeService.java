package com.springboot.demo.service;

import java.util.List;

import com.springboot.demo.model.Employee;

public interface EmployeeService {
	List<Employee> getAllEmployee();
	Employee saveEmployee(Employee employee);
	Employee getEmployeeById(long id);
	Employee updateEmployee(Employee employee, long id);
	void deleteEmployee(long id);
}
