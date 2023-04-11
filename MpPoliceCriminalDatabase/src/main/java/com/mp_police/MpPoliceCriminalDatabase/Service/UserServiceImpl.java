package com.mp_police.MpPoliceCriminalDatabase.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mp_police.MpPoliceCriminalDatabase.dao.BidRepository;
import com.mp_police.MpPoliceCriminalDatabase.dao.CarRepository;
import com.mp_police.MpPoliceCriminalDatabase.dao.UserRepository;
import com.mp_police.MpPoliceCriminalDatabase.dto.Bid;
import com.mp_police.MpPoliceCriminalDatabase.dto.Car;
import com.mp_police.MpPoliceCriminalDatabase.dto.User;

@Service("service")
public class UserServiceImpl implements UserService {
	
	@Autowired 
	UserRepository userrepo;
	
	@Autowired 
	CarRepository carrepo;
	
	@Autowired 
	BidRepository bidrepo;
	
    User user;
	List <User> UserList = new ArrayList<User>();
	
	public static String uploadDirectory = System.getProperty("user.dir") + "/uploads";

	
	private PasswordEncoder passwordencoder;
	
	public UserServiceImpl(PasswordEncoder encoder) {
		// TODO Auto-generated constructor stub
		this.passwordencoder=encoder;
	}
	
	/* For adding data into the database */

	@Override
	public User addUser(User us) {
		// TODO Auto-generated method stub
		us.setPassword(passwordencoder.encode(us.getPassword()));
		return userrepo.save(us);
		
	}
	
	@Override
	public Car addCar(Car car) {
		return carrepo.save(car);
		
	}
	
	@Override
	public Car showCar(Long id ) {
		// TODO Auto-generated method stub
		Optional<Car> car = carrepo.findById(id);
		Car carsdetails = car.get();
		
		return carsdetails ;
	}
	
	@Override
	public User showUser(Long id ) {
		// TODO Auto-generated method stub
		Optional<User> user = userrepo.findById(id);
		User usersdetails = user.get();
		
		return usersdetails ;
	}
	
	@Override
	public Bid showBid(Long id ) {
		// TODO Auto-generated method stub
		Optional<Bid> bid = bidrepo.findById(id);
		Bid biddetails = bid.get();
		
		return biddetails ;
	}
	
	@Override
	public User showProfile(String name) {
		// TODO Auto-generated method stub
		user = userrepo.findByUserName(name);
		if(user==null) {
			System.out.println("User name is Invalid");
		}
		return user;
	}
	
	@Override
	public Car updateCar(Long id) {
		// TODO Auto-generated method stub 
		Optional<Car> carobj = carrepo.findById(id);
		Car car =carobj.get();
		return car;
	}
	
	@Override
	public User updateUser(Long id) {
		// TODO Auto-generated method stub 
		Optional<User> userobj = userrepo.findById(id);
		User user =userobj.get();
		return user;
	}

}
