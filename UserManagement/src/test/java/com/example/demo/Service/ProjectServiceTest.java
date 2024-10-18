package com.example.demo.Service;
import com.example.demo.DTO.ProjectDTO;
import com.example.demo.Entity.Project;
import com.example.demo.Repository.ProjectRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ProjectServiceTest {

    @Mock
    private ProjectRepository projectRepository; // Mock the repository

    @InjectMocks
    private ProjectServiceImpl projectServiceImpl; // Inject the repository into the service

    private Project project;
    private ProjectDTO projectDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);


        project = new Project(1L, 100L, "Test Project", 10L, "IT", "Test Description", "Test Client");
        projectDTO = new ProjectDTO();
        projectDTO.setId(1L);
        projectDTO.setProjectId(100L);
        projectDTO.setProjectName("Test Project");
        projectDTO.setDepartmentID(10L);
        projectDTO.setDepartmentName("IT");
        projectDTO.setDescription("Test Description");
        projectDTO.setClient("Test Client");
    }

    @Test
    void testGetAllProjects() {

        List<Project> projectList = new ArrayList<>();
        projectList.add(project);

        when(projectRepository.findAll()).thenReturn(projectList); // Mock the repository behavior


        List<ProjectDTO> result = projectServiceImpl.getALLProjects();


        assertEquals(1, result.size());
        assertEquals("Test Project", result.get(0).getProjectName());
        verify(projectRepository, times(1)).findAll();
    }

    @Test
    void testGetProjectById() {

        when(projectRepository.findById(1L)).thenReturn(Optional.of(project)); // Mock the repository behavior


        ProjectDTO result = projectServiceImpl.getProjectById(1L);


        assertEquals("Test Project", result.getProjectName());
        assertEquals(100L, result.getProjectId());
        verify(projectRepository, times(1)).findById(1L);
    }

    @Test
    void testCreateProject() {

        when(projectRepository.existsByProjectId(100L)).thenReturn(false); // Mock projectId existence check
        when(projectRepository.save(any(Project.class))).thenReturn(project); // Mock save operation


        ProjectDTO result = projectServiceImpl.createProject(projectDTO);


        assertNotNull(result);
        assertEquals("Test Project", result.getProjectName());
        verify(projectRepository, times(1)).existsByProjectId(100L);
        verify(projectRepository, times(1)).save(any(Project.class));
    }

    @Test
    void testCreateProject_ProjectExists() {

        when(projectRepository.existsByProjectId(100L)).thenReturn(true); // Mock projectId existence check


        Exception exception = assertThrows(RuntimeException.class, () -> {
            projectServiceImpl.createProject(projectDTO);
        });

        assertEquals("Project with projectId 100 already exists!", exception.getMessage()); // Updated expected message
        verify(projectRepository, times(1)).existsByProjectId(100L);
        verify(projectRepository, never()).save(any(Project.class));
    }

    @Test
    void testUpdateProject() {

        when(projectRepository.findById(1L)).thenReturn(Optional.of(project)); // Mock finding the project by id
        when(projectRepository.save(any(Project.class))).thenReturn(project);  // Mock save operation


        projectDTO.setProjectName("Updated Project");

        ProjectDTO result = projectServiceImpl.updateProject(1L, projectDTO);


        assertEquals("Updated Project", result.getProjectName());
        verify(projectRepository, times(1)).findById(1L);
        verify(projectRepository, times(1)).save(any(Project.class));
    }

    @Test
    void testUpdateProject_ProjectNotFound() {

        when(projectRepository.findById(1L)).thenReturn(Optional.empty()); // Mock the absence of the project


        Exception exception = assertThrows(RuntimeException.class, () -> {
            projectServiceImpl.updateProject(1L, projectDTO);
        });

        assertEquals("Project not found with id 1", exception.getMessage()); // Updated expected message
        verify(projectRepository, times(1)).findById(1L);
        verify(projectRepository, never()).save(any(Project.class));
    }

    @Test
    void testDeleteProject() {

        when(projectRepository.findById(1L)).thenReturn(Optional.of(project)); // Mock finding the project by id


        doNothing().when(projectRepository).delete(project);


        projectServiceImpl.deleteProject(1L);


        verify(projectRepository, times(1)).findById(1L);
        verify(projectRepository, times(1)).delete(project);
    }

    @Test
    void testDeleteProject_ProjectNotFound() {

        when(projectRepository.findById(1L)).thenReturn(Optional.empty()); // Mock the absence of the project


        Exception exception = assertThrows(RuntimeException.class, () -> {
            projectServiceImpl.deleteProject(1L);
        });

        assertEquals("Project not found with id 1", exception.getMessage()); // Updated expected message to lowercase 'id'
        verify(projectRepository, times(1)).findById(1L);
        verify(projectRepository, never()).delete(any(Project.class));
    }
}
