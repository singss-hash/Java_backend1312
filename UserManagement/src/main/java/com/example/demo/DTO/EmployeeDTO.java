package com.example.demo.DTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmployeeDTO {

    // Getters and Setters
    private int id;
    private String firstName;
    private String lastName;
    private String emailId;
    private String password;
    private String role;
    private String projectName; // To capture associated project's name or any specific info

    // Constructors
    public EmployeeDTO() {
    }

    public EmployeeDTO(int id, String firstName, String lastName, String emailId, String role, String projectName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.password=password;
        this.role = role;
        this.projectName = projectName;
    }

}

