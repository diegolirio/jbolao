package br.com.jbolao.jbolao.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/inscricao")
public class InscricaoController {

	@RequestMapping(value="/list")
	public String list() {
		return "inscricao/list";
	}

	@RequestMapping(value="/form")
	public String form() {
		return "inscricao/form";
	}
	
}
