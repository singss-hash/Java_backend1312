package com.example.demo.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="user")
public class User {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id")
private long id;

@Column(name="user_id")
private long userId;

@Column(name="name")
private String name;

@Column(name="email_id")
private String emailId;

@Column(name="department_id")
private long departmentId;

//@ManyToOne(fetch = FetchType.EAGER)
//@JoinColumn(name = "Project Name", nullable = false)
@Column(name="project_id")
private long projectId;






}
