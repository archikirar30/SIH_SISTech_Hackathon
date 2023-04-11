package com.mp_police.MpPoliceCriminalDatabase.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mp_police.MpPoliceCriminalDatabase.dao.PoliceOfficerRepository;
import com.mp_police.MpPoliceCriminalDatabase.dao.PoliceStationMasterRepository;
import com.mp_police.MpPoliceCriminalDatabase.dto.PoliceOfficer;
import com.mp_police.MpPoliceCriminalDatabase.dto.PoliceStationMaster;
import com.mp_police.MpPoliceCriminalDatabase.dto.User;

public class PoliceStationMasterService {

	@Autowired 
	PoliceStationMasterRepository policeStationMasterRepo;
	
	PoliceStationMaster policeOfficerMaster;
	List <PoliceStationMaster> PoliceOfficerMasterList = new ArrayList<PoliceStationMaster>();
	
	public static String uploadDirectory = System.getProperty("user.dir") + "/uploads";
	
	/* For adding data into the database */

	public PoliceStationMaster createPoliceOfficerMaster(PoliceStationMaster policeStationMaster) {
		// TODO Auto-generated method stub
		
		return policeStationMasterRepo.save(policeStationMaster);
		
	}
}
