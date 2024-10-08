package com.example.demo.config;

import com.example.demo.DTO.UserDTO;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.UserService;
import com.example.demo.Entity.User; // Updated to import the User entity
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class UserInfoUserDetailsService implements UserService, UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = repository.findByName(username); // Updated to User
        return user.map(UserInfoUserDetails::new) // Assuming you have a UserInfoUserDetails constructor for User
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
    }

    @Override
    public List<UserDTO> getALLUsers() {
        // Convert User to UserDTO
        return repository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserByUserId(Long id) {
        User user = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found: " + id));
        return convertToDTO(user);
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = convertToEntity(userDTO);
        User savedUser = repository.save(user);
        return convertToDTO(savedUser);
    }

    @Override
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        User user = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found: " + id));

        // Update fields
        user.setName(userDTO.getName());
        user.setEmailId(userDTO.getEmailId());
        user.setDepartmentId(userDTO.getDepartmentId());
        user.setProjectId(userDTO.getProjectId());

        User updatedUser = repository.save(user);
        return convertToDTO(updatedUser);
    }

    @Override
    public void deleteUser(Long id) {
        repository.deleteById(id);
    }

    // Helper methods to convert between User and UserDTO
    private UserDTO convertToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(user.getUserId());
        userDTO.setName(user.getName());
        userDTO.setEmailId(user.getEmailId());
        userDTO.setDepartmentId(user.getDepartmentId());
        userDTO.setProjectId(user.getProjectId());
        return userDTO;
    }

    private User convertToEntity(UserDTO userDTO) {
        User user = new User(); // Instantiate a new User
        user.setUserId(userDTO.getUserId());
        user.setName(userDTO.getName());
        user.setEmailId(userDTO.getEmailId());
        user.setDepartmentId(userDTO.getDepartmentId());
        user.setProjectId(userDTO.getProjectId());
        return user; // Return the newly created User
    }
}
