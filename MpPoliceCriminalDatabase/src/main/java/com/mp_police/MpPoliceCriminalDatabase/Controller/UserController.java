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
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mp_police.MpPoliceCriminalDatabase.Service.UserService;
import com.mp_police.MpPoliceCriminalDatabase.dao.UserRepository;
import com.mp_police.MpPoliceCriminalDatabase.dto.User;

@Controller
public class UserController {
	
	@Autowired
	UserService service;
	
	@Autowired
	UserRepository userrepo;

	
	User user;
	List<User> data = new ArrayList<User>();
	
	public PasswordEncoder passwordencoder;
	
	/*For displaying home page */ 
    @GetMapping(value = "/")
	public String home()
	{
		return "index";
	}
       
    /*For Registering user*/
    @GetMapping(value = "/signup")
	public String displayRegistrationPage (@ModelAttribute("register") User us) {
		return "add";
		
	}
    
	/* For adding user data into the database */
    @PostMapping(value = "/myreg")
	public String addUserData(@ModelAttribute("register") User us ) {
    	us.setRole("USER");
    	service.addUser(us);
;
		return "redirect:/login";
	}
    
	/* For login into the portal */
    @GetMapping(value = "/login")
	public String displayLoginPage ()
    {
    	System.out.println("Login with your username and password");
		return "Login";
		
	}

	/* For printing error to unknown login or fail login */
    @GetMapping("/login_error")
    public String onLoginError(Model model) {
        String error = "Incorrect username or password. Try Again.";
        model.addAttribute("error_string", error);
        return "login";
    }    
    
    /* For updating the User that is posted in portal */
    @GetMapping(value="updateUser/{searchid}")
    public ModelAndView displayUserUpdate(@PathVariable("searchid")Long id) {
    	User userinfo = service.updateUser(id);
    	System.out.println(userinfo);
    	return new ModelAndView("UpdateUserProfile","searchdata" , userinfo);
    }
    
    @GetMapping(value = "/saveUpdateUserData")
    public String updateUserData(Principal principal,
    		@RequestParam("firstName") String firstName ,
    		@RequestParam("lastName") String lastName,
    		@RequestParam("rank") String rank,
    		@RequestParam("email") String email,
    		@RequestParam("phoneNumber") String  phoneNumber,
    		@RequestParam("emailVerified") Boolean emailVerified,
    		@RequestParam("city") String city,
    		@RequestParam("state") String  state,
    		@RequestParam("zipcode") int zipcode,
    		@RequestParam("aadharCardNumber") long  aadharCardNumber){
    	final String currentUser = principal.getName();
    	User userdetail = service.showProfile(currentUser);
    	
    	Long id = userdetail.getUsersId();
    	String userName = userdetail.getUserName();
    	
    	String role = userdetail.getRole();
    	String password = userdetail.getPassword();
    	User user = new User(id,userName,firstName,lastName,rank,email,password,phoneNumber,role,emailVerified,city,state,zipcode,aadharCardNumber);
    	service.addUser(user);
    	System.out.println(user);
    	return "redirect:/profile";
    	
    }
    /* For displaying user's profile */  
    @GetMapping(value = "/profile")
    public String displayProfilePage (Principal principal,Model model)
    {
    	final String currentUser = principal.getName();// for adding the details of logged in user 
    	User user = service.showProfile(currentUser); 
    	System.out.println("View your profile : "+user);
    	String username = user.getUserName();
    	
    	model.addAttribute("searchdata", user);

    	return "Profile";
    	
    }
    
    @GetMapping(value = "/saveLoggedUserData")
    public String updateLoggedUserData(Principal principal,
    		@RequestParam("firstName") String firstName ,
    		@RequestParam("lastName") String lastName,
    		@RequestParam("rank") String rank,
    		@RequestParam("email") String email,
    		@RequestParam("phoneNumber") String  phoneNumber,
    		@RequestParam("emailVerified") Boolean emailVerified,
    		@RequestParam("city") String city,
    		@RequestParam("state") String  state,
    		@RequestParam("zipcode") int zipcode,
    		@RequestParam("aadharCardNumber") long  aadharCardNumber){
    	final String currentUser = principal.getName();
    	User userdetail = service.showProfile(currentUser);
    	Long id = userdetail.getUsersId();
    	String userName = userdetail.getUserName();
    	String role = userdetail.getRole();
    	String password = userdetail.getPassword();
    	User user = new User(id,userName,firstName,lastName,rank,email,password,phoneNumber,role,emailVerified,city,state,zipcode,aadharCardNumber);
    	service.addUser(user);
    	System.out.println(user);
    	return "redirect:/profile";
    	
    }
//    /*For showing the User details*/
//    @GetMapping(value="/viewuser") 
//    public ModelAndView viewUsers(){
//    	
//    	List <User> data = userservice.showAllUser();
//    	System.out.println(data);
//    	return new ModelAndView("UserData","userdata",data);
//    }
    
//    
//	/* For displaying the contact form */
//    @GetMapping(value = "/contact")
//	public String displayContactPage ()
//    {
//    	System.out.println("Contact us for any query");
//		return "contact";
//		
//	}
//    
//    
//    
//	/* for displaying the admin side home page */ 
//    @GetMapping(value = "/admin")
//	public ModelAndView displayAdminHome()
//	{
//    	System.out.println("******Welcome to Abc Cars portal ******");
//    	System.out.println("  Find your cars , that is good for you  ");
//    	
//    	List<Car> data = adminservice.showAllCar();
//    	System.out.println(data);
//		return new ModelAndView("AdminDashboard", "cardata", data);
//	}	
//    
//    
//    
//	/* for displaying all the cars in the portal */ 
////    @GetMapping(value="/viewallbid") 
////	public ModelAndView viewBidding(){
////        
////		List <Bid> BidRecord = adminservice.showAllBidding();
////		System.out.println(BidRecord);
////		return new ModelAndView("BidData","biddata",BidRecord);
////	}
//    
//    /* For updating the Cars that is posted in portal */
//	 @GetMapping(value="updateCar/{searchid}")
//	    public ModelAndView displayUpdateCar(@PathVariable("searchid")Long id) {
//	    	Car carinfo = service.updateCar(id);
//	    	System.out.println(carinfo);
//	    	return new ModelAndView("UpdateCar","searchdata" , carinfo);
//	    }
//	    
//	    @GetMapping(value = "/saveUpdateData")
//	    public String updateData(@RequestParam("cid") Long cid,
//	    		@RequestParam("userName") String userName ,
//	    		@RequestParam("carname") String cname ,
//	    		@RequestParam("mobile") String mobile ,
//	    		@RequestParam("model") String model ,
//	    		@RequestParam("registration") String registration,
//	    		@RequestParam("state") String state,
//	    		@RequestParam("country") String country,
//	    		@RequestParam("price") String  price,
//	    		@RequestParam("color") String color){
//	    
//	    	Car car = service.showCar(cid);
//	    	
//	    	String Imagepath = car.getPhotoImagePath();
//	    	String image = car.getImage();
//	    	String usedNew = "used";
//	    	String status ="active";
//	        Car cars = new Car(cid,userName,cname,mobile,model,registration,state,country,price,image,color,usedNew,status,Imagepath);
//	        service.addCar(cars);
//	        System.out.println(cars);
//	        return "redirect:/";
//
//	    }
//	    
//	
//		/* For Deleting the Car by car id */  
//	    @GetMapping(value="delete/{searchid}")
//	    public String deleteCarById(@PathVariable("searchid")Long id) {
//	    	adminservice.deleteCar(id);
//	    	return "redirect:/admin";
//	    } 
//	    
//	    /* For Deleting the User by car id */  
//	    @GetMapping(value="deleteuser/{searchid}")
//	    public String deleteUserById(@PathVariable("searchid")Long id) {
//	    	adminservice.deleteUser(id);
//	    	return "redirect:/viewuser";
//	    } 
//	    
//	    /* For approving the bid appointment by car id */  
////	    @GetMapping(value="approve/{searchid}")
////	    public String approveBidById(@PathVariable("searchid")Long id) {
////	    	Bid bid = service.showBid(id);
////	    	if(bid.getStatus().equals("setStatus") || bid.getStatus().equals("reject")) {
////	    		bid.setStatus("approved");
////	    		adminservice.addBid(bid);
////	    		adminservice.sendApproveMail(bid.getMailid());
////	    		System.out.println("Mial is sent Successfully to mailid: "+bid.getMailid());
////	    		System.out.println("Bid appointment id "+bid.getBid() +" "+"is"+bid.getStatus());
////	    	
////	    	}
////	    	
////	    	return "redirect:/viewallbid";
////	    } 
////	    
////		/* for rejecting the bid booking appointmnet */
////	    @GetMapping(value="reject/{searchid}")
////	    public String rejectBidById(@PathVariable("searchid")Long id) {
////	    	Bid bid = service.showBid(id);
////	    	
////	    	if (bid.getStatus().equals("approved") || bid.getStatus().equals("setStatus")) {
////	    		bid.setStatus("reject");
////	    		adminservice.addBid(bid);
////	    		adminservice.sendRejectMail(bid.getMailid());
////	    		System.out.println("Mial is sent Successfully to mailid: "+bid.getMailid());
////	    		System.out.println("Bid appointment id "+bid.getBid() +" "+"is"+bid.getStatus());
////	    		
////	    	}
////	    	
////	    	return "redirect:/viewallbid";
////	    } 
////	    
//	    /* For Deactivating the Car by car id */  
//	    @GetMapping(value="deactivate/{searchid}")
//	    public String deactivateCarById(@PathVariable("searchid")Long id ) {
//	    	
//	    	Car car = service.showCar(id);
//	    	if(car.getStatus().equals("active")) {
//	    		car.setStatus("deactive");
//	    		service.addCar(car);
//	    		System.out.println("changed status into :"+ car.getStatus());
//	    		
//	    	}
//	    	else if(car.getStatus().equals("deactive")) {
//	    		car.setStatus("active");
//	    		service.addCar(car);
//	    		System.out.println("changed status into :"+ car.getStatus());
//	    		
//	    	}
//	 
//	    	return "redirect:/admin";
//	    } 
//	    
//	    
//	    /* For Making User as Admin */  
//	    @GetMapping(value="assign/{searchid}")
//	    public String MakeUserAdminById(@PathVariable("searchid")Long id ) {
//	    	
//	    	User user = service.showUser(id);
//	    	if(user.getRole().equals("USER")) {
//	    		user.setRole("ADMIN");
//	    		service.addUser(user);
//	    		System.out.println("changed role  into :"+user.getRole());
//	    		
//	    	}
//	    	else if(user.getRole().equals("ADMIN")) {
//	    		user.setRole("USER");
//	    		service.addUser(user);
//	    		System.out.println("changed role into :"+ user.getRole());
//	    		
//	    	}
//	    	
//	    	return "redirect:/viewuser";
//	    } 
	    

}
