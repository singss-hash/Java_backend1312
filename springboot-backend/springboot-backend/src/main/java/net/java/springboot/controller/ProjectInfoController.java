package net.java.springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.java.springboot.dto.ProjectInfoDTO;
import net.java.springboot.entity.ProjectInfo;
import net.java.springboot.exception.ResourceNotFoundException;
import net.java.springboot.repository.ProjectInfoRepository;
import net.java.springboot.service.ProjectInfoService;

@RestController
@RequestMapping("/projects")
@CrossOrigin("*")
public class ProjectInfoController {

	private final ProjectInfoService projectInfoService;

    public ProjectInfoController(ProjectInfoService projectInfoService) {
        this.projectInfoService = projectInfoService;
    }

    @PostMapping
    public ResponseEntity<ProjectInfoDTO> createProjectInfo(@RequestBody ProjectInfoDTO projectInfoDTO) {
        ProjectInfoDTO createdProjectInfo = projectInfoService.createProjectInfo(projectInfoDTO);
        return ResponseEntity.ok(createdProjectInfo);
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<ProjectInfoDTO> getProjectInfoById(@PathVariable Long projectId) {
        ProjectInfoDTO projectInfo = projectInfoService.getProjectInfoById(projectId);
        return ResponseEntity.ok(projectInfo);
    }

    @GetMapping
    public ResponseEntity<List<ProjectInfoDTO>> getAllProjectInfos() {
        List<ProjectInfoDTO> projectInfos = projectInfoService.getAllProjectInfos();
        return ResponseEntity.ok(projectInfos);
    }

    @PutMapping("/{projectId}")
    public ResponseEntity<ProjectInfoDTO> updateProjectInfo(@PathVariable Long projectId, @RequestBody ProjectInfoDTO projectInfoDTO) {
        ProjectInfoDTO updatedProjectInfo = projectInfoService.updateProjectInfo(projectId, projectInfoDTO);
        return ResponseEntity.ok(updatedProjectInfo);
    }

    @DeleteMapping("/{projectId}")
    public ResponseEntity<Void> deleteProjectInfo(@PathVariable Long projectId) {
        projectInfoService.deleteProjectInfo(projectId);
        return ResponseEntity.noContent().build();
    }
}  