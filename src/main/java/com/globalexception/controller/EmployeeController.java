package com.globalexception.controller;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globalexception.exception.ResourceNotFoundException;
import com.globalexception.model.Employee;
import com.globalexception.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/add")
	public Employee createEmployee(@Valid @RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);

	}

	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable int id) {
		return employeeService.findEmployeeById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Resource with ID " + id + " not found"));

	}

	@GetMapping("/all")
	public List<Employee> getAllEmployee() {
		return employeeService.finfAllEmployee().stream().sorted(Comparator.comparing(Employee::getEmpId).reversed())
				.collect(Collectors.toList());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable int id) {
		Employee employee=employeeService.findEmployeeById(id).orElseThrow(()->new ResourceNotFoundException("Resource with ID " + id +" not found"));
		employeeService.deleteEmployeeById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@PutMapping("/update")
	public Employee updateEmployee(@RequestBody Employee employee) {
		
		return employeeService.updateEmployee(employee);
		
	}

}
