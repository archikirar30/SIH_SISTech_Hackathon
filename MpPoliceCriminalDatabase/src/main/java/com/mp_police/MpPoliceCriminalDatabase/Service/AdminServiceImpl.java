package com.mp_police.MpPoliceCriminalDatabase.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import com.mp_police.MpPoliceCriminalDatabase.dao.CarRepository;
import com.mp_police.MpPoliceCriminalDatabase.dao.UserRepository;
import com.mp_police.MpPoliceCriminalDatabase.dto.Car;
import com.mp_police.MpPoliceCriminalDatabase.dto.User;

@Service("AdminService")
public class AdminServiceImpl implements AdminService{

	@Autowired 
	UserRepository userrepo;
	
	@Autowired 
	CarRepository carrepo;
	
	@Autowired
	public JavaMailSender mailSender;
	
//    Bid bid;
//	List <Bid> UserList = new ArrayList<Bid>();
//	
//	@Override
//	public Bid addBid(Bid bid) {
//		// TODO Auto-generated method stub
//		return bidrepo.save(bid);
//		
//	}
//	
//	@Override
//	public List<Bid> showAllBidding() {
//		List<Bid> allData = bidrepo.findAll();
//		return allData;
//	}
	
	@Override
	public List<User> showAllUser() {
		List<User> allData = userrepo.findAll();
		return allData;
	}
	
	@Override
	public List<Car> showAllCar() {
		List<Car> CarData = carrepo.findAll();
		return CarData;
	}
	
	@Override
	public void deleteCar(Long id) {
		// TODO Auto-generated method stub
		carrepo.deleteById(id);
		
	}
	
	@Override
	public void deleteUser(Long id) {
		// TODO Auto-generated method stub
		userrepo.deleteById(id);
		
	}
	
	@Override
	public String sendApproveMail(String mailaddress ) {
		
		SimpleMailMessage mail = new SimpleMailMessage();
		
		String subject = "Approval of bidding for car";
	    String content = "We are grately wonder you to notify that , your car is aprroved for buy, pleease contact to the owner and get delivery directly to your home. For any query please reach out to us anytime, We are 24/7 available for your help. Thank you :) have a wonderful day";
	    mail.setTo(mailaddress);
	    mail.setSubject(subject);
	    mail.setText(content);
	    System.out.println("Successfull  to the welcome mail to the :" +" "+ mailaddress);
	    
	    mailSender.send(mail);	    
	    return mailaddress;
		
	}
	
	@Override
	public String sendRejectMail(String mailaddress ) {
		
		SimpleMailMessage mail = new SimpleMailMessage();
		
		String subject = "Rejection  of bidding for car";
		String content = "We are so sad to you to notify that , your car is rejected for buy, pleease try other cars from our portal and get delivery directly to your home. For any query please reach out to us anytime, We are 24/7 available for your help. Thank you :) have a wonderful day";
		mail.setTo(mailaddress);
		mail.setSubject(subject);
		mail.setText(content);
		System.out.println("Successfull  to the welcome mail to the :" +" "+ mailaddress);
		
		mailSender.send(mail);	    
		return mailaddress;
		
	}
}
