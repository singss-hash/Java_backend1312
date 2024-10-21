package com.example.demo.Controller;
import com.example.demo.DTO.ProjectDTO;
import com.example.demo.Service.ProjectService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

class ProjectControllerTest {

    @Mock
    private ProjectService projectService;

    @InjectMocks
    private ProjectController projectController;

    private ProjectDTO projectDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        projectDTO = new ProjectDTO();
        projectDTO.setId(1L);
        projectDTO.setProjectId(101L);
        projectDTO.setProjectName("Project Alpha");
        projectDTO.setDepartmentID(10L);
        projectDTO.setDepartmentName("IT");
        projectDTO.setDescription("This is the first project.");
        projectDTO.setClient("Client A");
    }

    @Test
    void getAllProjectsTest() {
        List<ProjectDTO> projectList = new ArrayList<>();
        projectList.add(projectDTO);
        when(projectService.getALLProjects()).thenReturn(projectList);

        ResponseEntity<List<ProjectDTO>> response = projectController.getAllProjects();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());
        verify(projectService, times(1)).getALLProjects();
    }

    @Test
    void getProjectByIdTest() {
        when(projectService.getProjectById(anyLong())).thenReturn(projectDTO);

        ResponseEntity<ProjectDTO> response = projectController.getProjectById(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(projectDTO, response.getBody());
        verify(projectService, times(1)).getProjectById(anyLong());
    }

    @Test
    void createProjectTest() {
        when(projectService.createProject(any(ProjectDTO.class))).thenReturn(projectDTO);

        ResponseEntity<ProjectDTO> response = projectController.createProject(projectDTO);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(projectDTO, response.getBody());
        verify(projectService, times(1)).createProject(any(ProjectDTO.class));
    }

    @Test
    void updateProjectTest() {
        when(projectService.updateProject(anyLong(), any(ProjectDTO.class))).thenReturn(projectDTO);

        ResponseEntity<ProjectDTO> response = projectController.updateProject(1L, projectDTO);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(projectDTO, response.getBody());
        verify(projectService, times(1)).updateProject(anyLong(), any(ProjectDTO.class));
    }

    @Test
    void deleteProjectTest() {
        doNothing().when(projectService).deleteProject(anyLong());

        ResponseEntity<Void> response = projectController.deleteProject(1L);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(projectService, times(1)).deleteProject(anyLong());
    }
}
