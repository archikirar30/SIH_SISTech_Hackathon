package com.mp_police.MpPoliceCriminalDatabase.Service;

import com.mp_police.MpPoliceCriminalDatabase.dto.User;

public interface UserService {

	public User addUser(User user); // adding the user details to the database
	public User showProfile(String name);//showing user profile
	public User updateUser(Long id); //for updating the details of user

}
