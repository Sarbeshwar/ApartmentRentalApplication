package java_files;

import java.util.ArrayList;
import java.util.List;


import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class TenantController {

	@Autowired
	public userDao DAO_obj;
	
	@RequestMapping("/tView")
	public String tenantView() {
		return "TenantView";
	}
	
	@RequestMapping("/tViewAllProp")
	public String viewProperty(Model model) {
		List<properties> theProp = DAO_obj.getProperties(); 
		model.addAttribute("list", theProp);
		return "ViewProperty";
	}
	
	@RequestMapping("/search")
	public String tSearch() {
		return "propSearch";
	}
	
	@RequestMapping("/tSearch")
    public String viewHomePage(Model model, @RequestParam("keyword") String keyword) {
        List<properties> lists = DAO_obj.search(keyword);
        model.addAttribute("list", lists);
         
        return "propSearch";
    }
	
	@RequestMapping(value = "/addToFavo/{id}", method = RequestMethod.GET)
	 public String ordernow(@PathVariable(value = "id") String id, ModelMap mm, HttpSession session) {

	  if (session.getAttribute("cart") == null) {
	   List<Items> cart = new ArrayList<Items>();
	   cart.add(new Items(this.DAO_obj.find(id), 1));
	   session.setAttribute("cart", cart);
	  } else {
	   List<Items> cart = (List<Items>) session.getAttribute("cart");

	   // using method isExisting here
	   String index = isExisting(id, session);
	   if (index == "-1")
	    cart.add(new Items(this.DAO_obj.find(id), 1));

	   session.setAttribute("cart", cart);
	  }

	  return "cart"; // page name
	 }

	private String isExisting(String id, HttpSession session) {
		 List<Items> cart = (List<Items>) session.getAttribute("cart");

		  for (int i = 0; i < cart.size(); i++)

		   if (cart.get(i).getProp().getId() == id)
		    return "i";

		  return "-1";
	}


}
