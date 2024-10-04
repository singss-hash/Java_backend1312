package com.example.demo.Service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.DTO.ProjectDTO;

@Service
public interface ProjectService {
	List<ProjectDTO> getALLProjects();
	ProjectDTO getProjectById(Long id);
    ProjectDTO createProject(ProjectDTO projectsDTO);
    ProjectDTO updateProject(Long id, ProjectDTO projectsDTO);
    void deleteProject(Long id);	
 }

