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

import com.apexlegendsat.springmvc.frontend.manager.WeaponManager;
import com.apexlegendsat.springmvc.frontend.view.WeaponView;

@RestController
@RequestMapping(value = "weapon")
public class RestWeaponController {

	static Logger logger = LogManager.getLogger(RestWeaponController.class.getName());

	@Autowired
	private WeaponManager weaponService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<List<WeaponView>> listAllWeapons() {
		List<WeaponView> weapons = null;
		weapons = weaponService.findAllWeapons();
		if (weapons.isEmpty()) {
			return new ResponseEntity<List<WeaponView>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<WeaponView>>(weapons, HttpStatus.OK);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<WeaponView> getWeapon(@PathVariable("id") int id) {
		logger.debug("Fetching Weapon with id " + id);
		WeaponView weapon = null;
		weapon = weaponService.findById(id);
		if (weapon == null) {
			logger.error("Weapon with id " + id + " not found");
			return new ResponseEntity<WeaponView>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<WeaponView>(weapon, HttpStatus.OK);
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<Void> createWeapon(@RequestBody WeaponView weapon) {
		logger.debug("Creating Weapon " + weapon.getName());

		if (weaponService.doesWeaponExist(weapon)) {
			logger.error("A Weapon with name " + weapon.getName() + " already exist");
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		weaponService.saveWeapon(weapon);

		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public ResponseEntity<WeaponView> updateWeapon(@PathVariable("id") int id, @RequestBody WeaponView weapon) {
		logger.debug("Updating Weapon " + id);
		logger.debug(weapon);

		WeaponView currentWeapon = null;
		currentWeapon = weaponService.findById(id);

		if (currentWeapon == null) {
			logger.error("Weapon with id " + id + " not found");
			return new ResponseEntity<WeaponView>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

//		currentWeapon.setName(weapon.getName());
//		currentWeapon.setType(weapon.getType());
//		currentWeapon.setImageSource(weapon.getImageSource());
//		currentWeapon.setLowDps(weapon.getLowDps());
//		currentWeapon.setHighDps(weapon.getHighDps());

		weaponService.updateWeapon(weapon);

		return new ResponseEntity<WeaponView>(weapon, HttpStatus.OK);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<WeaponView> deleteWeapon(@PathVariable("id") int id) {
		logger.debug("Fetching & Deleting Weapon with id " + id);

		WeaponView weapon = null;

		weapon = weaponService.findById(id);
		if (weapon == null) {
			logger.error("Unable to delete. Weapon with id " + id + " not found");
			return new ResponseEntity<WeaponView>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		weaponService.deleteWeaponById(id);
		return new ResponseEntity<WeaponView>(HttpStatus.OK);
	}
}