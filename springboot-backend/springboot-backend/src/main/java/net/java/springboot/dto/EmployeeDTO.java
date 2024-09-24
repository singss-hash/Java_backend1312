package net.java.springboot.dto;
//EmployeeDTO.java


import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter 
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class EmployeeDTO {
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


