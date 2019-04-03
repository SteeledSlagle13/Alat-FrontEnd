package com.apexlegendsat.springmvc.frontend.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.apexlegendsat.springmvc.frontend.manager.UserManager;
import com.apexlegendsat.springmvc.frontend.view.UserView;

@Controller
@RequestMapping("login")
public class LoginController {

	private final int TIME_OUT_MINUTES = 10;
	private final int TIME_OUT_SECONDS = TIME_OUT_MINUTES * 60;

	static Logger logger = LogManager.getLogger(LoginController.class.getName());

	@Autowired
	private UserManager userService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getLoginPage(HttpServletRequest request) {
		logger.debug("getting login page");

		ModelAndView modelView;
		UserView sessionUser = (UserView) request.getSession().getAttribute("user");

		if (sessionUser == null) {
			logger.error("User is not logged in.");
			modelView = new ModelAndView("login/login", "message", "please login");
		} else {
			logger.debug("User is logged in.");
			modelView = new ModelAndView("weaponManager/weaponManager", "user", sessionUser);
		}

		return modelView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String checkLogin(@RequestParam("username") String username, @RequestParam("password") String password,
			HttpServletRequest request) {
		logger.debug("checking user login");

		UserView userView = null;
		userView = userService.findByName(username);

		logger.error(userView);

		if (userView.getPassword().equals(password)) {
			request.getSession().setAttribute("user", userView);
			request.getSession().setMaxInactiveInterval(TIME_OUT_SECONDS);
			return "redirect:/weaponmanager";
		} else {
			return "login/login";
		}

	}

}