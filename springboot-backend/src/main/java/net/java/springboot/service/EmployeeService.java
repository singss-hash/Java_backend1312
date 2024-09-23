package net.java.springboot.service;

import java.util.List;
import net.java.springboot.dto.EmployeeDTO;


public interface EmployeeService {
    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);
    List<EmployeeDTO> getAllEmployees();
    EmployeeDTO getEmployeeById(Long empId);

    EmployeeDTO updateEmployee(Long empId, EmployeeDTO employeeDTO);
    void deleteEmployee(Long empId);
}
}

