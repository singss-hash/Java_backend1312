package net.java.springboot.dto;
//EmployeeDTO.java


import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder

public class EmployeeDTO {
	 public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public LocalDate getDoj() {
		return doj;
	}

	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}

	@NotBlank(message = "EmpId is mandatory")
 private Long empId;

 @NotBlank(message = "First name is mandatory")
 private String firstName;

 @NotBlank(message = "Last name is mandatory")
 private String lastName;

 @Email(message = "Email should be valid")
 private String emailId;
 
 @NotBlank(message = "Designation is mandatory")
 private String designation;

 @NotBlank(message = "Project is mandatory")
 private Long projectId;

 @NotBlank(message = "Doj is mandatory")
 private LocalDate doj;
}


