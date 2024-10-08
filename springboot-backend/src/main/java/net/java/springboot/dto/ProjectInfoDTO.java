package net.java.springboot.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ProjectInfoDTO {
	 public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getExpDate() {
		return expDate;
	}

	public void setExpDate(LocalDate expDate) {
		this.expDate = expDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@NotNull(message = "prjectID is mandatory")
	 private Long projectId;

	    @NotNull(message = "Company ID is mandatory")
	    private Long companyId;

	    @NotBlank(message = "Project name is mandatory")
	    private String projectName;

	    @NotNull(message = "client name is mandatory")
	    private String client;

	    @NotNull(message = "startDate is mandadtory")
	    private LocalDate startDate;

	    @NotNull(message = "expDate is mandatory")
	    private LocalDate expDate;

	    @Size(max = 256, message = "status remark cannot be more than 256 characters")
	    private String status;
	}
	


