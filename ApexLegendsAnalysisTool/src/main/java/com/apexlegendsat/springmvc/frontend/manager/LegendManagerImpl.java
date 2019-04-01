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
import com.apexlegendsat.springmvc.frontend.view.LegendView;

@Service
@Transactional
public class LegendManagerImpl implements LegendManager {

	static Logger logger = LogManager.getLogger(LegendManagerImpl.class.getName());

	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public void deleteLegendById(int id) {
		restTemplate.delete(AlatConstants.LEGEND_URI + id);
	}

	@Override
	public boolean doesLegendExist(LegendView legendView) {
		return findByName(legendView.getName()) != null;
	}

	@Override
	public List<LegendView> findAllLegends() {
		ResponseEntity<List<LegendView>> response = restTemplate.exchange(AlatConstants.LEGEND_URI, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<LegendView>>() {
				});
		return response.getBody();
	}

	@Override
	public LegendView findById(int id) {
		logger.debug("Id : " + id);

		Map<String, Integer> params = new HashMap<String, Integer>();
		params.put("id", id);

		ResponseEntity<LegendView> response = restTemplate.getForEntity(AlatConstants.LEGEND_URI, LegendView.class, params);

		return response.getBody();
	}

	@Override
	public LegendView findByName(String name) {
		return findAllLegends().stream().filter(legendView -> legendView.getName().equalsIgnoreCase(name)).findAny()
				.orElse(null);
	}

	@Override
	public void saveLegend(LegendView legendView) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<LegendView> entity = new HttpEntity<LegendView>(legendView, headers);

		restTemplate.postForLocation(AlatConstants.LEGEND_URI, entity);
	}
}
