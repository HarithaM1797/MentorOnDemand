package com.mentorondemand.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mentorondemand.model.Login;
import com.mentorondemand.repo.LoginRepository;

@CrossOrigin(origins = "http://localhost:4321")
@RestController
@RequestMapping("/api")
public class LoginController {

	@Autowired
	LoginRepository loginRepo;

	@PostMapping(value="/getRole/login")
    public List<Login> getRole(@RequestBody Login login) {
	System.out.println("angular");
			List<Login> result =  loginRepo.findByEmailAndPassword(login.getEmail(), login.getPassword());
			
			return result;
		
}
	
	
}
