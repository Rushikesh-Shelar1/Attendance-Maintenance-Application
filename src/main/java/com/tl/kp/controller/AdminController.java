package com.tl.kp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.tl.kp.dao.AdminServiceImpl;
import com.tl.kp.dao.AttendanceServiceImpl;
import com.tl.kp.model.Admin;
import com.tl.kp.model.User;
import com.tl.kp.repository.AdminRepository;





@Controller
@SessionAttributes({"attendanceList2"})
public class AdminController {
	
	@Autowired
	private AdminServiceImpl service;

	@Autowired
	private AdminRepository adminRepos;
	
	@Autowired
	private AttendanceServiceImpl attendService;
	
	@RequestMapping("/")
	public String openLoginPage(Model model) {
		model.addAttribute("UserObj",new User());
		return "loginPage";
	}

	@RequestMapping("/reg")
	public String userRegistration() {
		
		return"SignUp";
	}
	
	@RequestMapping(path="/signUp",method = RequestMethod.POST)
	@ResponseBody
	public String doRegistration(@ModelAttribute Admin admin,Model model) {
		System.out.println(admin);
		service.addAdmin(admin);
		model.addAttribute("userInfo", admin);
		
		return"<h3><font color='red'> welcome "+" "+"<a href='login'>Login from here</a></font></h3>";
	}
	
	@RequestMapping("/login")
	public String loginAfterReg(Model model) {

		model.addAttribute("UserObj",new User());
		return "loginPage";
		
	}
	
	@RequestMapping("/cartCheck")
	public String fetchAllUser(Model model) {
		List<User> user=service.getAllUser();
		model.addAttribute("listOfUser",user);
		return "cartPage";
		
	}
	
//    @RequestMapping("/attendance/{userId}")
//    public String showAttendance(@PathVariable long userId,Model model) {
//    	List<AttendanceDTI> attendances =(List<AttendanceDTI>) attendService.getAttendanceByUserId(userId);
//    	if(attendances!=null) {
//        model.addAttribute("attendanceList2", attendances);
//        System.out.println("attendance list is here");
//        
//        // Print each attendance in the list
//        for (AttendanceDTI attendance : attendances) {
//            System.out.println(attendance);
//        }
//        
//    	}
//    	return "viewByAdmin";
//    	
//    }
	

	
}
