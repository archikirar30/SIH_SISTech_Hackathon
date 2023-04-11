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
@Table(name = "policeofficer")
public class PoliceOfficer {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long pofId;
	
	@Column(nullable = false)
	private String post;
	
	@Email
	@Column(nullable = false)
	private String staffNumber;
	
	@Column(nullable = false)
	private String dob;
	
	@Column(nullable = false)
	private String age;
	
	@Column(nullable = false)
	private String address;
	
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

	public long getPofId() {
		return pofId;
	}

	public void setPofId(long pofId) {
		this.pofId = pofId;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getStaffNumber() {
		return staffNumber;
	}

	public void setStaffNumber(String staffNumber) {
		this.staffNumber = staffNumber;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
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

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
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

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	@Override
	public String toString() {
		return "PoliceOfficer [pofId=" + pofId + ", post=" + post + ", staffNumber=" + staffNumber + ", dob=" + dob
				+ ", age=" + age + ", address=" + address + ", zipcode=" + zipcode + ", city=" + city + ", state="
				+ state + ", country=" + country + ", imageUrl=" + imageUrl + ", imagePath=" + imagePath + "]";
	}

	public PoliceOfficer(long pofId, String post, @Email String staffNumber, String dob, String age, String address,
			String zipcode, String city, String state, String country, String imageUrl, String imagePath) {
		super();
		this.pofId = pofId;
		this.post = post;
		this.staffNumber = staffNumber;
		this.dob = dob;
		this.age = age;
		this.address = address;
		this.zipcode = zipcode;
		this.city = city;
		this.state = state;
		this.country = country;
		this.imageUrl = imageUrl;
		this.imagePath = imagePath;
	}

	public PoliceOfficer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
