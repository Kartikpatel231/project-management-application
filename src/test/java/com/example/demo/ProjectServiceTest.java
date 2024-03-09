package com.example.demo;


import com.example.demo.config.DTOCoveter;
import com.example.demo.entity.ProjectEntity;
import com.example.demo.model.ProjectModel;
import com.example.demo.repository.ProjectRepository;
import com.example.demo.service.ProjectService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

    public class ProjectServiceTest {

    @Mock
    private ProjectRepository projectRepository;

    @Mock
    private DTOCoveter dtoCoveter;

    @InjectMocks
    private ProjectService projectService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testCreateProject() {
        ProjectModel projectModel = new ProjectModel();
        projectModel.setName("Test Project");
        projectModel.setDescription("Test Description");

        when(dtoCoveter.modelToEntity(any(ProjectModel.class))).thenReturn(new ProjectEntity());

        String result = projectService.create(projectModel);

        assertEquals("Data insert successfully", result);
        verify(projectRepository, times(1)).save(any(ProjectEntity.class));
    }

    @Test
    void testUpdateProject() {
        Long projectId = 1L;
        ProjectModel projectModel = new ProjectModel();
        projectModel.setName("Updated Project");
        projectModel.setDescription("Updated Description");

        ProjectEntity existingProjectEntity = new ProjectEntity();
        existingProjectEntity.setProjectId(projectId);

        when(projectRepository.findByProjectId(projectId)).thenReturn(existingProjectEntity);
      
        String result = projectService.update(projectModel, projectId);

        assertEquals("Data updated successfully", result);
        verify(projectRepository, times(1)).save(any(ProjectEntity.class));
    }

    @Test
    void testDeleteProject() {
        Long projectId = 1L;
        ProjectEntity existingProjectEntity = new ProjectEntity();
        existingProjectEntity.setProjectId(projectId);

        when(projectRepository.findByProjectId(projectId)).thenReturn(existingProjectEntity);

        String result = projectService.delete(projectId);

        assertEquals("Data deleted successfully", result);
        verify(projectRepository, times(1)).delete(existingProjectEntity);
    }

    @Test
    void testGetOneProject() {
        Long projectId = 1L;
        ProjectEntity existingProjectEntity = new ProjectEntity();
        existingProjectEntity.setProjectId(projectId);

        when(projectRepository.findByProjectId(projectId)).thenReturn(existingProjectEntity);

        ProjectEntity result = projectService.getOne(projectId);

        assertEquals(existingProjectEntity, result);
    }

    @Test
    void testGetOneProjectWithNullId() {
        assertThrows(IllegalArgumentException.class, () -> projectService.getOne(null));
    }

    @Test
    void testGetAllProjects() {
        when(projectRepository.findAll()).thenReturn(Collections.singletonList(new ProjectEntity()));

        List<ProjectEntity> result = projectService.getAll();

        assertEquals(1, result.size());
    }
}


