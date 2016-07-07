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

import br.com.jbolao.jbolao.models.Participante;
import br.com.jbolao.jbolao.services.ParticipanteService;

@Controller
@RequestMapping(value="/api/participante")
public class ParticipanteApiController {

	@Autowired
	private ParticipanteService participanteService;

	@RequestMapping(value="/findall", method=RequestMethod.GET, produces="application/json; charset=UTF-8")
	public ResponseEntity<String> findAll() {
		try {
			List<Participante> list = this.participanteService.findAll();
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(list), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		} 
	}

	@RequestMapping(value="/findone/{id}", method=RequestMethod.GET, produces="application/json; charset=UTF-8")
	public ResponseEntity<String> findOne(@PathVariable("id") Long id) {
		try {
			Participante p = this.participanteService.findOne(id);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(p), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		} 
	}

	@RequestMapping(value="/save", method=RequestMethod.POST, consumes="application/json; charset=UTF-8", produces="application/json; charset=UTF-8")
	public ResponseEntity<String> save(@RequestBody Participante participante) {
		
		try {
			participante = this.participanteService.save(participante);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(participante), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		} 
	}

	
}
