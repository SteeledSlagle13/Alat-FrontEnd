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
public class SignoutController {

	private static Logger logger = LogManager.getLogger(SignoutController.class.getName());

	@RequestMapping(value = { "/signout" }, method = RequestMethod.GET)
	public ModelAndView userSignout(HttpServletRequest request) {

		ModelAndView modelView;

		logger.debug("Checking if user was logged in.");
		UserView sessionUser = (UserView) request.getSession().getAttribute("user");

		if (sessionUser == null) {
			logger.debug("no user has been logged in.");
			modelView = new ModelAndView("login/login");
		} else {
			logger.debug("a user was logged in deleting session attribute");
			request.getSession().setAttribute("user", null);
			modelView = new ModelAndView("redirect:/");
		}
		return modelView;
	}
}
