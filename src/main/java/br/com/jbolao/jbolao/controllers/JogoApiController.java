package br.com.jbolao.jbolao.controllers;

import java.util.ArrayList;
import java.util.Collection;
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
import br.com.jbolao.jbolao.models.StatusType;
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

	@RequestMapping(value="/findone/{id}", method=RequestMethod.GET, produces="application/json; charset=UTF-8")
	public ResponseEntity<String> findOne(@PathVariable("id") Long id) {
		try {
			Jogo jogo = this.jogoService.findOne(id);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(jogo), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		} 
	}

	@RequestMapping(value="/findbycampeonatoandstatus/{campeonatoId}/{status}", method=RequestMethod.GET, produces="application/json; charset=UTF-8")
	public ResponseEntity<String> findByStatus(@PathVariable("campeonatoId") Long campeonatoId, @PathVariable("status") StatusType statusType) {
		try {
			List<Jogo> list = this.jogoService.findByCampeonatoAndStatus(new Campeonato(campeonatoId), statusType);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(list), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		} 
	}

	@RequestMapping(value="/save", method=RequestMethod.POST, consumes="application/json; charset=UTF-8", produces="application/json; charset=UTF-8")
	public ResponseEntity<String> save(@RequestBody Jogo jogo) {
		
		try {
			jogo = this.jogoService.save(jogo);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(jogo), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		} 
	}

	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<String> delete(@PathVariable("id") Long id) {
		try {
			this.jogoService.delete(id);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		} 
	}

	@RequestMapping(value="/start", method=RequestMethod.PUT, consumes="application/json; charset=UTF-8", produces="application/json; charset=UTF-8")
	public ResponseEntity<String> start(@RequestBody Jogo jogo) {
		try {
			jogo = this.jogoService.start(jogo);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(jogo), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		} 
	}

	@RequestMapping(value="/backtoedit", method=RequestMethod.PUT, consumes="application/json; charset=UTF-8", produces="application/json; charset=UTF-8")
	public ResponseEntity<String> backToEdit(@RequestBody Jogo jogo) {
		try {
			jogo = this.jogoService.backToEdit(jogo);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(jogo), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		} 
	}

	@RequestMapping(value="/finalize", method=RequestMethod.PUT, consumes="application/json; charset=UTF-8", produces="application/json; charset=UTF-8")
	public ResponseEntity<String> finalize(@RequestBody Jogo jogo) {
		try {
			jogo = this.jogoService.finalize(jogo);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(jogo), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		} 
	}

	@RequestMapping(value="/backtoinproccess", method=RequestMethod.PUT, consumes="application/json; charset=UTF-8", produces="application/json; charset=UTF-8")
	public ResponseEntity<String> backToInProccess(@RequestBody Jogo jogo) {
		try {
			jogo = this.jogoService.backToInProccess(jogo);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(jogo), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		} 
	}
	
	@RequestMapping(value="/countjogosemandamentofinalizado/{campeonatoId}", method=RequestMethod.GET, produces="application/json; charset=UTF-8")
	public ResponseEntity<String> backToInProccess(@PathVariable("campeonatoId") Long campeonatoId) {
		try {
			Collection<StatusType> statusList = new ArrayList<StatusType>();
			statusList.add(StatusType.EM_ANDAMENTO);
			statusList.add(StatusType.FINALIZADO);
			int countJogos = this.jogoService.countByCampeonatoAndStatusIn(new Campeonato(campeonatoId), statusList );
			return new ResponseEntity<String>("{\"countJogos\": "+countJogos+"}", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		} 
	}
		 
	@RequestMapping(value="/finddistinctrodadabycampeonato/{campeonatoId}", method=RequestMethod.GET, produces="application/json; charset=UTF-8")
	public ResponseEntity<String> findDistinctByCampeonato(@PathVariable("campeonatoId") Long campeonatoId) {
		try {
			List<String> value = this.jogoService.findDistinctRodadaByCampeonato(new Campeonato(campeonatoId));
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(value), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		} 
	}
	
}
