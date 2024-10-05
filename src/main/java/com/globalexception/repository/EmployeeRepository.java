package com.globalexception.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.globalexception.model.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
