package com.apexlegendsat.springmvc.frontend.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.apexlegendsat.springmvc.frontend.view.UserView;

@Controller
public class PageController {
	
	static Logger logger = LogManager.getLogger(PageController.class.getName());

	@RequestMapping(value = { "/legends" }, method = RequestMethod.GET)
	public String getLegendsPage() {
		logger.debug("getting legends page");
		return "legends/legends";
	}

	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public ModelAndView getLoginPage(HttpServletRequest request) {
		logger.debug("getting login page");
		
		ModelAndView modelView;
		UserView sessionUser = (UserView) request.getSession().getAttribute("user");
		
		if(sessionUser == null) {
			logger.error("User is not logged in.");
			modelView = new ModelAndView("login/login", "message", "please login");
		} else {
			logger.debug("User is logged in.");
			modelView = new ModelAndView("weaponManager/weaponManager", "user", sessionUser);
		}
		
		return modelView;
	}
	
	@RequestMapping(value = { "/signout" }, method = RequestMethod.GET)
	public ModelAndView userSignout(HttpServletRequest request) {
		
		ModelAndView modelView;
		
		logger.debug("Checking if user was logged in.");
		UserView sessionUser = (UserView) request.getSession().getAttribute("user");
		
		if(sessionUser == null) {
			logger.debug("no user has been logged in.");
			modelView = new ModelAndView("login/login");
		} else {
			logger.debug("a user was logged in deleting session attribute");
			request.getSession().setAttribute("user", null);
			modelView = new ModelAndView("redirect:/");
		}
		
		return modelView;
	}

	@RequestMapping(value = { "/signup" }, method = RequestMethod.GET)
	public String getSignupPage() {
		logger.debug("getting sign up page");
		return "signup/signup";
	}

	@RequestMapping(value = { "/weaponmanager" }, method = RequestMethod.GET)
	public ModelAndView getWeaponManagerPage(HttpServletRequest request) {
		
		UserView sessionUser = (UserView) request.getSession().getAttribute("user");
		
		ModelAndView modelView;
		
		if(sessionUser == null) {
			logger.error("User attempted to access memberonly page");
			modelView = new ModelAndView("redirect:/login", "Error", "LOGIN_ACCESS_ONLY");
		} else {
			logger.debug("getting weapon manager page");
			logger.debug(sessionUser);
			modelView = new ModelAndView("weaponManager/weaponManager", "user", sessionUser);
		}
		
		return modelView;
	}

	@RequestMapping(value = { "/weapons" }, method = RequestMethod.GET)
	public String getWeaponsPage() {
		logger.debug("getting weapons page");
		return "weaponCompare/weapons";
	}
}