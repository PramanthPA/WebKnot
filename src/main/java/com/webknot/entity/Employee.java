package com.webknot.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String techStack;
    private int yearsOfExperience;
    private int yearsInWebknot;
    private String password;

    @ManyToMany(mappedBy = "employees")
    private List<Project> projects;

    // Getters and Setters
}
