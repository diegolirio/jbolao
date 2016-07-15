package br.com.jbolao.jbolao.controllers;

import java.util.ArrayList;
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

import br.com.jbolao.jbolao.models.Aposta;
import br.com.jbolao.jbolao.models.Campeonato;
import br.com.jbolao.jbolao.models.Inscricao;
import br.com.jbolao.jbolao.models.Jogo;
import br.com.jbolao.jbolao.models.StatusType;
import br.com.jbolao.jbolao.services.ApostaService;

@Controller
@RequestMapping(value="/api/aposta")
public class ApostaApiController {
	
	@Autowired
	private ApostaService apostaService;

	@RequestMapping(value="/findbyinscricao/{inscricaoId}", method=RequestMethod.GET, produces="application/json; charset=UTF-8")
	public ResponseEntity<String> findByInscricao(@PathVariable("inscricaoId") Long inscricaoId) {
		try {
			Inscricao inscricao = new Inscricao();
			inscricao.setId(inscricaoId);
			List<Aposta> list = this.apostaService.findByInscricao(inscricao);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(list), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		} 
	}
	
	@RequestMapping(value="/findbyjogo/{jogoId}", method=RequestMethod.GET, produces="application/json; charset=UTF-8")
	public ResponseEntity<String> findByJogo(@PathVariable("jogoId") Long jogoId) {
		try {
			Jogo jogo = new Jogo();
			jogo.setId(jogoId);
			List<Aposta> list = this.apostaService.findByJogo(jogo);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(list), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		} 
	}
	
	@RequestMapping(value="/findbycampeonatoandjogorodada/{campeonatoId}/{rodada}", method=RequestMethod.GET, produces="application/json; charset=UTF-8")
	public ResponseEntity<String> findByJogoCampeonatoAndJogoRodadaByInscricaoId(@PathVariable("campeonatoId") Long campeonatoId, @PathVariable("rodada") String rodada) {
		try {
			List<Aposta> list = this.apostaService.findByJogoRodadaAndJogoCampeonatoIdOrderByInscricaoId(rodada, campeonatoId); 
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(list), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		} 
	}
	
	@RequestMapping(value="/findbycampeonatoandjogorodadain/{campeonatoId}", method=RequestMethod.GET, produces="application/json; charset=UTF-8")
	public ResponseEntity<String> findByJogoCampeonatoAndJogoRodadaInOrderByInscricaoId(@PathVariable("campeonatoId") Long campeonatoId, String rodadas) {
		try {
			String[] rodadasSplit = rodadas.split(";");
			List<String> rodadasIn = new ArrayList<>();
			for (String r : rodadasSplit) {
				rodadasIn.add(r);
			}
			List<Aposta> list = this.apostaService.findByJogoRodadaInAndJogoCampeonatoIdOrderByInscricaoId(rodadasIn, campeonatoId); 
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(list), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		} 
	}
	
	@RequestMapping(value="/findbycampeonatoandjogostatus/{campeonatoId}/{statusType}", method=RequestMethod.GET, produces="application/json; charset=UTF-8")
	public ResponseEntity<String> findByJogo(@PathVariable("campeonatoId") Long campeonatoId, @PathVariable("statusType") StatusType statusType) {
		try {
			List<Aposta> list = this.apostaService.findByInscricaoCampeonatoAndJogoStatus(new Campeonato(campeonatoId), statusType);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(list), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		} 
	}

	@RequestMapping(value="/findone/{id}", method=RequestMethod.GET, produces="application/json; charset=UTF-8")
	public ResponseEntity<String> findOne(@PathVariable("id") Long id) {
		try {
			Aposta aposta = this.apostaService.findOne(id);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(aposta), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		} 
	}

	@RequestMapping(value="/save", method=RequestMethod.POST, consumes="application/json; charset=UTF-8", produces="application/json; charset=UTF-8")
	public ResponseEntity<String> save(@RequestBody Aposta aposta) {
		try {
			aposta = this.apostaService.save(aposta);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(aposta), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		} 
	}

}
