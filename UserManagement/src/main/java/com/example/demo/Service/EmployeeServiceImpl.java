package com.example.demo.Service;


import com.example.demo.DTO.AuthResponseDTO;
import com.example.demo.DTO.EmployeeDTO;
import com.example.demo.Entity.Employee;
import com.example.demo.Repository.EmployeeRepository;

import com.example.demo.utils.JwtTokenProviders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProviders jwtTokenProvider;

    @Override
    public Employee register(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setEmailId(employeeDTO.getEmailId());
        employee.setPassword(passwordEncoder.encode(employeeDTO.getPassword()));
        // Set other properties as needed

        return employeeRepository.save(employee);
    }

    @Override
    public AuthResponseDTO login(String email, String password) {
        Employee employee = employeeRepository.findByEmailId(email)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        if (passwordEncoder.matches(password, employee.getPassword())) {
            String token = jwtTokenProvider.createToken(employee.getEmailId(),employee.getRole());
            return new AuthResponseDTO(token, "Login successful");
        } else {
            throw new RuntimeException("Invalid password");
        }
    }
}

