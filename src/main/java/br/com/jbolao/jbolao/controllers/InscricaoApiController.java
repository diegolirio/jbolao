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
import br.com.jbolao.jbolao.models.Inscricao;
import br.com.jbolao.jbolao.models.Participante;
import br.com.jbolao.jbolao.services.InscricaoService;

@Controller
@RequestMapping(value="/api/inscricao")
public class InscricaoApiController {

	@Autowired
	private InscricaoService inscricaoService;

	
	@RequestMapping(value="/findbycampeonato", method=RequestMethod.GET, consumes="application/json; charset=UTF-8", produces="application/json; charset=UTF-8")
	public ResponseEntity<String> findByCampeonato(@RequestBody Campeonato campeonato) {
		try {
			List<Inscricao> list = this.inscricaoService.findByCampeonatoOrderByColocacao(campeonato);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(list), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		} 
	}
	
	// TODO: Retirar, manter o de cima
	@RequestMapping(value="/findbycampeonato/{campeonatoId}", method=RequestMethod.GET, produces="application/json; charset=UTF-8")
	public ResponseEntity<String> findByCampeonato(@PathVariable("campeonatoId") Long campeonatoId) {
		try {
			Campeonato campeonato = new Campeonato();
			campeonato.setId(campeonatoId);
			List<Inscricao> list = this.inscricaoService.findByCampeonatoOrderByColocacao(campeonato);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(list), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		} 
	}

	@RequestMapping(value="/findbyparticipante/{participanteId}", method=RequestMethod.GET, produces="application/json; charset=UTF-8")
	public ResponseEntity<String> findByParticipante(@PathVariable("participanteId") Long participanteId) {
		try {
			Participante p = new Participante();
			p.setId(participanteId);
			List<Inscricao> list = this.inscricaoService.findByParticipante(p);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(list), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		} 
	}

	@RequestMapping(value="/findone/{id}", method=RequestMethod.GET, produces="application/json; charset=UTF-8")
	public ResponseEntity<String> findOne(@PathVariable("id") Long id) {
		try {
			Inscricao inscricao = this.inscricaoService.findOne(id);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(inscricao), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		} 
	}

	@RequestMapping(value="/save", method=RequestMethod.POST, consumes="application/json; charset=UTF-8", produces="application/json; charset=UTF-8")
	public ResponseEntity<String> save(@RequestBody Inscricao inscricao) {
		
		try {
			inscricao = this.inscricaoService.save(inscricao);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(inscricao), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		} 
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE, produces="application/json; charset=UTF-8")
	public ResponseEntity<String> delete(@PathVariable("id") Long id) {
		try {
			this.inscricaoService.delete(id);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		} 
	}

	
}
