package com.mp_police.MpPoliceCriminalDatabase.dto;

import java.sql.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "criminals", uniqueConstraints = {@UniqueConstraint(columnNames = "criminalId")})
public class Criminal {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long criminalId;
	
	@Column(nullable = false)
	private String criminalName;
	
	@Column(nullable = true)
	private String aliasName;
	
	@Column(nullable = false)
	private Date dateOfBirth;
	
	@Column(nullable = false)
	private long aadharCard;
	
	@Column(nullable = false)
	private String identificationMark;
	
	@Column(nullable = false)
	private float longitude;
	
	@Column(nullable = false)
	private float latitude;
	
	@Column(nullable = false)
	private String typeOfCrime;
	
	@Column(nullable = false)
	private int ageOfCriminal;
	
	@Column(nullable = false)
	private String timeOfCrime;
	

	@Column(nullable = false)
	private String crimeDate;
	
	@Column(nullable = true)
	private Boolean educated;
	
	@Column(nullable = true)
	private Boolean mentallyIll;
	
	@Column(nullable = true)
	private String path;
	
	@Column(nullable = false)
	private String gender;
	
	@Column(nullable = false)
	private String evidenceImageUrl;
	
	@Column(nullable = true)
	private String criminalImageUrl;
	

	@Column(nullable = false)
	private String chargesImposed;


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


	public String getAliasName() {
		return aliasName;
	}


	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}


	public Date getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public long getAadharCard() {
		return aadharCard;
	}


	public void setAadharCard(long aadharCard) {
		this.aadharCard = aadharCard;
	}


	public String getIdentificationMark() {
		return identificationMark;
	}


	public void setIdentificationMark(String identificationMark) {
		this.identificationMark = identificationMark;
	}


	public float getLongitude() {
		return longitude;
	}


	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}


	public float getLatitude() {
		return latitude;
	}


	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}


	public String getTypeOfCrime() {
		return typeOfCrime;
	}


	public void setTypeOfCrime(String typeOfCrime) {
		this.typeOfCrime = typeOfCrime;
	}


	public int getAgeOfCriminal() {
		return ageOfCriminal;
	}


	public void setAgeOfCriminal(int ageOfCriminal) {
		this.ageOfCriminal = ageOfCriminal;
	}


	public String getTimeOfCrime() {
		return timeOfCrime;
	}


	public void setTimeOfCrime(String timeOfCrime) {
		this.timeOfCrime = timeOfCrime;
	}


	public String getCrimeDate() {
		return crimeDate;
	}


	public void setCrimeDate(String crimeDate) {
		this.crimeDate = crimeDate;
	}


	public Boolean getEducated() {
		return educated;
	}


	public void setEducated(Boolean educated) {
		this.educated = educated;
	}


	public Boolean getMentallyIll() {
		return mentallyIll;
	}


	public void setMentallyIll(Boolean mentallyIll) {
		this.mentallyIll = mentallyIll;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getEvidenceImageUrl() {
		return evidenceImageUrl;
	}


	public void setEvidenceImageUrl(String evidenceImageUrl) {
		this.evidenceImageUrl = evidenceImageUrl;
	}


	public String getCriminalImageUrl() {
		return criminalImageUrl;
	}


	public void setCriminalImageUrl(String criminalImageUrl) {
		this.criminalImageUrl = criminalImageUrl;
	}


	public String getChargesImposed() {
		return chargesImposed;
	}


	public void setChargesImposed(String chargesImposed) {
		this.chargesImposed = chargesImposed;
	}


	public String getPath() {
		return path;
	}


	public void setPath(String path) {
		this.path = path;
	}
	

}
