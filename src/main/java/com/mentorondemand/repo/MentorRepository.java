package com.mentorondemand.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mentorondemand.model.Mentor;
import com.mentorondemand.model.MentorCalendar;
import com.mentorondemand.model.Skills;


public interface MentorRepository extends CrudRepository<Mentor, Long> {

	Optional<Mentor> findById(long id);

	MentorCalendar findByMentorId(long mentorId);

	List<Mentor> findByFirstName(String firstname);

	List<Mentor> findBySkills(String skillName);
	
    @Query(value="select mentor from Mentor mentor where mentor.email=?1 ")
	Mentor findByEmail(String email);

	void deleteByMentorId(int mentorId);

}
