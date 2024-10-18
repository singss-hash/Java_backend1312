package com.example.demo.Controller;

import com.example.demo.DTO.AuthResponseDTO;
import com.example.demo.DTO.EmployeeDTO;
import com.example.demo.DTO.InfoDTO;
import com.example.demo.Entity.Employee;
import com.example.demo.Service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class EmployeeControllerTest {

    @InjectMocks
    private EmployeeController employeeController;

    @Mock
    private EmployeeService employeeService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testRegister() {
        // Arrange
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setEmailId("test@example.com");
        employeeDTO.setPassword("password");

        Employee mockEmployee = new Employee();
        mockEmployee.setId(1); // Keep this as Long
        mockEmployee.setEmailId("test@example.com");

        // Mock the employeeService.register() method
        when(employeeService.register(any(EmployeeDTO.class))).thenReturn(mockEmployee);

        // Act
        ResponseEntity<Employee> response = employeeController.register(employeeDTO);

        // Assert
        assertEquals(200, response.getStatusCode().value());
        assertEquals(mockEmployee, response.getBody());
    }

    @Test
    public void testLogin() {
        // Arrange
        InfoDTO infoDTO = new InfoDTO();
        infoDTO.setEmailId("test@example.com");
        infoDTO.setPassword("password");

        // Create AuthResponseDTO with a token
        AuthResponseDTO mockAuthResponse = new AuthResponseDTO("mock-token");

        // Mock the employeeService.login() method
        when(employeeService.login(any(String.class), any(String.class))).thenReturn(mockAuthResponse);

        // Act
        ResponseEntity<AuthResponseDTO> response = employeeController.login(infoDTO);

        // Assert
        assertEquals(200, response.getStatusCode().value());
        assertEquals(mockAuthResponse, response.getBody());
    }

}
