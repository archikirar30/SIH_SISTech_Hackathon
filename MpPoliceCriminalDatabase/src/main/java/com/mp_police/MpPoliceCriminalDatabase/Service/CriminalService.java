package com.mp_police.MpPoliceCriminalDatabase.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mp_police.MpPoliceCriminalDatabase.dao.CriminalRepository;
import com.mp_police.MpPoliceCriminalDatabase.dao.UserRepository;
import com.mp_police.MpPoliceCriminalDatabase.dto.Criminal;
import com.mp_police.MpPoliceCriminalDatabase.dto.User;

public class CriminalService {
	
	@Autowired 
	CriminalRepository criminalRepo;
	
	Criminal criminal;
	List <User> UserList = new ArrayList<User>();
	
	public static String uploadDirectory = System.getProperty("user.dir") + "/uploads";
	
	/* For adding data into the database */

	public Criminal createCriminal(Criminal criminal) {
		// TODO Auto-generated method stub
		return criminalRepo.save(criminal);
		
	}
}

