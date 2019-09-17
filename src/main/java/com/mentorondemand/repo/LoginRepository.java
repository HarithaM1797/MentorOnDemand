package com.mentorondemand.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import com.mentorondemand.model.Login;
import com.mentorondemand.model.Technologies;

public interface LoginRepository extends CrudRepository<Login, String> {

	//List findByEmail(String username);
	
	@Query("Select l From Login l where l.email = :email and l.password = :password")
	List<Login> findByEmailAndPassword(@Param("email") String email, @Param("password") String password);
	
}
