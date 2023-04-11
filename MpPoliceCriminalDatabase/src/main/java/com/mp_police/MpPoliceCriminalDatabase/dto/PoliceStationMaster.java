package com.mp_police.MpPoliceCriminalDatabase.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;

@Entity
@Table(name = "police_station_master")
public class PoliceStationMaster {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long psmId;
	
	@Column(nullable = false)
	private String policeStationMasterName;
	
	@Column(nullable = false)
	private String staffNumber;
	
	@Column(nullable = false)
	private String dob;
	
	@Column(nullable = false)
	private String policeStation;
	
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
	
	@Column(nullable = false)
	private String age;
	
	private String imageUrl;
	
	private String imagePath;

	public long getPsmId() {
		return psmId;
	}

	public String getPoliceStationMasterName() {
		return policeStationMasterName;
	}

	public String getStaffNumber() {
		return staffNumber;
	}

	public String getDob() {
		return dob;
	}

	public String getPoliceStation() {
		return policeStation;
	}

	public String getAddress() {
		return address;
	}

	public String getZipcode() {
		return zipcode;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getCountry() {
		return country;
	}

	public String getAge() {
		return age;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public String getImagePath() {
		return imagePath;
	}

	@Override
	public String toString() {
		return "PoliceStationMaster [psmId=" + psmId + ", policeStationMasterName=" + policeStationMasterName
				+ ", staffNumber=" + staffNumber + ", dob=" + dob + ", policeStation=" + policeStation + ", address="
				+ address + ", zipcode=" + zipcode + ", city=" + city + ", state=" + state + ", country=" + country
				+ ", age=" + age + ", imageUrl=" + imageUrl + ", imagePath=" + imagePath + "]";
	}

	public PoliceStationMaster(long psmId, String policeStationMasterName, String staffNumber, String dob,
			String policeStation, String address, String zipcode, String city, String state, String country, String age,
			String imageUrl, String imagePath) {
		super();
		this.psmId = psmId;
		this.policeStationMasterName = policeStationMasterName;
		this.staffNumber = staffNumber;
		this.dob = dob;
		this.policeStation = policeStation;
		this.address = address;
		this.zipcode = zipcode;
		this.city = city;
		this.state = state;
		this.country = country;
		this.age = age;
		this.imageUrl = imageUrl;
		this.imagePath = imagePath;
	}

	public PoliceStationMaster() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
