package br.com.jbolao.jbolao.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/jogo")
public class JogoController {

	@RequestMapping(value="/list")
	public String pageList() {
		return "jogo/list";
	}
	
}
