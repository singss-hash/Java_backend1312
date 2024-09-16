//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import net.java.springboot.exception.ResourceNotFoundException;
//import net.java.springboot.model.ProjectInfo;
//import net.java.springboot.repository.ProjectInfoRepository;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class ProjectServiceImpl implements ProjectInfoInterface {
//
//    @Autowired
//    private ProjectInfoRepository projectInfoRepository;
//
//    // Get all projects
//    @Override
//    public List<ProjectInfo> getAllProjects() {
//        return projectInfoRepository.findAll();
//    }
//
//    // Create a new project
//    @Override
//    public ProjectInfo createProject(ProjectInfo projectInfo) {
//        return projectInfoRepository.save(projectInfo);
//    }
//
//    // Get project by id
//    @Override
//    public Optional<ProjectInfo> getProjectById(Long id) {
//        return projectInfoRepository.findById(id);
//    }
//
//    // Update project by id
//    @Override
//    public ProjectInfo updateProject1(Long id, ProjectInfo projectInfoDetails) {
//        ProjectInfo existingProject = projectInfoRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Project not found with id: " + id));
//
//        existingProject.setProjectName(projectInfoDetails.getProjectName());
//        existingProject.setDepartment(projectInfoDetails.getDepartment());
//        existingProject.setLocation(projectInfoDetails.getLocation());
//        existingProject.setClients(projectInfoDetails.getClients());
//        existingProject.setProjectExpirationTime(projectInfoDetails.getProjectExpirationTime());
//        existingProject.setProjectStartDate(projectInfoDetails.getProjectStartDate());
//
//        return projectInfoRepository.save(existingProject);
//    }
//
//    // Delete project by id
//    @Override
//    public void deleteProject(Long id) {
//        ProjectInfo projectInfo = projectInfoRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Project not found with id: " + id));
//        projectInfoRepository.delete(projectInfo);
//    }
//
//	@Override
//	public ProjectInfo createProject(ProjectInfo projectInfo) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public ProjectInfo updateProject(Long id, ProjectInfo projectInfoDetails) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//}
