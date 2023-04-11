package com.mp_police.MpPoliceCriminalDatabase.Service;

import java.util.List;

import com.mp_police.MpPoliceCriminalDatabase.dto.Bid;
import com.mp_police.MpPoliceCriminalDatabase.dto.Car;
import com.mp_police.MpPoliceCriminalDatabase.dto.User;

public interface AdminService {
	
	public Bid addBid(Bid bid);// for adding the value of appointment data in database
	
	public List<Bid> showAllBidding();//for displaying all bids/appointment of cars
	
	public List<User> showAllUser();//for displaying all user of abc portal
	
	public List<Car> showAllCar();//for displaying all the cars 
	
	public void deleteCar(Long id); //for deleting the car by car id 
	
	public void deleteUser(Long id);// for deleting the user by user id 
	
	public String sendApproveMail(String mailaddress );// for sending mail related to bid approval
	
	public String sendRejectMail(String mailaddress ); //for sending the mail to reject the bidding 

}
