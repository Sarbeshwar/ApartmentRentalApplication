package com.apartmentrental.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

import com.apartmentrental.entity.User;
import com.apartmentrental.dao.PropertyDao;
import com.apartmentrental.dao.UserDao;
import com.apartmentrental.dto.PropertiesDto;
import com.apartmentrental.dto.UserDto;
import com.apartmentrental.entity.Properties;


@Controller
public class MainController 
{
	@Autowired
	public UserDao daoObj;
	
	Logger logger=Logger.getLogger(MainController.class);
	public static final String OWNER="ownerIndexPage";
	
	@Autowired
	public PropertyDao propertyDao;
	
	@RequestMapping("/")
	public String getHomePage()
	{
		logger.info("Main Index Page");
		return "index";
	}
	
	@RequestMapping("/login")
	public String getLoginPage(Model model,@ModelAttribute("user") UserDto userDto)
	{
		logger.info("Login Page");
		return "login";
	}
	
	@RequestMapping("/verifyUser")
	public String verifyUser( @Valid @ModelAttribute("user") UserDto userDto, BindingResult br,HttpSession session)
	{
		User user=new User();
		BeanUtils.copyProperties(userDto,user);
		boolean valid = daoObj.validate(user.username,user.password);
		
		if(valid && user.status.equals("Owner") && !br.hasErrors())
		{
			session.setAttribute("name", user.getUsername());
			logger.info("Valid Login");
			return OWNER;
		}
		else if(valid && user.status.equals("Tenant") && !br.hasErrors())
		{
			logger.info("Valid Login");
			return "TenantView";
		}
		else
		{
			logger.info("Invalid Login");
			return "login";	
		}
	}
	
	@RequestMapping("/registration")
	public String getRegistrationPage()
	{
		logger.info("User Registration Page");
		return "registration";
	}
	
	@PostMapping("/saveUser")
	public String saveUser(HttpServletRequest req,Model model)
	{
		User user=new User();
		
		String name=req.getParameter("name");
		String status=req.getParameter("status");
		String dob=req.getParameter("dob");
		String contact=req.getParameter("contact");
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		
		user.setName(name);
		user.setStatus(status);
		user.setDob(dob);
		user.setNumber(contact);
		user.setUsername(username);
		user.setPassword(password);
		
		daoObj.createUser(user);
		logger.info("User Successfully Registered");
		return "index";
	}
	
	
	@RequestMapping("/availableDatabase")
	public String listUsers(Model model)
	{
		List<User> list=daoObj.getUsers();
		model.addAttribute("list",list);
		logger.info("Rendering Available Users");
		return "listUsers";
	}
	
	@RequestMapping("/ownerindexpage")
	public String ownerIndexPage()
	{
		logger.info("Owner Index Page");
		return OWNER;
	}
	
	@RequestMapping("/listproperty")
	public String listProperty(Model model)
	{
		logger.info("Rendering Property Listing Form");
		model.addAttribute("property",new Properties());
		return "listProperty";
	}
	
	@PostMapping("/processProperty")
	public String processProperty(Model model, @Valid @ModelAttribute("property") PropertiesDto propertiesDto,BindingResult br)
	{
		Properties property=new Properties();
		BeanUtils.copyProperties(propertiesDto, property);
		if(br.hasErrors())
		{
			logger.info("Unable To Register Property");
			return "listProperty";
		}
		else
		{
		propertyDao.createProperty(property);
		logger.info("Property Successfully Registered");
		return OWNER;
	}
	}
	
	@RequestMapping("/viewlistedproperty")
	public String listProperties(Model model)
	{
		logger.info("Viewing Properties Available in Database");
		return "showSearchedUserProperty";
	}
	
	@PostMapping("/search")
	public String searchProperty(HttpServletRequest req,Model model)
	{
		String name=req.getParameter("search");
		List<Properties> properties=propertyDao.getProperties(name);
		model.addAttribute("properties",properties);
		logger.info("Rendering Available Properties");
		return "viewlistedproperties";
	}
	
	@RequestMapping(value="/delete/{id}")
	public String deleteProperty(@PathVariable String id,Model m)
	{
		propertyDao.deleteProperty(id);
		logger.info("Deleting Property");
		return OWNER;
	}
	
	@RequestMapping(value="/edit/{id}")
	public String editProperty(@PathVariable String id,Model m,@ModelAttribute("update") PropertiesDto propertiesDto)
	{
		Properties properties=new Properties();
		BeanUtils.copyProperties(propertiesDto, properties);
		properties = propertyDao.getPropertyById(id);
		m.addAttribute("properties",properties);
		logger.info("Edit Listed Property");
		return "updateProperty";
		
	}
	
	@PostMapping(value="updateProperty")
	public String updateProperty(@ModelAttribute("update") PropertiesDto propertiesDto)
	{
		Properties properties=new Properties();
		BeanUtils.copyProperties(propertiesDto, properties);
		propertyDao.updateProperty(properties);
		logger.info("Property Update Successful");
		return OWNER;
	}
}
