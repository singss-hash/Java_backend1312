
package net.java.springboot.service;

import net.java.springboot.dto.ProjectInfoDTO;
import net.java.springboot.entity.ProjectInfo;
import net.java.springboot.repository.ProjectInfoRepository;
import net.java.springboot.service.ProjectInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectInfoServiceImpl implements ProjectInfoService {
    @Autowired
    private final ProjectInfoRepository projectInfoRepository;

    
    public ProjectInfoServiceImpl(ProjectInfoRepository projectInfoRepository) {
        this.projectInfoRepository = projectInfoRepository;
    }

    @Override
    public ProjectInfoDTO createProjectInfo(ProjectInfoDTO projectInfoDTO) {
        ProjectInfo projectInfo = convertToEntity(projectInfoDTO);
        projectInfo = projectInfoRepository.save(projectInfo);
        return convertToDTO(projectInfo);
    }

    @Override
    public ProjectInfoDTO getProjectInfoById(Long projectId) {
        ProjectInfo projectInfo = projectInfoRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("ProjectInfo not found"));
        return convertToDTO(projectInfo);
    }

    @Override
    public List<ProjectInfoDTO> getAllProjectInfos() {
        return projectInfoRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

//    @Override
//    public ProjectInfoDTO updateProjectInfo(Long projectId, ProjectInfoDTO projectInfoDTO) {
//        ProjectInfo projectInfo = projectInfoRepository.findById(projectId)
//                .orElseThrow(() -> new RuntimeException("ProjectInfo not found"));
//        projectInfo.setCompanyId(projectInfoDTO.getCompanyId());
//        projectInfo.setProjectName(projectInfoDTO.getProjectName());
//        projectInfo.setClient(projectInfoDTO.getClient());
//        projectInfo.setStartDate(projectInfoDTO.getStartDate());
//        projectInfo.setExpDate(projectInfoDTO.getExpDate());
//        projectInfo
    public ProjectInfo updateProjectInfo(Long id, ProjectInfo projectInfo) {
        ProjectInfo existingProjectInfo = projectInfoRepository.findById(id).orElse(null);
        if (existingProjectInfo != null) {
            existingProjectInfo.setProjectName(projectInfo.getProjectName());
            existingProjectInfo.setClient(projectInfo.getClient());
            existingProjectInfo.setStartDate(projectInfo.getStartDate());
            existingProjectInfo.setExpDate(projectInfo.getExpDate());
            existingProjectInfo.setStatus(projectInfo.getStatus());
            return projectInfoRepository.save(existingProjectInfo);
        }
        return null; // Or throw an exception if preferred
    }

    @Override
    public void deleteProjectInfo(Long id) {
        projectInfoRepository.deleteById(id);
    }
}