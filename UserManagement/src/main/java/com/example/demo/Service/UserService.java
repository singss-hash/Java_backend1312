package com.example.demo.Service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.DTO.UserDTO;

@Service
public interface UserService {
	List<UserDTO> getALLUsers();
	UserDTO getUserByUserId(Long id);
    UserDTO createUser(UserDTO usersDTO);
    UserDTO updateUser(Long id, UserDTO usersDTO);
    void deleteUser(Long id);
	
 }

