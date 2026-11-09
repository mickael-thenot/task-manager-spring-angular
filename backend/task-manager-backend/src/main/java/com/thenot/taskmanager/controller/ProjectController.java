package com.thenot.taskmanager.controller;

import com.thenot.taskmanager.dto.CreateProjectRequest;
import com.thenot.taskmanager.dto.ProjectResponse;
import com.thenot.taskmanager.service.ProjectService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public ResponseEntity<List<ProjectResponse>> getAllProjects() {
        return ResponseEntity.ok(projectService.getAllProjects());
    }

    @PostMapping
    public ResponseEntity<ProjectResponse> createProject(@Valid @RequestBody CreateProjectRequest request) {
        String mockUsername = "micka";
        ProjectResponse response = projectService.createProject(request, mockUsername);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}