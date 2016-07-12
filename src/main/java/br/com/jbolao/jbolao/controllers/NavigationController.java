package br.com.jbolao.jbolao.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("")
public class NavigationController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "index";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/regras", method = RequestMethod.GET)
	public String regras() {
		return "regras";
	}

	@RequestMapping(value="campeonato/dashboard")
	public String campeonatoDashboard() {
		return "campeonato/dashboard";
	}
	
	@RequestMapping(value="campeonato/form")
	public String campeonatoForm() {
		return "campeonato/form";
	}

	@RequestMapping(value="campeonato/simulacao")
	public String campeonatoList() {
		return "campeonato/simulacao";
	}
	
	@RequestMapping(value="/aposta/list")
	public String apostaList() {
		return "aposta/list"; 
	}
	
	@RequestMapping(value="/aposta/listbyjogo")
	public String apostaListByJogo() {
		return "aposta/list-by-jogo"; 
	}

	@RequestMapping(value="/aposta/form")
	public String apostaForm() {
		return "aposta/form"; 
	}
	

	@RequestMapping(value="inscricao/rancking")
	public String inscricaoList() {
		return "inscricao/rancking";
	}

	@RequestMapping(value="inscricao/form")
	public String inscricaoForm() {
		return "inscricao/form";
	}	
	
	@RequestMapping(value="participante/list")
	public String participanteList() {
		return "participante/list";
	}

	@RequestMapping(value="participante/form")
	public String participanteForm() {
		return "participante/form";
	}	
	
	@RequestMapping(value="jogo/list")
	public String jogoList() {
		return "jogo/list";
	}

	@RequestMapping(value="jogo/form")
	public String jogoForm() {
		return "jogo/form";
	}	
	
}
