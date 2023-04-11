package com.mp_police.MpPoliceCriminalDatabase.Controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.util.StringUtils;

import com.mp_police.MpPoliceCriminalDatabase.Service.AdminService;
import com.mp_police.MpPoliceCriminalDatabase.Service.CarService;
import com.mp_police.MpPoliceCriminalDatabase.Service.UserService;
import com.mp_police.MpPoliceCriminalDatabase.dao.CarRepository;
import com.mp_police.MpPoliceCriminalDatabase.dao.UserRepository;
import com.mp_police.MpPoliceCriminalDatabase.dto.Car;
import com.mp_police.MpPoliceCriminalDatabase.dto.User;

@Controller
public class CarController {

	@Autowired
	UserService service;
	
	@Autowired
	CarService carservice;

	@Autowired
	AdminService adminservice;

	@Autowired
	UserRepository userrepo;
	
	@Autowired
	CarRepository carrepo;
	
	public static String uploadDirectory = System.getProperty("user.dir")+"/src/main/resources/static/uploadedImage";

	Car car;
	List<Car> data = new ArrayList<Car>();

	/* for displaying cars registration page */
	@GetMapping(value = "/addcar")
	public String displayRegistrationPage(@ModelAttribute("addcar") Car car) {
		return "AddCar";

	}
	
//	/* For adding user data into the database */
//	@PostMapping(value = "/mycar")
//	public String addUserData(@ModelAttribute("addcar") Car car ,@RequestParam("img") MultipartFile multipartFile, RedirectAttributes ra, Principal principal) throws IOException {
//		if (car.getCarname().equals("")) {
//			System.out.println("Enter value in input fields");
//			return "AddCar";
//		} else {
//			final String currentUser = principal.getName();// for adding the details of logged in user 
//	        User user = service.showProfile(currentUser);
//	        
//	        car.setUserName(user.getUserName());
//	        car.setMobile(user.getMobile());
//	        
//			car.setStatus("active");
//			Car cardetails = service.addCar(car);
//			
//			String fileName = StringUtils.cleanPath(cardetails.getCid() +user.getName()+user.getUserId()+ multipartFile.getOriginalFilename());
//			
//			car.setImage(fileName);
//			service.addCar(car);
//			
//			Path uploadPath = Paths.get(uploadDirectory);
//			if (!Files.exists(uploadPath)) {
//	            Files.createDirectories(uploadPath);
//	        }
//	        try (InputStream inputStream = multipartFile.getInputStream()) {
//	            Path filePath = uploadPath.resolve(fileName);
//	            System.out.println(filePath.toFile().getAbsolutePath());
//	            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
//	        } catch (IOException e) {
//	            throw new IOException("Could not save uploaded file: " + fileName);
//	        }
//	        car.setPhotoImagePath("/uploadedImage/" + fileName);
//	        
//	        service.addCar(car);
//	        ra.addFlashAttribute("success_post", "Post has been saved successfully");
//	        return "redirect:/search";
//		}
//	}
//
//	/* for displaying the Appointment page */
//	@GetMapping(value = "bidAppointment/{searchid}")
//	public ModelAndView displayAppointmentPage(@PathVariable("searchid") Long id, @ModelAttribute("bid") Bid bid,
//			Principal principal) {
//
//		final String currentUser = principal.getName();
//		service.showProfile(currentUser);
//
//		Car cardata = service.showCar(id);// for finding the cid in request handle link in appointment page
//
//		return new ModelAndView("Appointmentform", "cardata", cardata);
//
//	}
//
//	/* For adding appointment data into the database */
//	@PostMapping(value = "/mybid/{searchid}")
//	public String addAppointmentData(@PathVariable("searchid") Long id, @ModelAttribute("bid") Bid bid,
//			Principal principal) {
//
//		final String currentUser = principal.getName();// for adding the details of logged in user
//		User user = service.showProfile(currentUser);
//
//		Car cardata = service.showCar(id); // adding the value of car in appointment table in database
//
//		bid.setCarname(cardata.getCarname());
//		bid.setCid(id);
//		bid.setRegistration(cardata.getRegistration());
//		bid.setModel(cardata.getModel());
//		bid.setMailid(user.getMailid());
//		bid.setUserId(user.getUserId());
//		bid.setUserName(currentUser);
//		bid.setStatus("setStatus");
//		adminservice.addBid(bid);
//		System.out.println(bid);
//		return "redirect:/search";
//	}
//	
//	
	/* For searching the data by different keyword */
	@RequestMapping("/search")
	public String viewSearch(Model model , @Param("keyword") String keyword) {
		List<Car> listCars = carservice.ListAll(keyword);
		System.out.println(listCars);
		model.addAttribute("cardata", listCars);
		model.addAttribute("keyword", keyword);
		
		return "Search";
		
	}

}
