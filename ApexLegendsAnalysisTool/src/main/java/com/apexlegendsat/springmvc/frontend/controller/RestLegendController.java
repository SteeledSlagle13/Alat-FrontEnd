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

import com.apexlegendsat.springmvc.frontend.manager.LegendManager;
import com.apexlegendsat.springmvc.frontend.view.LegendView;

@RestController
@RequestMapping(value = "legend")
public class RestLegendController {

	static Logger logger = LogManager.getLogger(RestLegendController.class.getName());

	@Autowired
	private LegendManager legendManager;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<List<LegendView>> listAllLegends() {
		List<LegendView> legends = null;
		legends = legendManager.findAllLegends();
		if (legends.isEmpty()) {
			return new ResponseEntity<List<LegendView>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<LegendView>>(legends, HttpStatus.OK);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<LegendView> getLegend(@PathVariable("id") int id) {
		logger.debug("Fetching Legend with id " + id);

		LegendView legend = null;
		legend = legendManager.findById(id);

		if (legend == null) {
			logger.error("Legend with id " + id + " not found");
			return new ResponseEntity<LegendView>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<LegendView>(legend, HttpStatus.OK);
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<Void> createLegend(@RequestBody LegendView legendView) {
		logger.debug("Creating Legend " + legendView.getName());

		if (legendManager.doesLegendExist(legendView)) {
			logger.error("A Legend with name " + legendView.getName() + " already exist");
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		legendManager.saveLegend(legendView);

		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<LegendView> deleteLegend(@PathVariable("id") int id) {
		logger.debug("Fetching & Deleting Legend with id " + id);

		LegendView legendView = null;

		legendView = legendManager.findById(id);

		if (legendView == null) {
			logger.error("Unable to delete. Legend with id " + id + " not found");
			return new ResponseEntity<LegendView>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		legendManager.deleteLegendById(id);
		return new ResponseEntity<LegendView>(HttpStatus.OK);
	}
}