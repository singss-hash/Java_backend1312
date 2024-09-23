package net.java.springboot.entity;


	import lombok.AllArgsConstructor;
	import lombok.Getter;
	import lombok.NoArgsConstructor;
	import lombok.Setter;

import java.time.LocalDate;

import jakarta.persistence.*;

	
	@NoArgsConstructor
	@AllArgsConstructor
	@Entity
	@Getter
	@Setter
	@Table(name = "Employee_Info")
	public class Employee {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "emp_id",nullable = false, unique = true)
	    private Long empId;

	    @Column(name = "first_name", nullable = false)
	    private String firstName;

	    @Column(name = "last_name", nullable = false)
	    private String lastName;

	    @Column(name = "email_id", nullable = false, unique = true)
	    private String emailId;

	    @Column(name = "designation")
	    private String designation;

	    @Column(name = "project_id")
	    private Long projectId;

	    @Column(name = "doj",nullable = false)
	    private LocalDate doj;
	}
		