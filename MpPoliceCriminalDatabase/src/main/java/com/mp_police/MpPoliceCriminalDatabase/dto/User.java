package com.mp_police.MpPoliceCriminalDatabase.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = "phoneNumber")})
public class User {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long usersId;
	
	@Column(nullable = false)
	private String userName;
	
	@Email
	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false)
	private String phoneNumber;
	
	@Column(nullable = false)
	private String role;
	
	@JsonIgnore
	private String password;
	
	private String imageUrl;
	
	@Column(nullable = false)
	private Boolean emailVerified = false;

	public long getUsersId() {
		return usersId;
	}

	public void setUsersId(long usersId) {
		this.usersId = usersId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Boolean getEmailVerified() {
		return emailVerified;
	}

	public void setEmailVerified(Boolean emailVerified) {
		this.emailVerified = emailVerified;
	}

	@Override
	public String toString() {
		return "User [usersId=" + usersId + ", userName=" + userName + ", email=" + email + ", phoneNumber="
				+ phoneNumber + ", role=" + role + ", password=" + password + ", imageUrl=" + imageUrl
				+ ", emailVerified=" + emailVerified + "]";
	}

	public User(long usersId, String userName, @Email String email, String phoneNumber, String role, String password,
			String imageUrl, Boolean emailVerified) {
		super();
		this.usersId = usersId;
		this.userName = userName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.role = role;
		this.password = password;
		this.imageUrl = imageUrl;
		this.emailVerified = emailVerified;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
