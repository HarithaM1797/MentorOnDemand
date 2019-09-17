package com.mentorondemand.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.mentorondemand.model.MentorSkills;

public interface MentorSkillRepository extends CrudRepository<MentorSkills, Long>{

	List<MentorSkills> findByMentorId(long id);
	
	@Modifying
	@Transactional
	@Query("delete from MentorSkills ms where ms.mentorId=?1")
	void deleteByMentorId(long mentorId);
	
	
	@Modifying
	@Transactional
	@Query(value="update MentorSkills ms set ms.skillName =?2,ms.regDateTime=?3,ms.yearsOfExperience=?4,ms.trainingsDelivered=?5,ms.facilities=?6 where ms.mentorId = ?1")
	void updateSkill(long mentorId, String skillName, String regDateTime, String yearsOfExperience,
			String trainingsDelivered, String facilities);
	  
	
}
