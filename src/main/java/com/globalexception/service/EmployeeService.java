package com.globalexception.service;

import java.util.List;
import java.util.Optional;

import com.globalexception.model.Employee;

public interface EmployeeService {
	public Employee saveEmployee(Employee employee);
	public Optional<Employee> findEmployeeById(int id);
	public List<Employee> finfAllEmployee();
	public void deleteEmployeeById(int id);
	public Employee updateEmployee(Employee employee);
	

}
