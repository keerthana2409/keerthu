package com.devil.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.devil.dao.CartItemDao;
import com.devil.models.CartItem;

@Controller
public class HomeController {
	@Autowired
	private CartItemDao cartItemDao;
	public HomeController(){
		System.out.println("homeController bean is created..");
	}
	@RequestMapping("/home")
	public String homePage(@AuthenticationPrincipal Principal principal,HttpSession session){
        List<CartItem> cartItems=null;
    	if(principal!=null){
         cartItems=cartItemDao.getCartItems(principal.getName());
    	session.setAttribute("cartSize",cartItems.size());
    	
    	}
		return "home";
	}
    @RequestMapping("/aboutus")
    public String aboutUs(){
    	
    	return "aboutUs";
    }
    @RequestMapping("/login")
    public String login(){
    	return "login";
    }
    @RequestMapping("/loginerror")
    public String loginError(Model model){
    	model.addAttribute("loginError","Invalid Email/password");
    	return "login";
    }
    @RequestMapping("/logoutsuccess")
    public String logoutSuccess(Model model){
    	model.addAttribute("logoutSuccess","Loggedout Successfully");
    	return "login";
    }
}


