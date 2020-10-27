package com.apartmentrental.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.apartmentrental.entity.User;
import com.apartmentrental.dao.AdminDao;
import com.apartmentrental.dto.AdminDto;
import com.apartmentrental.dto.PropertiesDto;
import com.apartmentrental.dto.UserDto;
import com.apartmentrental.entity.Admin;
import com.apartmentrental.entity.Properties;

@Controller
public class AdminController {
	
	@Autowired
	private AdminDao adminDao;
	Logger logger=Logger.getLogger(AdminController.class);
	
	@RequestMapping("/AdminViewUsers")
	public String adminviewusers(Model m)
	
	{
		List<User> users = adminDao.getUsers();
		m.addAttribute("users", users);
		logger.info("Admin View All Users");
		return "AdminViewUsers";
	}
	@RequestMapping("/deleteUser/{number}")
	public RedirectView deleteUser(@PathVariable("number") String number,HttpServletRequest request)
	{	
		adminDao.deleteUser(number);
		RedirectView rv = new RedirectView();
		rv.setUrl(request.getContextPath()+"/AdminViewUsers");
		logger.info("Admin Delete User");
		return rv;
	}
	
	@RequestMapping("/editUser/{number}")
	public String editUserRequest(@PathVariable("number") String number, Model m)
	{	
		User user = adminDao.getUser(number);
		m.addAttribute("user",user);
		logger.info("Admin Edit User");
		return "edit_user_form";
	}
	
	@PostMapping(value="/editUserDetails")
	public RedirectView updateUserDetails(@ModelAttribute("user") UserDto userDto, HttpServletRequest request)
	{
		User user=new User();
		BeanUtils.copyProperties(userDto, user);
		adminDao.editUser(user);
		RedirectView rv = new RedirectView();
		rv.setUrl(request.getContextPath()+"/AdminViewUsers");
		logger.info("Admin Edit User Successful");
		return rv;
	}
	
	// Property Controller
	
	@RequestMapping("/AdminViewProperties")
	public String adminviewproperties(Model m)
	
	{
		List<Properties> properties = adminDao.getProperties();
		m.addAttribute("properties", properties);
		logger.info("Admin View All Properties");
		return "AdminViewProperties";
	}
	
	@RequestMapping("/deleteProperty/{id}")
	public RedirectView deleteProperty(@PathVariable("id") String id,HttpServletRequest request)
	{	
		adminDao.deleteProperty(id);
		RedirectView rv = new RedirectView();
		rv.setUrl(request.getContextPath()+"/AdminViewProperties");
		logger.info("Admin Delete Property");
		return rv;
	}
	
	@RequestMapping("/editProperty/{id}")
	public String editPropertyRequest(@PathVariable("id") String id, Model m)
	{	
		Properties property = adminDao.getProperty(id);
		m.addAttribute("property",property);
		logger.info("Admin Edit Property");
		return "edit_property_form";
	}
	
	@PostMapping(value="/editPropertyDetails")
	public RedirectView updatePropertyDetails(@ModelAttribute("property") PropertiesDto propertiesDto, HttpServletRequest request)
	{
		Properties property=new Properties();
		BeanUtils.copyProperties(propertiesDto, property);
		adminDao.editProperty(property);
		RedirectView rv = new RedirectView();
		rv.setUrl(request.getContextPath()+"/AdminViewProperties");
		logger.info("Admin Edit Property Successful");
		return rv;
	}
	
	@RequestMapping("/adminlogin")
	public String adminLogin(Model model,@ModelAttribute("admin") AdminDto adminDto)
	{
		logger.info("Admin Login Page");
		return "adminLogin";
	}
	
	@PostMapping("/verifyAdmin")
	public String verifyAdmin(@Valid @ModelAttribute("admin") AdminDto adminDto, BindingResult br)
	{
		Admin admin=new Admin();
		BeanUtils.copyProperties(adminDto, admin);
		boolean valid=adminDao.validate(admin.username,admin.password);
		
		if(valid && !br.hasErrors())
		{
			logger.info("Valid Admin Login");
			return "admin_home";
		}
		else
		{
			logger.info("Invalid Admin Login");
			return "adminLogin";
		}

	}
}
	
