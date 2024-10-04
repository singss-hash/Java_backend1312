package com.example.demo.DTO;

import jakarta.validation.constraints.Size;
import lombok.Data;
@Data

//@NoArgsConstructor
//@AllArgsConstructor

public class UserDTO {
	
	
	    public UserDTO() {
//	        super();
	    }

	    public UserDTO(long id,
	                   @Size(max = 1000, message = "UserID is mandatory") long userId,
	                   @Size(max = 256, message = "Name cannot be more than 256 characters") String name,
	                   @Size(max = 50, message = "Email cannot be more than 50 characters") String emailId,
	                   @Size(max = 10000, message = "DepartmentID is mandatory") long departmentId,
	                   @Size(max = 1000, message = "ProjectID is mandatory") long projectId) {
	        super();
	        this.id = id;
	        this.userId = userId;
	        this.name = name;
	        this.emailId = emailId;
	        this.departmentId = departmentId;
	        this.projectId = projectId;
	    }

	    private long id; // corresponds to User entity's id field

	    @Size(max = 1000, message = "UserID is mandatory")
	    private long userId; // corresponds to User entity's UserId field

	    @Size(max = 256, message = "Name cannot be more than 256 characters")
	    private String name; // corresponds to User entity's Name field

	    @Size(max = 50, message = "Email cannot be more than 50 characters")
	    private String emailId; // corresponds to User entity's EmailId field

	    @Size(max = 10000, message = "DepartmentID is mandatory")
	    private long departmentId; // corresponds to User entity's DepartmentId field

	    @Size(max = 1000, message = "ProjectID is mandatory")
	    private long projectId; // corresponds to User entity's ProjectId field

	    // Getters and Setters
	    public long getId() {
	        return id;
	    }

	    public void setId(long id) {
	        this.id = id;
	    }

	    public long getUserId() {
	        return userId;
	    }

	    public void setUserId(long userId) {
	        this.userId = userId;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getEmailId() {
	        return emailId;
	    }

	    public void setEmailId(String emailId) {
	        this.emailId = emailId;
	    }

	    public long getDepartmentId() {
	        return departmentId;
	    }

	    public void setDepartmentId(long departmentId) {
	        this.departmentId = departmentId;
	    }

	    public long getProjectId() {
	        return projectId;
	    }

	    public void setProjectId(long projectId) {
	        this.projectId = projectId;
	    }
	}
