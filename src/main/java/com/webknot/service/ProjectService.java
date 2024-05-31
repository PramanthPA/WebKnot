package com.webknot.service;

import com.webknot.dto.ProjectDTO;
import com.webknot.entity.Project;

import java.util.List;

public interface ProjectService {
    List<Project> getAllProjects();
    Project getProjectById(Long id);
    Project createProject(ProjectDTO projectDTO);
    Project updateProject(Long id, ProjectDTO projectDTO);
    boolean deleteProject(Long id);
}
