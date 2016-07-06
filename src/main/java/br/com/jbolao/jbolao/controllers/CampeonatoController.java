package br.com.jbolao.jbolao.controllers;

import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.jbolao.jbolao.models.Campeonato;
import br.com.jbolao.jbolao.services.CampeonatoService;

@Controller
@RequestMapping("/campeonato")
public class CampeonatoController {

	@Autowired
	private CampeonatoService campeonatoService;

	/*
	 * Pages
	 */
	
	@RequestMapping(value="/dashboard")
	public String dashboard() {
		return "campeonato/dashboard";
	}
	
	@RequestMapping(value="/form")
	public String form() {
		return "campeonato/form";
	}
	
	/*
	 * Rest
	 */
	
	@RequestMapping(value="/findall", produces="application/json")
	public ResponseEntity<String> findAll() {
		try {
			List<Campeonato> list = this.campeonatoService.findAll();
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(list ), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		} 
	}

	@RequestMapping(value="/save", method=RequestMethod.POST, consumes="application/json", produces="application/json")
	public ResponseEntity<String> save(@RequestBody Campeonato campeonato) {
		try {
			campeonato = this.campeonatoService.save(campeonato);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(campeonato), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		} 
	}
	
}
