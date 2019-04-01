package com.apexlegendsat.springmvc.frontend.manager;

import java.util.List;

import com.apexlegendsat.springmvc.frontend.view.LegendView;

public interface LegendManager {
	
	void deleteLegendById(int id);
	
	boolean doesLegendExist(LegendView legendView);
	
	List<LegendView> findAllLegends();
	
	LegendView findById(int id);
	
	LegendView findByName(String name);
	
	void saveLegend(LegendView legendView);
	
}
