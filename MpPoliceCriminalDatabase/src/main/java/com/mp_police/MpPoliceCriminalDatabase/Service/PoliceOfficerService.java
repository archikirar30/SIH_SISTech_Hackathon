package com.mp_police.MpPoliceCriminalDatabase.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mp_police.MpPoliceCriminalDatabase.dao.PoliceOfficerRepository;
import com.mp_police.MpPoliceCriminalDatabase.dto.PoliceOfficer;
import com.mp_police.MpPoliceCriminalDatabase.dto.User;

public class PoliceOfficerService {
	@Autowired 
	PoliceOfficerRepository policeOfficerRepo;
	
	PoliceOfficer policeOfficer;
	List <PoliceOfficer> PoliceOfficerList = new ArrayList<PoliceOfficer>();
	
	public static String uploadDirectory = System.getProperty("user.dir") + "/uploads";
	
	/* For adding data into the database */

	public PoliceOfficer createPoliceOfficer(PoliceOfficer policeOfficer) {
		// TODO Auto-generated method stub
		
		return policeOfficerRepo.save(policeOfficer);
		
	}
}
