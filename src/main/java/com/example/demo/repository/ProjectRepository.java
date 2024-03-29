package com.example.demo.repository;

import com.example.demo.entity.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<ProjectEntity,Long> {

    ProjectEntity findByProjectId(Long id);
}
