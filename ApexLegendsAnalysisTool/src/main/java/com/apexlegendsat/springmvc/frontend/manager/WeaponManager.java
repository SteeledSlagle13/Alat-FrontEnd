package com.apexlegendsat.springmvc.frontend.manager;

import java.util.List;

import com.apexlegendsat.springmvc.frontend.view.WeaponView;

public interface WeaponManager {
	
	void deleteWeaponById(int id);
	
	boolean doesWeaponExist(WeaponView weapon);

	List<WeaponView> findAllWeapons();
	
	WeaponView findById(int id);

	WeaponView findByName(String name);

	void saveWeapon(WeaponView weapon);

	void updateWeapon(WeaponView weapon);

}
