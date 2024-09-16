package net.java.springboot.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity


@Table(name = "projects")
public class ProjectInfo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Primary key

    @Column(name = "project_name", nullable = false)
    private String projectName; // Project name

    @Column(name = "department")
    private String department; // Department name

    @Column(name = "location")
    private String location; // Project location

    @Column(name = "clients")
    private String clients; // Clients involved in the project

    @Column(name = "project_expiration_time")
    private LocalDateTime projectExpirationTime; // Project expiration time

    @Column(name = "project_start_date")
    private LocalDateTime projectStartDate; // Project start date

    // Getters and Setters
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;  // Expecting a String here
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getClients() {
        return clients;
    }

    public void setClients(String clients) {
        this.clients = clients;
    }

    public LocalDateTime getProjectExpirationTime() {
        return projectExpirationTime;
    }

    public void setProjectExpirationTime(LocalDateTime projectExpirationTime) {
        this.projectExpirationTime = projectExpirationTime;
    }

    public LocalDateTime getProjectStartDate() {
        return projectStartDate;
    }

    public void setProjectStartDate(LocalDateTime projectStartDate) {
        this.projectStartDate = projectStartDate;
    }
}
