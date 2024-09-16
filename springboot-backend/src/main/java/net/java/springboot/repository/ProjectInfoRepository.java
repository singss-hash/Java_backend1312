package net.java.springboot.repository;

import net.java.springboot.model.ProjectInfo;
	import org.springframework.data.jpa.repository.JpaRepository;



	public interface ProjectInfoRepository extends JpaRepository<ProjectInfo, Long> {
	}



