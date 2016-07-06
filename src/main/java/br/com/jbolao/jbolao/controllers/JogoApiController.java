package br.com.jbolao.jbolao.controllers;

import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.jbolao.jbolao.models.Campeonato;
import br.com.jbolao.jbolao.models.Jogo;
import br.com.jbolao.jbolao.services.JogoService;

@Controller
@RequestMapping(value="/api/jogo")
public class JogoApiController {

	@Autowired
	private JogoService jogoService;

	@RequestMapping(value="/findbycampeonato", method=RequestMethod.GET, consumes="application/json; charset=UTF-8", produces="application/json; charset=UTF-8")
	public ResponseEntity<String> findByCampeonato(@RequestBody Campeonato campeonato) {
		
		try {
			List<Jogo> list = this.jogoService.findByCampeonato(campeonato);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(list), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		} 
	}
	@RequestMapping(value="/findbycampeonato/{campeonatoId}", method=RequestMethod.GET, produces="application/json; charset=UTF-8")
	public ResponseEntity<String> findByCampeonato(@PathVariable("campeonatoId") Long campeonatoId) {
		
		try {
			Campeonato campeonato = new Campeonato();
			campeonato.setId(campeonatoId);
			List<Jogo> list = this.jogoService.findByCampeonato(campeonato);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(list), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		} 
	}
	
}
