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

@Getter 
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ProjectInfoDTO {
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
	


