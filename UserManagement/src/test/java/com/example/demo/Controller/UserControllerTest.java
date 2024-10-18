package com.example.demo.Controller;

import com.example.demo.DTO.UserDTO;
import com.example.demo.Service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    private UserDTO userDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        userDTO = new UserDTO();
        userDTO.setId(1L);
        userDTO.setUserId(12345L);
        userDTO.setName("John Doe");
        userDTO.setEmailId("john.doe@example.com");
        userDTO.setDepartmentName("HR");
        userDTO.setProjectName("ProjectX");
        userDTO.setDesignation("Manager");
    }

    @Test
    void getAllUsersTest() {
        List<UserDTO> userList = new ArrayList<>();
        userList.add(userDTO);
        when(userService.getALLUsers()).thenReturn(userList);

        ResponseEntity<List<UserDTO>> response = userController.getAllUsers();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());
        verify(userService, times(1)).getALLUsers();
    }

    @Test
    void getUserByUserIdTest() {
        when(userService.getUserByUserId(anyLong())).thenReturn(userDTO);

        ResponseEntity<UserDTO> response = userController.getUserByUserId(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(userDTO, response.getBody());
        verify(userService, times(1)).getUserByUserId(anyLong());
    }

    @Test
    void createUserTest() {
        when(userService.createUser(any(UserDTO.class))).thenReturn(userDTO);

        ResponseEntity<UserDTO> response = userController.createUser(userDTO);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(userDTO, response.getBody());
        verify(userService, times(1)).createUser(any(UserDTO.class));
    }

    @Test
    void updateUserTest() {
        when(userService.updateUser(anyLong(), any(UserDTO.class))).thenReturn(userDTO);

        ResponseEntity<UserDTO> response = userController.updateUser(1L, userDTO);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(userDTO, response.getBody());
        verify(userService, times(1)).updateUser(anyLong(), any(UserDTO.class));
    }

    @Test
    void deleteUserTest() {
        doNothing().when(userService).deleteUser(anyLong());

        ResponseEntity<Void> response = userController.deleteProject(1L);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(userService, times(1)).deleteUser(anyLong());
    }
}
