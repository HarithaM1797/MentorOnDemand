package com.mentorondemand.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "login")
public class Login {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="email",unique=true)
    private String email;
	@Column(name="password")
    private String password;
	@Column(name="role")
    private String role="mentor";
	 @OneToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private Admin admin;
	 
	 @OneToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
		private User user;
	
	 @OneToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
		private Mentor mentor;
	 
	 public Login(User user) {
		super();
		this.email = user.getEmail();
		this.password=user.getPassword();
		this.role=user.getRole();
	}


	
	public Login( Admin admin) {
		super();
		this.email = admin.getEmail();
		this.password=admin.getPassword();
		this.role=admin.getRole();
	}
	public Login( Mentor mentor) {
		super();
		this.email = mentor.getEmail();
		this.password=mentor.getPassword();
		
	}

	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}

	

}