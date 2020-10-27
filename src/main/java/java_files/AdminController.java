package java_files;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import java_files.User;

@Controller
public class AdminController {
	
	@Autowired
	private AdminDao AdminDao;
	
	@RequestMapping("/Admin")
	public String adminHome()
	{
		System.out.println("Admin Home Page");
		
		return "admin_home";
	}
	
	@RequestMapping("/AdminViewUsers")
	public String adminviewusers(Model m)
	
	{
		List<User> users = AdminDao.getUsers();
		m.addAttribute("users", users);
		System.out.println("All users are"+ users);
		return "AdminViewUsers";
	}
	@RequestMapping("/deleteUser/{number}")
	public RedirectView deleteUser(@PathVariable("number") String number,HttpServletRequest request)
	{	
		System.out.println("Deleting");
		AdminDao.deleteUser(number);
		RedirectView rv = new RedirectView();
		rv.setUrl(request.getContextPath()+"/AdminViewUsers");
		return rv;
	}
	
	@RequestMapping("/editUser/{number}")
	public String editUserRequest(@PathVariable("number") String number, Model m)
	{	
		System.out.println("Accessing the edit details form");
		User user = AdminDao.getUser(number);
		System.out.println(user);
		m.addAttribute("user",user);
		return "edit_user_form";
	}
	
	@RequestMapping(value="/editUserDetails",method=RequestMethod.POST)
	public RedirectView updateUserDetails(@ModelAttribute("user") User user, HttpServletRequest request)
	{
		System.out.println("Submitting the Details");
		AdminDao.editUser(user);
		RedirectView rv = new RedirectView();
		rv.setUrl(request.getContextPath()+"/AdminViewUsers");
		return rv;
	}
	
	// Property Controller
	
	@RequestMapping("/AdminViewProperties")
	public String adminviewproperties(Model m)
	
	{
		List<properties> properties = AdminDao.getProperties();
		m.addAttribute("properties", properties);
		System.out.println("All users are"+ properties);
		return "AdminViewProperties";
	}
	
	@RequestMapping("/deleteProperty/{id}")
	public RedirectView deleteProperty(@PathVariable("id") String id,HttpServletRequest request)
	{	
		System.out.println("Deleting Details");
		AdminDao.deleteProperty(id);
		RedirectView rv = new RedirectView();
		rv.setUrl(request.getContextPath()+"/AdminViewProperties");
		return rv;
	}
	
	@RequestMapping("/editProperty/{id}")
	public String editPropertyRequest(@PathVariable("id") String id, Model m)
	{	
		System.out.println("Accessing the edit details form");
		properties property = AdminDao.getProperty(id);
		System.out.println(property);
		m.addAttribute("property",property);
		return "edit_property_form";
	}
	
	@RequestMapping(value="/editPropertyDetails",method=RequestMethod.POST)
	public RedirectView updatePropertyDetails(@ModelAttribute("property") properties property, HttpServletRequest request)
	{
		System.out.println("Submitting the Details");
		AdminDao.editProperty(property);
		RedirectView rv = new RedirectView();
		rv.setUrl(request.getContextPath()+"/AdminViewProperties");
		return rv;
	}
}
	
