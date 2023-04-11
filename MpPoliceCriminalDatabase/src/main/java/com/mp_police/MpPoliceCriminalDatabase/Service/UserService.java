package com.mp_police.MpPoliceCriminalDatabase.Service;

import com.mp_police.MpPoliceCriminalDatabase.dto.Bid;
import com.mp_police.MpPoliceCriminalDatabase.dto.Car;
import com.mp_police.MpPoliceCriminalDatabase.dto.User;

public interface UserService {
	
	public User addUser(User us); // adding the user details to the database
	
	public Car addCar(Car car); // adding the user details to the database
	
	public User showProfile(String name);//showing user profile
	
	public Car showCar(Long id );// viewing car information by id 
	
	public User showUser(Long id );// viewing User information by id 
	
	public Bid showBid(Long id ); //viewing the bid details by id 
	
	public Car updateCar (Long id);//updating the info of cars
	
	public User updateUser(Long id); //for updating the details of user

}
