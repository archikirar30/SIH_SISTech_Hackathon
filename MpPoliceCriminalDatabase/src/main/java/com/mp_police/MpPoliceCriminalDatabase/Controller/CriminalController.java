package com.mp_police.MpPoliceCriminalDatabase.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import com.mp_police.MpPoliceCriminalDatabase.Service.CriminalService;
import com.mp_police.MpPoliceCriminalDatabase.Service.UserService;
import com.mp_police.MpPoliceCriminalDatabase.dao.CriminalRepository;
import com.mp_police.MpPoliceCriminalDatabase.dao.UserRepository;
import com.mp_police.MpPoliceCriminalDatabase.dto.Criminal;
import com.mp_police.MpPoliceCriminalDatabase.dto.User;

@Controller
public class CriminalController {
	
	@Autowired
	CriminalRepository criminalRepo;
	
	@Autowired
	UserRepository userRepo;
	
	UserService userservice;
	
	CriminalService criminalService;
	
	public static String uploadDirectory = System.getProperty("criminal.dir")+"/src/main/resources/static/uploadedImage";
	
	Criminal criminal;
	List<Criminal> criminalData = new ArrayList<Criminal>();
	//Add Criminal 
	@GetMapping(value="/addCriminal")
	public String addCriminal(@ModelAttribute("addCriminal") Criminal criminal) {
		System.out.println("Add Criminal Database");
		return "AddCriminal";
	}
	
	 @PostMapping(value = "/addCriminalPost")
		public String addCriminalData(@ModelAttribute("addCriminal") Criminal criminal, Principal principal, MultipartFile multipartFile, RedirectAttributes ra) throws IOException {
		 final String currentUser = principal.getName();// for adding the details of logged in user 
	     User user = userservice.showProfile(currentUser);
		 Criminal criminaldetails = criminalService.addCriminal(criminal);
		 String fileName = StringUtils.cleanPath(criminaldetails.getCriminalId() +criminaldetails.getCriminalName()+user.getUsersId()+ multipartFile.getOriginalFilename());
			
			criminal.setCriminalImageUrl(fileName);
			criminalService.addCriminal(criminal);
			
			Path uploadPath = Paths.get(uploadDirectory);
			if (!Files.exists(uploadPath)) {
	            Files.createDirectories(uploadPath);
	        }
	        try (InputStream inputStream = multipartFile.getInputStream()) {
	            Path filePath = uploadPath.resolve(fileName);
	            System.out.println(filePath.toFile().getAbsolutePath());
	            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
	        } catch (IOException e) {
	            throw new IOException("Could not save uploaded file: " + fileName);
	        }
	        criminal.setPath("/uploadedImage/" + fileName);
	        
	        criminalService.addCriminal(criminal);
	        ra.addFlashAttribute("success_post", "Post has been saved successfully");
	        return "redirect:/search";
		}
	 
		@RequestMapping("/search")
		public String viewSearch(Model model , @Param("keyword") String keyword) {
			List<Criminal> listCriminal = criminalService.SearchByKeyword(keyword);
			System.out.println(listCriminal);
			model.addAttribute("criminalData", listCriminal);
			model.addAttribute("keyword", keyword);
			
			return "Search";
			
		}
		
		/* For Deleting the Car by car id */  
	    @GetMapping(value="delete/{searchid}")
	    public String deleteCarById(@PathVariable("searchid")Long id) {
	    	criminalService.deleteCriminal(id);
	    	return "redirect:/admin";
	    }
	 
//		/* Show all Criminal Database */
//		@GetMapping(value="/viewcriminalDetails") 
//	    public ModelAndView viewUsers(){
//	    	
//	    	List <Criminal> criminalsdata = criminalService.();
//	    	System.out.println(criminalsdata);
//	    	return new ModelAndView("Criminalsdata","criminalsdataset",criminalsdata);
//	    }
}

