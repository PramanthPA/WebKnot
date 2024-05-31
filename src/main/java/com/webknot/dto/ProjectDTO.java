package com.webknot.dto;

import com.webknot.entity.Employee;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectDTO {

    private String projectType;
    private String sourceClient;
    private String endClient;
    private String projectDescription;
    private String projectStatus;
    @ManyToOne
    private Employee accountManager;

    @ManyToOne
    private Employee projectManager;
}
