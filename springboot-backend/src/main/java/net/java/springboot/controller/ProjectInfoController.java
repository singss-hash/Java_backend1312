package net.java.springboot.controller;

import net.java.springboot.model.ProjectInfo;
import net.java.springboot.repository.ProjectInfoRepository;
import net.java.springboot.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/projects")
@CrossOrigin("*")  // To allow requests from any domain (useful for frontend/backend separation)
public class ProjectInfoController {

    @Autowired
    private ProjectInfoRepository projectInfoRepository;

    // Get all projects
    @GetMapping
    public List<ProjectInfo> getAllProjects() {
        return projectInfoRepository.findAll();
    }

    // Create a new project
    @PostMapping
    public ProjectInfo createProject(@RequestBody ProjectInfo projectInfo) {
        return projectInfoRepository.save(projectInfo);
    }

    // Get project by id
    @GetMapping("/{id}")
    public ResponseEntity<ProjectInfo> getProjectById(@PathVariable Long id) {
        ProjectInfo projectInfo = projectInfoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found with id: " + id));
        return ResponseEntity.ok(projectInfo);
    }

    // Update project
    @PutMapping("/{id}")
    public ResponseEntity<ProjectInfo> updateProject(@PathVariable Long id, @RequestBody ProjectInfo projectInfoDetails) {
        ProjectInfo existingProject = projectInfoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found with id: " + id));

        // Update the project details with the values provided in the request body
        existingProject.setProjectName(projectInfoDetails.getProjectName());
        existingProject.setDepartment(projectInfoDetails.getDepartment());
        existingProject.setLocation(projectInfoDetails.getLocation());
        existingProject.setClients(projectInfoDetails.getClients());
        existingProject.setProjectExpirationTime(projectInfoDetails.getProjectExpirationTime());
        existingProject.setProjectStartDate(projectInfoDetails.getProjectStartDate());

        ProjectInfo updatedProject = projectInfoRepository.save(existingProject);
        return ResponseEntity.ok(updatedProject);
    }

    // Delete project
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteProject(@PathVariable Long id) {
        ProjectInfo projectInfo = projectInfoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found with id: " + id));

        projectInfoRepository.delete(projectInfo);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}