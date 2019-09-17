package com.mentorondemand.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mentorondemand.model.Skills;
import com.mentorondemand.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

	List<User> findByFirstName(String firstname);

	void deleteByUserId(int userId);

	

}
