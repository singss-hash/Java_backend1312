package com.example.demo.Service;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.UserDTO;
import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;



@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDTO> getALLUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(this::convertEntityToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserByUserId(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id " + id));
        return convertEntityToDTO(user);
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        // Check if user ID already exists
        if (userRepository.existsByUserId(userDTO.getUserId())) {
            throw new RuntimeException("User with userId " + userDTO.getUserId() + " already exists!");
        }

        User user = convertDTOToEntity(userDTO);
        User savedUser = userRepository.save(user);
        return convertEntityToDTO(savedUser);
    }

    @Override
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id " + id));

        // Check if the new user ID already exists for another user
        /*
        if (!user.getUserId().equals(userDTO.getUserId()) &&
            userRepository.existsByUserId(userDTO.getUserId())) {
            throw new RuntimeException("User with userId " + userDTO.getUserId() + " already exists!");
        }
        */

        user.setName(userDTO.getName());
        user.setEmailId(userDTO.getEmailId());
        user.setDepartmentId(userDTO.getDepartmentId());
        user.setProjectId(userDTO.getProjectId());

        User updatedUser = userRepository.save(user);
        return convertEntityToDTO(updatedUser);
    }

    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id " + id));
        userRepository.delete(user);
    }

    // Helper method to convert Entity to DTO
    private UserDTO convertEntityToDTO(User user) {
        return new UserDTO(
                user.getId(),
                user.getUserId(),
                user.getName(),
                user.getEmailId(),
                user.getDepartmentId(),
                user.getProjectId()
        );
    }

    // Helper method to convert DTO to Entity
    private User convertDTOToEntity(UserDTO userDTO) {
        User user = new User();
        user.setUserId(userDTO.getUserId());
        user.setName(userDTO.getName());
        user.setEmailId(userDTO.getEmailId());
        user.setDepartmentId(userDTO.getDepartmentId());
        user.setProjectId(userDTO.getProjectId());
        return user;
    }

}