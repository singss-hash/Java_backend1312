package net.java.springboot.service;




import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.java.springboot.dto.EmployeeDTO;
import net.java.springboot.entity.Employee;
import net.java.springboot.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	 @Autowired
 private final EmployeeRepository employeeRepository;

 // Constructor-based injection

 public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
     this.employeeRepository = employeeRepository;
 }

 @Override
 public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
     Employee employee = convertToEntity(employeeDTO);
     employee = employeeRepository.save(employee);
     return convertToDTO(employee);
 }

 @Override
 public EmployeeDTO getEmployeeById(Long empId) {
     Employee employee = employeeRepository.findById(empId)
             .orElseThrow(() -> new RuntimeException("Employee not found"));
     return convertToDTO(employee);
 }

 @Override
 public List<EmployeeDTO> getAllEmployees() {
     return employeeRepository.findAll()
             .stream()
             .map(this::convertToDTO)
             .collect(Collectors.toList());
 }

 @Override
 public EmployeeDTO updateEmployee(Long empId, EmployeeDTO employeeDTO) {
     Employee employee = employeeRepository.findById(empId)
             .orElseThrow(() -> new RuntimeException("Employee not found"));
     employee.setFirstName(employeeDTO.getFirstName());
     employee.setLastName(employeeDTO.getLastName());
     employee.setEmailId(employeeDTO.getEmailId());
     employee.setDesignation(employeeDTO.getDesignation());
     employee.setProjectId(employeeDTO.getProjectId());
     employee.setDoj(employeeDTO.getDoj());
     return convertToDTO(employeeRepository.save(employee));
 }

 @Override
 public void deleteEmployee(Long empId) {
     Employee employee = employeeRepository.findById(empId)
             .orElseThrow(() -> new RuntimeException("Employee not found"));
     employeeRepository.delete(employee);
 }

 private EmployeeDTO convertToDTO(Employee employee) {
     EmployeeDTO dto = new EmployeeDTO();
     dto.setEmpId(employee.getEmpId());
     dto.setFirstName(employee.getFirstName());
     dto.setLastName(employee.getLastName());
     dto.setEmailId(employee.getEmailId());
     dto.setDesignation(employee.getDesignation());
     dto.setProjectId(employee.getProjectId());
     dto.setDoj(employee.getDoj());
     return dto;
 }

 private Employee convertToEntity(EmployeeDTO dto) {
     Employee employee = new Employee();
     employee.setEmpId(dto.getEmpId());
     employee.setFirstName(dto.getFirstName());
     employee.setLastName(dto.getLastName());
     employee.setEmailId(dto.getEmailId());
     employee.setDesignation(dto.getDesignation());
     employee.setProjectId(dto.getProjectId());
     employee.setDoj(dto.getDoj());
     return employee;
 }
}

