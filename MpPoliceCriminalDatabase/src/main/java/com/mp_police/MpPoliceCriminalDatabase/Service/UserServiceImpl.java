package com.mp_police.MpPoliceCriminalDatabase.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.mp_police.MpPoliceCriminalDatabase.dao.UserRepository;
import com.mp_police.MpPoliceCriminalDatabase.dto.User;

@Service("service")
public class UserServiceImpl implements UserService {
	
	@Autowired 
	UserRepository userrepo;
	
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
	public User addUser(User user) {
		// TODO Auto-generated method stub
		user.setPassword(passwordencoder.encode(user.getPassword()));
		return userrepo.save(user);
		
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
	public User updateUser(Long id) {
		// TODO Auto-generated method stub 
		Optional<User> userobj = userrepo.findById(id);
		User user =userobj.get();
		return user;
	}

}
