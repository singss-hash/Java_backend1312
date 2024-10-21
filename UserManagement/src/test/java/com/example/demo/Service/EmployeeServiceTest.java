package com.example.demo.Service;

import com.example.demo.DTO.AuthResponseDTO;
import com.example.demo.DTO.EmployeeDTO;
import com.example.demo.Entity.Employee;
import com.example.demo.Exception.UserNotFoundException;
import com.example.demo.Repository.EmployeeRepository;
import com.example.demo.utils.JwtTokenProviders;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private JwtTokenProviders jwtTokenProvider;

    @InjectMocks
    private EmployeeServiceImpl employeeServiceImpl;

    private Employee employee;
    private EmployeeDTO employeeDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        employee = new Employee();
        employee.setFirstName("John");
        employee.setLastName("Doe");
        employee.setEmailId("john.doe@example.com");
        employee.setPassword(new BCryptPasswordEncoder().encode("password123")); // Encode the password
        employee.setRole("USER");

        employeeDTO = new EmployeeDTO();
        employeeDTO.setFirstName("John");
        employeeDTO.setLastName("Doe");
        employeeDTO.setEmailId("john.doe@example.com");
        employeeDTO.setPassword("password123");
        employeeDTO.setRole("USER");
    }

    @Test
    void testRegister() {
        when(employeeRepository.save(any(Employee.class))).thenReturn(employee);

        Employee result = employeeServiceImpl.register(employeeDTO);

        assertNotNull(result);
        assertEquals("John", result.getFirstName());
        assertEquals("Doe", result.getLastName());
        assertEquals("john.doe@example.com", result.getEmailId());
        assertNotEquals("password123", result.getPassword());
        verify(employeeRepository, times(1)).save(any(Employee.class));
    }

    @Test
    void testLogin_Success() {
        String email = "john.doe@example.com";
        String password = "password123";

        when(employeeRepository.findByEmailId(employee.getEmailId())).thenReturn(List.of(employee)); // Mock finding the user
        when(jwtTokenProvider.createToken(email, employee.getRole())).thenReturn("mockToken"); // Mock token creation

        AuthResponseDTO result = employeeServiceImpl.login(email, password);

        assertNotNull(result);
        assertEquals("mockToken", result.getToken());
        verify(employeeRepository, times(1)).findByEmailId(email);
    }

    @Test
    void testLogin_InvalidPassword() {
        String email = "john.doe@example.com";
        String wrongPassword = "wrongPassword";

        when(employeeRepository.findByEmailId(email)).thenReturn(List.of(employee));

        Exception exception = assertThrows(UserNotFoundException.class, () -> {
            employeeServiceImpl.login(email, wrongPassword);
        });

        assertEquals("Invalid password", exception.getMessage());
        verify(employeeRepository, times(1)).findByEmailId(email);
    }

    @Test
    void testLogin_UserNotFound() {
        String email = "nonexistent@example.com";
        String password = "password123";

        when(employeeRepository.findByEmailId(email)).thenReturn(List.of());


        UserNotFoundException exception = assertThrows(UserNotFoundException.class, () -> {
            employeeServiceImpl.login(email, password);
        });

        assertEquals("User not found", exception.getMessage());
        verify(employeeRepository, times(1)).findByEmailId(email);
    }
}
