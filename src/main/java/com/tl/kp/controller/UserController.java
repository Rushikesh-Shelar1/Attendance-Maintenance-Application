package com.tl.kp.controller;





import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.SessionAttributes;

import com.tl.kp.dao.AttendanceServiceImpl;
import com.tl.kp.dao.UserServiceImpl;
import com.tl.kp.model.AttendanceDTI;
import com.tl.kp.model.User;

import jakarta.servlet.http.HttpSession;


@Controller
@SessionAttributes({"loginInfo","logoutInfo","attendanceList","currentUser"})
public class UserController {

	@Autowired
	private UserServiceImpl service;
	
	@Autowired
	private AttendanceServiceImpl attendanceService;
	
		
	@RequestMapping(path="/login" , method=RequestMethod.POST)
	public String getLogin( @ModelAttribute("UserObj")
	User user, Model model) 
	{

	User user1=	service.getLogin(user.getUserName(), user.getUserPassword());

	   AttendanceDTI dto=new AttendanceDTI();
	   dto.setLocalDate(LocalDate.now());
	   dto.setLocalTimeIN(LocalTime.now());
	   dto.setUser(user1);
	   
	   model.addAttribute("currentUser", user1);  // Store user object in session
	   
	model.addAttribute("loginInfo", dto);
	//System.out.println(dto.getLocalDate());
	      if(user1.getUserType().equalsIgnoreCase("Admin"))
	      {
	    	  return "AdminTaskPage";
	      }
	      else if(user1.getUserType().equalsIgnoreCase("User"))
	      {
	    	  return "HomePage";
	      }
		
	    return "errorPage";	  
	}
	
	
	@RequestMapping("/View_Report/{userId}")
	public String ViewReport(@PathVariable long userId ,HttpSession session,Model model) {
		// List<AttendanceDTI> list=  attendanceService.viewReport();
		 List<AttendanceDTI> list2= attendanceService.getAttendanceByUserId(userId);
		 model.addAttribute("attendanceList", list2);  
		return "viewReport";
		
	}
	
	@RequestMapping(path="/saveDateTime", method=RequestMethod.POST)
	public String addTimeDate(@RequestParam("localDate") String localDate,
            @RequestParam("localTime") String localTime,Model model,HttpSession session) {
		 LocalDate date = LocalDate.parse(localDate);
	      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss a");
	     LocalTime time = LocalTime.parse(localTime, formatter);
	     AttendanceDTI dto = new AttendanceDTI();
	     User ut=new User();
	     dto.setLocalDate(date);
	     dto.setLocalTimeIN(time);
//	     dto.setUser(dto.getUser());
	     
	     // Retrieve the current user from session
	     User currentUser = (User) session.getAttribute("currentUser");
	     if (currentUser != null) {
	         dto.setUser(currentUser);
	     }
	     
	     
	     model.addAttribute("loginInfo", dto);
	 	System.out.println(dto.getLocalDate());
//	 	System.out.println(ut.getUserID());
		return "logOut";
	}
	
	@RequestMapping(path="/saveLogoutTime", method=RequestMethod.POST)
	public String addTimeDateOut(Model model,HttpSession session) {
		 AttendanceDTI  dto=(AttendanceDTI) session.getAttribute("loginInfo");
//		dto.getLocalTimeIN();
//		dto.getLocalDate();
		 
		 
		dto.setLocalTimeOUT(LocalTime.now());
		model.addAttribute("logoutInfo", dto);
		attendanceService.addCart(dto);
		return "HomePage";
		
	}

	
	
}
	

