package com.example.demo.controller;

import com.example.demo.entity.ProjectEntity;
import com.example.demo.model.ProjectModel;
import com.example.demo.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/v1")
public class ProjectController {
    @Autowired
    ProjectService projectService;
    @PostMapping("/project/create")
    public ResponseEntity<String> create(@RequestBody ProjectModel projectModel){
    String result=projectService.create(projectModel);
        return ResponseEntity.ok(result);
    }
    @GetMapping("/project/getAll")
    public List<ProjectEntity> getAll(){
        return projectService.getAll();
    }
    @PutMapping("/project/update/{id}")
    public ResponseEntity<String> update(@RequestBody ProjectModel projectModel,@PathVariable Long id){
        String result = projectService.update(projectModel,id);
        return ResponseEntity.ok(result);
    }
    @GetMapping("/project/get/{id}")
    public ProjectEntity getOne(@PathVariable Long id){
        return projectService.getOne(id);
    }
    @DeleteMapping("/project/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        String resutl= projectService.delete(id);
        return ResponseEntity.ok(resutl);
    }

}
