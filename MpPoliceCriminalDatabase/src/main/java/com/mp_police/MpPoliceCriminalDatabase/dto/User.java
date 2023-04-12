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
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long usersId;
	
	@Column(nullable = false)
	private String userName;
	
	@Column(nullable = false)
	private String firstName;
	
	@Column(nullable = false)
	private String lastName;
	
	@Column(nullable = false)
	private String rank;
	
	@Email
	@Column(nullable = false)
	private String email;
	
	@JsonIgnore
	private String password;
	
	@Column(nullable = false)
	private String phoneNumber;
	
	@Column(nullable = false)
	private String role;
	
	@Column(nullable = false)
	private Boolean emailVerified = false;
	
	@Column(nullable = false)
	private String city;
	
	@Column(nullable = false)
	private String state;
	
	@Column(nullable = false)
	private int zipcode;
		
	@JsonIgnore
	private long aadharCardNumber;

	public User(long usersId, String userName, String firstName, String lastName, String rank, @Email String email,
			String password, String phoneNumber, String role, Boolean emailVerified, String city, String state,
			int zipcode, long aadharCardNumber) {
		super();
		this.usersId = usersId;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.rank = rank;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.role = role;
		this.emailVerified = emailVerified;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.aadharCardNumber = aadharCardNumber;
	}

	public User(Long id, String firstName2, String lastName2, String userName2, String rank2, String email2,
			String password2, String phoneNumber2, String role2, Boolean emailVerified2, String state2, String city2,
			String state3, String zipcode2, String aadharCardNumber2, String role3) {
		// TODO Auto-generated constructor stub
	}

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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
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

	public Boolean getEmailVerified() {
		return emailVerified;
	}

	public void setEmailVerified(Boolean emailVerified) {
		this.emailVerified = emailVerified;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	public long getAadharCardNumber() {
		return aadharCardNumber;
	}

	public void setAadharCardNumber(long aadharCardNumber) {
		this.aadharCardNumber = aadharCardNumber;
	}
	
	
	

	
	
}
