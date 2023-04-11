package com.mp_police.MpPoliceCriminalDatabase.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "admin")
public class SuperAdmin {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long adminId;
	
	@Column(nullable = false)
	private String dob;
	
	@Column(nullable = false)
	private String designatedPost;
	
	@Column(nullable = false)
	private String age;
	
	@Column(nullable = false)
	private String staffNumber;
	
	@Column(nullable = false)
	private String zipcode;
	
	@Column(nullable = false)
	private String city;
	
	@Column(nullable = false)
	private String state;
	
	@Column(nullable = false)
	private String country;
	
	private String imageUrl;
	
	private String imagePath;
}
