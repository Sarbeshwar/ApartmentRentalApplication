package java_files;

import java.util.List;	

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class controller 
{
	@Autowired
	public userDao DAO_obj;
	
	@RequestMapping("/")
	public String getHomePage()
	{
		return "index";
	}
	
	
	
	@RequestMapping("/login")
	public String getLoginPage()
	{
		return "login";
	}
	
	@RequestMapping("/registration")
	public String getRegistrationPage()
	{
		return "registration";
	}
	
	@PostMapping("/saveUser")
	public String saveUser(HttpServletRequest req)
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
		
		DAO_obj.createUser(user);
		return "index";
	}
	
	
	@RequestMapping("/availableDatabase")
	public String listUsers(Model model)
	{
		List<User> list=DAO_obj.getUsers();
		model.addAttribute("list",list);
		return "listUsers";
	}
	
}
