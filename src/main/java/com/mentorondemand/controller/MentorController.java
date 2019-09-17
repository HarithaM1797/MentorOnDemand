package com.mentorondemand.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mentorondemand.model.Login;
import com.mentorondemand.model.Mentor;
import com.mentorondemand.model.MentorCalendar;
import com.mentorondemand.model.MentorSkills;
import com.mentorondemand.repo.LoginRepository;
import com.mentorondemand.repo.MentorCalendarRepository;
import com.mentorondemand.repo.MentorRepository;
import com.mentorondemand.repo.MentorSkillRepository;
import com.mentorondemand.repo.ProposalRequestRepository;
import com.mentorondemand.repo.TrainingRepository;

@CrossOrigin(origins = "http://localhost:4321")
@RestController
@RequestMapping("/api")
public class MentorController {

	@Autowired
	MentorRepository mentorRepo;
	
	@Autowired
	MentorCalendarRepository mentorCalendarRepo;
	
	@Autowired
	MentorSkillRepository skillRepo;

	 @Autowired 
     LoginRepository loginRepo;
	 
	@Autowired
	MentorCalendarRepository calendarRepo;
	
	@Autowired
	ProposalRequestRepository proposalRequestRepo;

	@Autowired
	TrainingRepository trainingRepo;

	@PostMapping(value = "/mentor/register")
	public void postCustomer(@RequestBody Mentor mentor) {

		
		Mentor mentorInsert = mentorRepo.save(new Mentor(mentor.getFirstName(),mentor.getLastName(),mentor.getEmail(),mentor.getPassword(),mentor.getContactNumber(),mentor.getLinkedinUrl(),mentor.getRegDateTime(),mentor.getRegCode(),mentor.getSkills(),mentor.getCurrentCourse(),mentor.getYearOfExperience(),mentor.getRating(),mentor.getSelfRating(),mentor.getStatus()));
		 Login loginDetails= loginRepo.save(new Login(mentor)); 	
		

	}
	

	@DeleteMapping("/mentor/deleteSkill")
	public ResponseEntity<String> deleteAllCustomers(@RequestBody MentorSkills mentorSkills) {
		System.out.println("Delete All Customers...");

		skillRepo.deleteByMentorId(mentorSkills.getMentorId());

		return new ResponseEntity<>("Customer has been deleted!", HttpStatus.OK);
	}
	@PostMapping(value = "/mentor/addSkill")
	public MentorSkills mentorAddSkill(@RequestBody MentorSkills mentorSkills) {

		MentorSkills mentorSkillInsert = skillRepo.save(new MentorSkills(mentorSkills.getMentorId(),
				mentorSkills.getSkillName(), mentorSkills.getYearsOfExperience(), mentorSkills.getRegDateTime(),
				mentorSkills.getTrainingsDelivered(), mentorSkills.getFacilities()));
		return mentorSkillInsert;

	}

	@PostMapping("/mentor/getMentorId/{email}")
	public Long getMentorId(@PathVariable("email") String email) {
		System.out.println("Delete Customer with ID = " + email + "...");

		Mentor mentor=mentorRepo.findByEmail(email);
		

		return mentor.getMentorId();
	}
	@PostMapping(value="mentor/getMentorSkills/{mentorId}")
	public Optional<MentorSkills> getMentorSkills(@PathVariable("mentorId") Long mentorId) {
	Optional<MentorSkills> mentorSkills=skillRepo.findById(mentorId);
	return mentorSkills;
	}
	
	@PutMapping(value = "mentor/update")
	public void updateByAge(@RequestBody MentorSkills mentorSkills) {

		  skillRepo.updateSkill(mentorSkills.getMentorId(),mentorSkills.getSkillName(),mentorSkills.getRegDateTime(),mentorSkills.getYearsOfExperience(),mentorSkills.getTrainingsDelivered(),mentorSkills.getFacilities());
	
	}
	
	/*
	 * @PostMapping(value = "/mentor/confirmation") public Trainings
	 * mentorconfirmation(@RequestBody ProposalRequest proposalRequest) {
	 * 
	 * MentorCalendar
	 * mentorCalendar=mentorCalendarRepo.findByMentorId(proposalRequest.getMentorId(
	 * )); Trainings trainingsInsert = trainingRepo.save(new
	 * Trainings(proposalRequest.getTechnologyId(),proposalRequest.getMentorId(),
	 * mentorCalendar.getStartTime(),mentorCalendar.getEndTime())); return
	 * trainingsInsert;
	 * 
	 * }
	 */

	@DeleteMapping("/mentor/rejection/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable("id") long id) {
		System.out.println("Delete Customer with ID = " + id + "...");

		proposalRequestRepo.deleteById(id);

		return new ResponseEntity<>("Customer has been deleted!", HttpStatus.OK);
	}
	
	@PostMapping(value = "/mentor/addCalendar")
	public MentorCalendar mentorAddCalendar(@RequestBody MentorCalendar mentorCalendar) {

		MentorCalendar mentorCalendarInsert = calendarRepo.save(new MentorCalendar(mentorCalendar.getMentorId(),mentorCalendar.getStartTime(),mentorCalendar.getEndTime()));
		return mentorCalendarInsert;

	}
}
