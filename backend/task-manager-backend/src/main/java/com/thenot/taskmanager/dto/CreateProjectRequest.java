package com.thenot.taskmanager.dto;

import jakarta.validation.constraints.NotBlank;

public class CreateProjectRequest {
    @NotBlank(message = "Le nom du projet est obligatoire")
    private String name;

    private String description;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}