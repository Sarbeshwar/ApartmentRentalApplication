package com.apartmentrental.controller;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.apartmentrental.dao.UserDao;
import com.apartmentrental.entity.Properties;

@Controller
public class TenantController {

	@Autowired
	public UserDao daoObj;

	Logger logger = Logger.getLogger(TenantController.class);

	@RequestMapping("/tView")
	public String tenantView() {
		logger.info("Tenant Index Page");
		return "TenantView";
	}

	@RequestMapping("/tViewAllProp")
	public String viewProperty(Model model) {
		List<Properties> theProp = daoObj.getProperties();
		model.addAttribute("list", theProp);
		logger.info("Tenant View All Properties");
		return "ViewProperty";
	}

	@RequestMapping("/search")
	public String tSearch() {
		logger.info("Tenant Search For Property");
		return "propSearch";
	}

	@RequestMapping("/tSearch")
	public String viewHomePage(Model model, @RequestParam( value="keyword") String keyword) {
		List<Properties> lists = daoObj.search(keyword);
		model.addAttribute("list", lists);
		logger.info("Rendering Tenant Search Results");
		return "propSearch";
	}

}
