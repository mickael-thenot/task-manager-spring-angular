package com.thenot.taskmanager.service;

import com.thenot.taskmanager.dto.CreateProjectRequest;
import com.thenot.taskmanager.dto.ProjectResponse;
import com.thenot.taskmanager.entity.Project;
import com.thenot.taskmanager.entity.User;
import com.thenot.taskmanager.repository.ProjectRepository;
import com.thenot.taskmanager.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;

    public ProjectService(ProjectRepository projectRepository, UserRepository userRepository) {
        this.projectRepository = projectRepository;
        this.userRepository = userRepository;
    }

    public List<ProjectResponse> getAllProjects() {
        return projectRepository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    public ProjectResponse createProject(CreateProjectRequest request, String username) {
        User owner = userRepository.findByUsername(username)
                .orElseGet(() -> {
                    User newUser = new User();
                    newUser.setUsername(username);
                    newUser.setEmail(username + "@example.com");
                    newUser.setRole(com.thenot.taskmanager.entity.Role.USER);
                    newUser.setPassword("password");
                    return userRepository.save(newUser);
                });
        Project project = new Project();
        project.setName(request.getName());
        project.setDescription(request.getDescription());
        project.setOwner(owner);

        Project savedProject = projectRepository.save(project);
        return mapToResponse(savedProject);
    }

    private ProjectResponse mapToResponse(Project project) {
        ProjectResponse response = new ProjectResponse();
        response.setId(project.getId());
        response.setName(project.getName());
        response.setDescription(project.getDescription());
        response.setOwnerUsername(project.getOwner().getUsername());
        response.setCreatedAt(project.getCreatedAt());
        return response;
    }
}