package net.java.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.java.springboot.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // all crud database methods
	 
	 
}