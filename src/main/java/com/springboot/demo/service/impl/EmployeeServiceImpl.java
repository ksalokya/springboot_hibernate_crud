package com.springboot.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springboot.demo.exception.ResourceNotFoundException;
import com.springboot.demo.model.Employee;
import com.springboot.demo.repository.EmployeeRepository;
import com.springboot.demo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeRepository employeeRepository;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(long id) {
		Optional<Employee> employee = employeeRepository.findById(id);

		if (employee.isPresent()) {
			return employee.get();
		} else {
			throw new ResourceNotFoundException("Employee", "ID", id);
		} // can be substituted with LAMDA Expression
	}

	@Override
	public Employee updateEmployee(Employee employee, long id) {
		
		// we need to check whether employee with given id is exist in DB or not
		Employee existingEmployee = 
				employeeRepository.findById(id).orElseThrow(
						() -> new ResourceNotFoundException("Employee", "ID", id));
		
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		
		employeeRepository.save(existingEmployee);
		return existingEmployee;
	}

	@Override
	public void deleteEmployee(long id) {
		// check whether a employee exist in a DB or not
		employeeRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Employee", "ID", id));
				
		employeeRepository.deleteById(id);		
	}

}
