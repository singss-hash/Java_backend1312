package net.java.springboot.repository;

import net.java.springboot.entity.ProjectInfo;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;




	import org.springframework.stereotype.Repository;

	@Repository
	public interface ProjectInfoRepository extends JpaRepository<ProjectInfo, Long> {
	    Optional<ProjectInfo> findByProjectNameAndProjectStartDate(String projectName, LocalDateTime projectStartDate);
	}




