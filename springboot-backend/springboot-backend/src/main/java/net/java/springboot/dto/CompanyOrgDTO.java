package net.java.springboot.dto;
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
public class CompanyOrgDTO {
	@NotBlank(message = "CompanyId is mandatory")
	 private Long companyId;

	    @NotBlank(message = "Company name is mandatory")
	    private String companyName;

	    @NotBlank(message = "projectId is mandatory")
	    private Long projectId;

	    @NotBlank(message = "location is mandatory")
	    private String location;

		
	}




