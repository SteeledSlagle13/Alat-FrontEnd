package com.apexlegendsat.springmvc.frontend.manager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.apexlegendsat.springmvc.frontend.constants.AlatConstants;
import com.apexlegendsat.springmvc.frontend.view.UserView;

@Service
@Transactional
public class UserManagerImpl implements UserManager {

	static Logger logger = LogManager.getLogger(UserManagerImpl.class.getName());

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public void deleteUserById(int id) {
		restTemplate.delete(AlatConstants.USER_URI + id);
	}

	@Override
	public boolean doesUserExist(UserView user) {
		return findByName(user.getUsername()) != null;
	}

	@Override
	public List<UserView> findAllUsers() {
		ResponseEntity<List<UserView>> response = restTemplate.exchange(AlatConstants.USER_URI, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<UserView>>() {
				});
		return response.getBody();
	}

	@Override
	public UserView findById(int id) {
		logger.debug("Id : " + id);

		Map<String, Integer> params = new HashMap<String, Integer>();
		params.put("id", id);

		ResponseEntity<UserView> response = restTemplate.getForEntity(AlatConstants.USER_URI, UserView.class, params);
		return response.getBody();
	}

	@Override
	public UserView findByName(String name) {
		return findAllUsers().stream().filter(userView -> userView.getUsername().equalsIgnoreCase(name)).findAny()
				.orElse(null);
	}

	@Override
	public void saveUser(UserView user) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<UserView> entity = new HttpEntity<UserView>(user, headers);
		restTemplate.postForLocation(AlatConstants.USER_URI, entity);
	}

	@Override
	public void updateUser(UserView user) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<UserView> entity = new HttpEntity<UserView>(user, headers);
		restTemplate.put(AlatConstants.USER_URI, entity);
	}

}
