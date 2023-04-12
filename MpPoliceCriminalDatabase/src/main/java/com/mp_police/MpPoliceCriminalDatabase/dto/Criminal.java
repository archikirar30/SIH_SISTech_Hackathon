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
@Table(name = "criminals", uniqueConstraints = {@UniqueConstraint(columnNames = "criminalId")})
public class Criminal {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long criminalId;
	
	@Column(nullable = false)
	private String criminalName;
	
	@Column(nullable = false)
	private String criminalDob;
	
	@Column(nullable = false)
	private String age;
	
	@Column(nullable = false)
	private String address;
	
	@Column(nullable = false)
	private String city;
	
	@Column(nullable = false)
	private String state;
	
	@Column(nullable = false)
	private String country;
	
	@Column(nullable = false)
	private String zipcode;
	
	@Column(nullable = false)
	private String actofCharge;
	
	@Column(nullable = false)
	private String previouslyCharged;
	
	@Column(nullable = false)
	private Boolean previousCrime;
	
	@Column(nullable = false)
	private String evidence;
	
	@Column(nullable = false)
	private String crimeDate;
	
	@Column(nullable = false)
	private String crimePlace;
	
	@Column(nullable = false)
	private String crimeCategory;
	
	@Column(nullable = false)
	private String description;
	
	@Column(nullable = true)
	private String criminalImageUrl;
	
	@Column(nullable = false)
	private String gender;
	
	private String imagePath;

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public long getCriminalId() {
		return criminalId;
	}

	public void setCriminalId(long criminalId) {
		this.criminalId = criminalId;
	}

	public String getCriminalName() {
		return criminalName;
	}

	public void setCriminalName(String criminalName) {
		this.criminalName = criminalName;
	}

	public String getCriminalDob() {
		return criminalDob;
	}

	public void setCriminalDob(String criminalDob) {
		this.criminalDob = criminalDob;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getActofCharge() {
		return actofCharge;
	}

	public void setActofCharge(String actofCharge) {
		this.actofCharge = actofCharge;
	}

	public String getPreviouslyCharged() {
		return previouslyCharged;
	}

	public void setPreviouslyCharged(String previouslyCharged) {
		this.previouslyCharged = previouslyCharged;
	}

	public Boolean getPreviousCrime() {
		return previousCrime;
	}

	public void setPreviousCrime(Boolean previousCrime) {
		this.previousCrime = previousCrime;
	}

	public String getEvidence() {
		return evidence;
	}

	public void setEvidence(String evidence) {
		this.evidence = evidence;
	}

	public String getCrimeDate() {
		return crimeDate;
	}

	public void setCrimeDate(String crimeDate) {
		this.crimeDate = crimeDate;
	}

	public String getCrimePlace() {
		return crimePlace;
	}

	public void setCrimePlace(String crimePlace) {
		this.crimePlace = crimePlace;
	}

	public String getCrimeCategory() {
		return crimeCategory;
	}

	public void setCrimeCategory(String crimeCategory) {
		this.crimeCategory = crimeCategory;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCriminalImageUrl() {
		return criminalImageUrl;
	}

	public void setCriminalImageUrl(String criminalImageUrl) {
		this.criminalImageUrl = criminalImageUrl;
	}

	public Criminal() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
