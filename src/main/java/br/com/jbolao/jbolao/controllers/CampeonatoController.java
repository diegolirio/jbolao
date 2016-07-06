package br.com.jbolao.jbolao.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/campeonato")
public class CampeonatoController {


	/*
	 * Pages
	 */
	
	@RequestMapping(value="/dashboard")
	public String dashboard() {
		return "campeonato/dashboard";
	}
	
	@RequestMapping(value="/list")
	public String list() {
		return "campeonato/list";
	}
	
	@RequestMapping(value="/form")
	public String form() {
		return "campeonato/form";
	}

	
}
