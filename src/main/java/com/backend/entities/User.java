package com.backend.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
public class User {
	@javax.persistence.Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userId = 0;
	@Column (unique = true)
	private String emailAddress = "";
	private String password = "";
	@Transient String cleanPass;
	private boolean active = true;
	@OneToMany(mappedBy="user")
    private Set<Calculator> items;
	
	public User() {}
	
	public User(int userId) {
		this.userId = userId;
	}
	
	public int getUseId() {
		return userId;
	}
	public void setUserId(int id) {
		this.userId = id;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getPassword() {
		return password;
	}
//	public void setPassword(String password) {
//		this.password = password;
//	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	public String getCleanPass() {
		return this.cleanPass;
	}
	
	public void setPassword(String pass) {
		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
		this.cleanPass = pass;
		this.password = bcrypt.encode(pass);
	}
	
	public boolean checkPassword(String cleanPass) {
		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
		return bcrypt.matches(cleanPass,this.password);		
	}
}


