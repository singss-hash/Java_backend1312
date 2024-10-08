package net.java.springboot.dto;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class CompanyOrgDTO {
	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@NotBlank(message = "CompanyId is mandatory")
	 private Long companyId;

	    @NotBlank(message = "Company name is mandatory")
	    private String companyName;

	    @NotBlank(message = "projectId is mandatory")
	    private Long projectId;

	    @NotBlank(message = "location is mandatory")
	    private String location;

		
	}




