package com.mentorondemand.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mentorondemand.model.Skills;

public interface SkillRepository extends CrudRepository<Skills, Long>{
	@Query(value="Select skills From Skills skills where skills.skillName = :skillName")
	List<Skills> findBySkillName(@Param("skillName") String skillName);

	
}
