package com.mp_police.MpPoliceCriminalDatabase.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import com.mp_police.MpPoliceCriminalDatabase.Service.SuperAdminService;
import com.mp_police.MpPoliceCriminalDatabase.dao.SuperAdminRepository;
import com.mp_police.MpPoliceCriminalDatabase.dto.Criminal;
import com.mp_police.MpPoliceCriminalDatabase.dto.SuperAdmin;
import com.mp_police.MpPoliceCriminalDatabase.dto.User;

public class SuperAdminController {
	
	@Autowired
	SuperAdminRepository superAdminRepo;
	
	@Autowired
	SuperAdminService superAdminService;
	
	SuperAdmin superAdmin;
	List<SuperAdmin> superAdminData = new ArrayList<SuperAdmin>();
	
	/* Super Admin Dashboard */
	@GetMapping(value = "/superadmin")
	public String showAdminDashboard()
	{
		return "HomePage";
	}
	
	/* Create Criminal */
	 @GetMapping(value = "/addCriminal")
     public String displayRegistrationPage (@ModelAttribute("addCriminal") Criminal criminal) {
			return "AddCriminal";
			
	}
	 
	/* Post mapping for adding criminal */
//	    @PostMapping(value = "/postDataCriminal")
//		public String addUserData(@ModelAttribute("register") Criminal criminal ) {
//	    	if (criminal.getName().equals("") ||us.getUserName().equals("")|| us.getPassword().equals("")|| us.getMailid().equals("")||us.getMobile().equals("")||us.getCountry().equals("")||us.getState().equals("")||us.getGender().equals("")) {
//	    		System.out.println("Enter value in input fields");
//	    		return "registration";
//	    	}else {
//	    	criminal.setRole("USER");
//	    	superAdminService.addCriminal(criminal);
//	    	
//	    	System.out.println("User data is added to the database");
//			System.out.println("New user register with name: "+us.getName());
//			System.out.println("Details of "+ us);
//			return "redirect:/login";
//	    	}
//		}
}
