package com.globalexception.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globalexception.model.Employee;
import com.globalexception.repository.EmployeeRepository;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
		
		
	}

	@Override
	public Optional<Employee> findEmployeeById(int id) {
	Optional<Employee> byId = employeeRepository.findById(id);
	return byId;
		
	}

	@Override
	public List<Employee> finfAllEmployee() {
	List<Employee> all = employeeRepository.findAll();
		return all;
	}

	@Override
	public void deleteEmployeeById(int id) {
		employeeRepository.deleteById(id);
		
		
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return employeeRepository.save(employee);
		
	}

	

}
