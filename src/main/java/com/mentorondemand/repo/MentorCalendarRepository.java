package com.mentorondemand.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mentorondemand.model.MentorCalendar;

public interface MentorCalendarRepository extends CrudRepository<MentorCalendar, Long> {

	List<MentorCalendar> findByMentorId(long mentorId);

//	MentorCalendar findByMentorId(long mentorId);

}
