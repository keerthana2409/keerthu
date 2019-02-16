package com.devil.frontend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class frontendController {

	@RequestMapping(value="/aboutus", method = RequestMethod.GET)
	public String aboutUsHandler()
	{
		return "aboutUs";
	}
	@RequestMapping(value="/")
	public String HomeHandler()
	{
		return "home";
	}

}
