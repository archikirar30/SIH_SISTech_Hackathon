package com.mp_police.MpPoliceCriminalDatabase.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

import com.mp_police.MpPoliceCriminalDatabase.Service.CriminalService;
import com.mp_police.MpPoliceCriminalDatabase.dao.CriminalRepository;
import com.mp_police.MpPoliceCriminalDatabase.dto.Criminal;
import com.mp_police.MpPoliceCriminalDatabase.dto.User;

@Controller
public class CriminalController {
	
	@Autowired
	CriminalRepository criminalRepo;
	
	CriminalService criminalService;
	
	
	Criminal criminal;
	List<Criminal> criminalData = new ArrayList<Criminal>();
	//Add Criminal 
	@GetMapping(value="/addCriminal")
	public String addCriminal(@ModelAttribute("addCriminal") Criminal criminal) {
		System.out.println("Add Criminal Database");
		return "AddCriminal";
	}
	
	 @PostMapping(value = "/addCriminalPost")
		public String addCriminalData(@ModelAttribute("addCriminal") Criminal criminal ) {
		 criminalService.createCriminal(criminal);
	    	
			System.out.println(criminal.toString());
			System.out.println("Details of "+ criminal);
			return "redirect:/addCriminal";
	  }
	 
		/* Show all Criminal Database */
		@GetMapping(value="/viewcriminalDetails") 
	    public ModelAndView viewUsers(){
	    	
	    	List <Criminal> criminalsdata = criminalService.showAllCriminal();
	    	System.out.println(criminalsdata);
	    	return new ModelAndView("Criminalsdata","criminalsdataset",criminalsdata);
	    }
}

