package com.apexlegendsat.springmvc.frontend.controller;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apexlegendsat.springmvc.frontend.manager.UserManager;
import com.apexlegendsat.springmvc.frontend.view.UserView;

@RestController
@RequestMapping(value = "user")
public class RestUserController {

	static Logger logger = LogManager.getLogger(RestUserController.class.getName());

	@Autowired
	private UserManager userService;

	/**
	 * This method is used to grab user information from the database. User objects
	 * are converted inorder to hide data that does not need to be seen
	 * 
	 * @return list of users in database in JSON format
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<List<UserView>> listAllUsers() {
		List<UserView> userViews = null;
		userViews = userService.findAllUsers();

		logger.debug("should have users.");
		if (userViews.isEmpty()) {
			return new ResponseEntity<List<UserView>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<List<UserView>>(userViews, HttpStatus.OK);
	}

	/**
	 * Grabs user data from the database then converts the entity to a viewable user
	 * object
	 * 
	 * @param id - user id
	 * @return user object without sensitive data or NO_CONTENT when user is not
	 *         found
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<UserView> getUser(@PathVariable("id") int id) {

		logger.debug("Fetching user with id : " + id);
		UserView userView = null;
		userView = userService.findById(id);

		if (userView == null) {
			logger.error("user with id : " + id + " not found");
			return new ResponseEntity<UserView>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<UserView>(userView, HttpStatus.OK);
	}

	/**
	 * sends new user data to database user data is not converted to a UserView
	 * object because an Entity object is not returned
	 * 
	 * @param user - user to create
	 * @return CREATED on Success | CONFLICT if username is in the Database
	 */
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<Void> createUser(@RequestBody UserView user) {
		logger.debug("creating user " + user);

		if (userService.doesUserExist(user)) {
			logger.error("A User with name " + user.getUsername() + " already exist");
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		userService.saveUser(user);

		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	/**
	 * update the username, email, and address in the database
	 * 
	 * @param id   - user id
	 * @param user - user viewable object
	 * @return NO_CONTENT if user cannot be found | OK if update was successful
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public ResponseEntity<UserView> updateUser(@PathVariable("id") int id, @RequestBody UserView user) {
		logger.debug("updating user " + id);

		UserView currentUser = null;
		currentUser = userService.findById(id);

		if (currentUser == null) {
			logger.debug("user with id " + id + " not found");
			return new ResponseEntity<UserView>(HttpStatus.INTERNAL_SERVER_ERROR);// 500
		}

		currentUser.setUsername(user.getUsername());
		currentUser.setAddress(user.getAddress());
		currentUser.setEmail(user.getEmail());

		userService.updateUser(currentUser);

		return new ResponseEntity<UserView>(currentUser, HttpStatus.OK);
	}

	/**
	 * delete the user from the database and local
	 * 
	 * @param id - user id
	 * @return NO_CONTENT
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteUser(@PathVariable("id") int id) {
		logger.debug("Fetching & Deleting User with id " + id);

		UserView user = null;
		user = userService.findById(id);
		if (user == null) {
			logger.error("Unable to delete. User with id " + id + " not found");
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		userService.deleteUserById(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}