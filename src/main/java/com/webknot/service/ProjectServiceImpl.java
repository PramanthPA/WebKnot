package com.webknot.service;

import com.webknot.dto.ProjectDTO;
import com.webknot.entity.Project;
import com.webknot.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public Project getProjectById(Long id) {
        return projectRepository.findById(id).orElse(null);
    }

    @Override
    public Project createProject(ProjectDTO projectDTO) {
        Project project = new Project();
        project.setProjectType(projectDTO.getProjectType());
        project.setSourceClient(projectDTO.getSourceClient());
        project.setEndClient(projectDTO.getEndClient());
        project.setProjectDescription(projectDTO.getProjectDescription());
        project.setProjectStatus(projectDTO.getProjectStatus());
        project.setAccountManager(projectDTO.getAccountManager());
        project.setProjectManager(projectDTO.getProjectManager());
        return projectRepository.save(project);
    }

    @Override
    public Project updateProject(Long id, ProjectDTO projectDTO) {
        Project project = projectRepository.findById(id).orElse(null);
        if (project != null) {
            project.setProjectType(projectDTO.getProjectType());
            project.setSourceClient(projectDTO.getSourceClient());
            project.setEndClient(projectDTO.getEndClient());
            project.setProjectDescription(projectDTO.getProjectDescription());
            project.setProjectStatus(projectDTO.getProjectStatus());
            project.setAccountManager(projectDTO.getAccountManager());
            project.setProjectManager(projectDTO.getProjectManager());
            return projectRepository.save(project);
        }
        return null;
    }

    @Override
    public boolean deleteProject(Long id) {
        if (projectRepository.existsById(id)) {
            projectRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
