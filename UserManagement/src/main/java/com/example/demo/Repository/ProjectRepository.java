package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {
	 boolean existsByProjectId(Long projectId);
}
