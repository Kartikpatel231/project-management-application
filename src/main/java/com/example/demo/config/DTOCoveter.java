package com.example.demo.config;

import com.example.demo.entity.ProjectEntity;
import com.example.demo.model.ProjectModel;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DTOCoveter{
    public ProjectEntity modelToEntity(ProjectModel projectModel){
        ProjectEntity obj=new ProjectEntity();
        obj.setName(projectModel.getName());
        obj.setDescription(projectModel.getDescription());
        obj.setStartDate((projectModel.getStartDate()));
        obj.setEndDate((projectModel.getEndDate()));
        return obj;
    }
    public ProjectModel entityToModel(ProjectEntity projectEntity){
        ProjectModel obj=new ProjectModel();
        obj.setName(projectEntity.getName());
        obj.setDescription(projectEntity.getDescription());
        obj.setStartDate(projectEntity.getStartDate());
        obj.setEndDate(projectEntity.getEndDate());
        return obj;
    }
    public void updateEntityFromModel(ProjectEntity entity, ProjectModel model) {
        entity.setName(model.getName());
        entity.setDescription(model.getDescription());
        entity.setStartDate(model.getStartDate());;
        entity.setEndDate(model.getEndDate());
    }
}
