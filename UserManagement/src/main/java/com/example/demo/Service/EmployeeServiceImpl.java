package com.example.demo.Service;
import com.example.demo.DTO.AuthResponseDTO;
import com.example.demo.DTO.EmployeeDTO;
import com.example.demo.Entity.Employee;
import com.example.demo.Exception.UserNotFoundException;
import com.example.demo.Repository.EmployeeRepository;
import com.example.demo.utils.JwtTokenProviders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private JwtTokenProviders jwtTokenProvider;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public Employee register(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setEmailId(employeeDTO.getEmailId());
        employee.setPassword(passwordEncoder.encode(employeeDTO.getPassword()));
        employee.setRole(employeeDTO.getRole());
        return employeeRepository.save(employee);
    }

    @Override
    public AuthResponseDTO login(String email, String password) {
        List<Employee> employees = employeeRepository.findByEmailId(email);

        if (employees.isEmpty()) {
            throw new UserNotFoundException("User not found");
        }

        Employee employee = employees.get(0); // for empty list

        if (!passwordEncoder.matches(password, employee.getPassword())) {
            throw new UserNotFoundException("Invalid password"); // invalid password
        }

        String token = jwtTokenProvider.createToken(email, employee.getRole());
        return new AuthResponseDTO(token);
    }
}

