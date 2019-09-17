package com.mentorondemand.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mentorondemand.model.Trainings;



public interface TrainingRepository  extends CrudRepository<Trainings, Long> {

	//List<Trainings> findByStatus(String status);


	//List<Trainings> findByUserId(long userId);

	//List<Trainings> findByAmountReceived(String amount);
	
}


