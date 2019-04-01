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
import com.apexlegendsat.springmvc.frontend.view.WeaponView;

@Service
@Transactional
public class WeaponManagerImpl implements WeaponManager {

	static Logger logger = LogManager.getLogger(WeaponManagerImpl.class.getName());

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public void deleteWeaponById(int id) {
		restTemplate.delete(AlatConstants.WEAPON_URI + id);
	}

	@Override
	public boolean doesWeaponExist(WeaponView weapon) {
		return findByName(weapon.getName()) != null;
	}

	@Override
	public List<WeaponView> findAllWeapons() {
		ResponseEntity<List<WeaponView>> response = restTemplate.exchange(AlatConstants.WEAPON_URI, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<WeaponView>>() {
				});
		return response.getBody();
	}

	@Override
	public WeaponView findById(int id) {
		logger.debug("Id : " + id);

		Map<String, Integer> params = new HashMap<String, Integer>();
		params.put("id", id);

		ResponseEntity<WeaponView> response = restTemplate.getForEntity(AlatConstants.WEAPON_URI + id, WeaponView.class, params);
		return response.getBody();
	}

	@Override
	public WeaponView findByName(String name) {
		return findAllWeapons().stream().filter(WeaponView -> WeaponView.getName().equalsIgnoreCase(name)).findAny()
				.orElse(null);
	}

	@Override
	public void saveWeapon(WeaponView weapon) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<WeaponView> entity = new HttpEntity<WeaponView>(weapon, headers);
		restTemplate.postForLocation(AlatConstants.WEAPON_URI, entity);
	}

	@Override
	public void updateWeapon(WeaponView weapon) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<WeaponView> entity = new HttpEntity<WeaponView>(weapon, headers);
		restTemplate.put(AlatConstants.WEAPON_URI, entity);
	}

}
