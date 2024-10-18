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

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setEmailId("test@example.com");
        employeeDTO.setPassword("password");

        Employee mockEmployee = new Employee();
        mockEmployee.setId(1);
        mockEmployee.setEmailId("test@example.com");


        when(employeeService.register(any(EmployeeDTO.class))).thenReturn(mockEmployee);


        ResponseEntity<Employee> response = employeeController.register(employeeDTO);


        assertEquals(200, response.getStatusCode().value());
        assertEquals(mockEmployee, response.getBody());
    }

    @Test
    public void testLogin() {

        InfoDTO infoDTO = new InfoDTO();
        infoDTO.setEmailId("test@example.com");
        infoDTO.setPassword("password");

        AuthResponseDTO mockAuthResponse = new AuthResponseDTO("mock-token");


        when(employeeService.login(any(String.class), any(String.class))).thenReturn(mockAuthResponse);


        ResponseEntity<AuthResponseDTO> response = employeeController.login(infoDTO);


        assertEquals(200, response.getStatusCode().value());
        assertEquals(mockAuthResponse, response.getBody());
    }

}
