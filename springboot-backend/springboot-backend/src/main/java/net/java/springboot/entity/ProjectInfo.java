package net.java.springboot.entity;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity


@Table(name = "projects")
public class ProjectInfo {
    
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "project_id")
	    private Long projectId;

	    @Column(name = "company_id", nullable = false)
	    private Long companyId;

	    @Column(name = "project_name", nullable = false)
	    private String projectName;

	    @Column(name = "client")
	    private String client;

	    @Column(name = "start_date")
	    private LocalDate startDate;

	    @Column(name = "exp_date")
	    private LocalDate expDate;

	    @Column(name = "status")
	    private String status;
	}