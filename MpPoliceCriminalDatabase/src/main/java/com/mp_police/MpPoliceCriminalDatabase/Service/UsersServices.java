package com.mp_police.MpPoliceCriminalDatabase.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mp_police.MpPoliceCriminalDatabase.dao.UserRepository;
import com.mp_police.MpPoliceCriminalDatabase.dto.User;

public class UsersServices {
	@Autowired 
	UserRepository userRepo;
	
	User user;
	List <User> UserList = new ArrayList<User>();
	
	public static String uploadDirectory = System.getProperty("user.dir") + "/uploads";
	
	/* For adding data into the database */

	public User createUser(User user) {
		// TODO Auto-generated method stub
		
		return userRepo.save(user);
		
	}
}
