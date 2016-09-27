package com.diegolirio.bolao.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class NavigatorController {

	@RequestMapping(value="/")
	public String index() {
		return "index";
	}
	
	@RequestMapping(value="/dashboard")
	public String dashboard() {
		return "dashboard";
	}
	
}
