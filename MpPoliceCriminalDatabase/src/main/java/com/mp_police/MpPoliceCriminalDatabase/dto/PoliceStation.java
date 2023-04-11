package com.mp_police.MpPoliceCriminalDatabase.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;

@Entity
@Table(name = "policestation", uniqueConstraints = {@UniqueConstraint(columnNames = "policeStationName")})
public class PoliceStation {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long psId;
	
	@Column(nullable = false)
	private String policeStationName;
	
	@Email
	@Column(nullable = false)
	private String state;
	
	@Column(nullable = false)
	private String country;
	
	@Column(nullable = false)
	private String zipcode;
	
	@Column(nullable = false)
	private String areaCovering;
	
	@Column(nullable = false)
	private String city;
	
	@Column(nullable = false)
	private String address;
	
	private String imageUrl;
	
	private String imagePath;
}
