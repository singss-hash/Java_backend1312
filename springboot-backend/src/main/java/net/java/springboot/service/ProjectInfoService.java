

package net.java.springboot.service;

import net.java.springboot.dto.ProjectInfoDTO;
import net.java.springboot.entity.ProjectInfo;

import java.util.List;

public interface ProjectInfoService {
    ProjectInfoDTO createProjectInfo(ProjectInfoDTO projectInfoDTO);
    ProjectInfoDTO getProjectInfoById(Long projectId);
    List<ProjectInfoDTO> getAllProjectInfos();
    ProjectInfoDTO updateProjectInfo(Long projectId, ProjectInfo projectInfoDTO);
    void deleteProjectInfo(Long projectId);
}
