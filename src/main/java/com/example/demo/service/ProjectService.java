package com.example.demo.service;

import com.example.demo.config.DTOCoveter;
import com.example.demo.entity.ProjectEntity;
import com.example.demo.model.ProjectModel;
import com.example.demo.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ProjectService {
    @Autowired
    ProjectRepository projectRepository;
    @Autowired(required=true)
    DTOCoveter dtoCoveter;
    public String create(ProjectModel projectModel){
    if(projectModel!=null){
        ProjectEntity projectEntity=dtoCoveter.modelToEntity(projectModel);
        projectRepository.save(projectEntity);
    }
    else {
        throw new IllegalArgumentException("ProjectModel cannot be null");
    }
     return "data insert successfully";
    }
    public List<ProjectEntity>  getAll(){
        return projectRepository.findAll();
    }
    public String update(ProjectModel projectModel,Long id) {
        if (id != null) {
            ProjectEntity projectEntity = projectRepository.findByProjectId(id);
            if (projectEntity != null) {
                dtoCoveter.updateEntityFromModel(projectEntity, projectModel);
                projectRepository.save(projectEntity);
                if (projectEntity != null) {
                    projectRepository.save(projectEntity);
                    return "Data updated successfully";
                } else
                    throw new IllegalArgumentException("No project found with the given ID");
            } else
                throw new IllegalArgumentException("ID is empty");
        }
        return "Data updated successfully";
    }
    public String delete(Long id) {
        if (id != null) {
            ProjectEntity projectEntity = projectRepository.findByProjectId(id);
            projectRepository.delete(projectEntity);
            if (projectEntity != null) {
                projectRepository.delete(projectEntity);
                return "Data deleted successfully";
            } else
                throw new IllegalArgumentException("No project found with the given ID");
        } else {
            throw new IllegalArgumentException("ID is empty");
        }
    }
    public ProjectEntity getOne(Long id){
        if(id!=null){
            ProjectEntity projectEntity=projectRepository.findByProjectId(id);
            return projectEntity;
        }
        else {
            throw new IllegalArgumentException("ID is empty");
        }

    }
}
