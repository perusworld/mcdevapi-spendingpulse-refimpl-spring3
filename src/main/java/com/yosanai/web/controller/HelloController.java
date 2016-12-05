package com.yosanai.web.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@RequestMapping(value = "/")
	public ModelAndView home(Locale locale, Model model) {
		return new ModelAndView("index.html");
	}

}
