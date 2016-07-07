package br.com.jbolao.jbolao.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/participante")
public class ParticipanteController {

	@RequestMapping(value="/list")
	public String list() {
		return "participante/list";
	}

	@RequestMapping(value="/form")
	public String form() {
		return "participante/form";
	}
	
}
