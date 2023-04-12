package com.mp_police.MpPoliceCriminalDatabase.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mp_police.MpPoliceCriminalDatabase.dao.CarRepository;
import com.mp_police.MpPoliceCriminalDatabase.dao.CriminalRepository;
import com.mp_police.MpPoliceCriminalDatabase.dao.UserRepository;
import com.mp_police.MpPoliceCriminalDatabase.dto.Car;
import com.mp_police.MpPoliceCriminalDatabase.dto.Criminal;
import com.mp_police.MpPoliceCriminalDatabase.dto.User;

@Service
@Transactional
public class CriminalService {
	
	@Autowired 
	CriminalRepository criminalRepo;
	
	CriminalService criminalService;
	
	Criminal criminal;
	List <User> UserList = new ArrayList<User>();
	
	public static String uploadDirectory = System.getProperty("user.dir") + "/uploads";
	
	/* For adding data into the database */
	public Criminal createCriminal(Criminal criminal) {
		// TODO Auto-generated method stub
		return criminalRepo.save(criminal);
		
	}

	/* Show All Criminal */
	public List<Criminal> showAllCriminal() {
		return criminalRepo.findAll();
	}
	
	/* Find by Criminal Id */
	public Criminal showCriminalById(long id) {
		
		Optional<Criminal> criminal = criminalRepo.findById(id);
		Criminal criminaldetails = criminal.get();
		return criminaldetails;
	}
	
	public List<Criminal> ListAll (String keyword){
    	if(keyword != null) {
    		return criminalRepo.findAll(keyword);
    	}
    	return criminalRepo.findAll();
    }
	
	
	
}

