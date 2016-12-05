package com.yosanai.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mastercard.api.core.model.RequestMap;
import com.mastercard.api.sectorinsights.Insights;
import com.mastercard.api.sectorinsights.Parameters;
import com.yosanai.web.model.InsightsRequest;

@Controller
public class InsightsController {

	@RequestMapping(value = "/insights", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody Insights insights(@RequestBody InsightsRequest req) throws Exception {
		RequestMap map = new RequestMap();
		map.set("CurrentRow", "1");
		map.set("Country", req.getCountry());
		map.set("Sector", req.getSector());
		map.set("Period", req.getPeriod());
		return Insights.query(map);
	}

	@RequestMapping(value = "/parameters", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody Parameters parameters() throws Exception {
		RequestMap map = new RequestMap();
		return Parameters.query(map);
	}

}
