package com.yosanai.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mastercard.api.core.model.RequestMap;
import com.mastercard.api.retaillocationinsights.RetailUnits;
import com.yosanai.web.model.RLIRequest;

@Controller
public class RLIController {

	@RequestMapping(value = "/retailUnits", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody RetailUnits helloRESTGet(@RequestBody RLIRequest req) throws Exception {
		RequestMap map = new RequestMap();
		map.set("PageLength", req.getPageLength());
		map.set("PageOffset", req.getPageOffset());
		map.set("CountryCode", req.getCountry());
		return RetailUnits.query(map);
	}
}
