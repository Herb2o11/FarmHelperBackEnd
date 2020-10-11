package com.backend.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
public class User {
	@javax.persistence.Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userId = 0;
	@Column (unique = true)
	private String username = "";
	private String password = "";
	@Transient String cleanPass;
	private boolean active = true;
	@OneToMany(mappedBy="user")
    private Set<Calculator> items;
	
	public User() {}
	
	public User(int userId) {
		this.userId = userId;
	}
	
	public User(String username, String password) {
		this.setUsername(username);
		this.setPassword(password);
	}
	
	public int getUseId() {
		return userId;
	}
	public void setUserId(int id) {
		this.userId = id;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getCleanPass() {
		return this.cleanPass;
	}
	
	public void setPassword(String pass) {
		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
		this.cleanPass = pass;
		this.password = bcrypt.encode(pass);
	}
	
	public void checkPassword(String cleanPass) throws BadCredentialsException {
		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
		if(!bcrypt.matches(cleanPass,this.password)) {
			throw new BadCredentialsException("Bad Credentials");
		}
	}
	
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
}


