package com.mp_police.MpPoliceCriminalDatabase.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.mp_police.MpPoliceCriminalDatabase.dao.CarRepository;
import com.mp_police.MpPoliceCriminalDatabase.dao.SuperAdminRepository;
import com.mp_police.MpPoliceCriminalDatabase.dto.Criminal;
import com.mp_police.MpPoliceCriminalDatabase.dto.SuperAdmin;
import com.mp_police.MpPoliceCriminalDatabase.dto.User;

public class SuperAdminService {

	@Autowired 
	SuperAdminRepository superAdminRepo;
	
	SuperAdmin superAdmin;
	List <SuperAdmin> SuperAdminList = new ArrayList<SuperAdmin>();
	
	public static String uploadDirectory = System.getProperty("user.dir") + "/uploads";
	
	/* For adding data into the database */

	public SuperAdmin addSuperAdmin(SuperAdmin superAdmin) {
		// TODO Auto-generated method stub
		
		return superAdminRepo.save(superAdmin);
		
	}

}
