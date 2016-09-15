package br.com.jbolao.jbolao.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.jbolao.jbolao.models.Campeonato;
import br.com.jbolao.jbolao.models.Usuario;
import br.com.jbolao.jbolao.services.CampeonatoService;

@RestController
@RequestMapping("/api/campeonato")
public class CampeonatoApiController {

	@Autowired
	private CampeonatoService campeonatoService;

	@RequestMapping(value="/findall", produces="application/json; charset=UTF-8")
	public ResponseEntity<String> findAll(HttpServletResponse response) {
		try {
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
			response.setHeader("Access-Control-Max-Age", "3600");
			response.setHeader("Access-Control-Allow-Headers", "x-requested-with");				
			List<Campeonato> list = this.campeonatoService.findAll();
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(list ), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		} 
	}
	
	@RequestMapping(value="/findone/{id}", produces="application/json; charset=UTF-8")
	public ResponseEntity<String> findOne(@PathVariable("id") Long id) {
		try {
			Campeonato campeonato = this.campeonatoService.findOne(id);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(campeonato), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		} 
	}
	
	@RequestMapping(value="/findbypresidente/{usuarioPresidenteId}", produces="application/json; charset=UTF-8")
	public ResponseEntity<String> findByPresidente(@PathVariable("usuarioPresidenteId") Long usuarioPresidenteId) {
		try {
			List<Campeonato> list = this.campeonatoService.findByPresidenteId(usuarioPresidenteId);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(list), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		} 
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST, consumes="application/json; charset=UTF-8", produces="application/json; charset=UTF-8")
	public ResponseEntity<String> save(@RequestBody Campeonato campeonato, HttpSession session) {
		try {
			if(campeonato.getId() == null || campeonato.getId() <= 0) 
				campeonato.setPresidente((Usuario) session.getAttribute(UsuarioSessionApiController.USUARIO_LOGGED_SESSION));
			campeonato = this.campeonatoService.save(campeonato);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(campeonato), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		} 
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<String> delete(@PathVariable("id") Long id) {
		try {
			this.campeonatoService.delete(id);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		} 
	}
	
	@RequestMapping(value="/start", method=RequestMethod.PUT, consumes="application/json; charset=UTF-8", produces="application/json; charset=UTF-8")
	public ResponseEntity<String> start(@RequestBody Campeonato campeonato) {
		try {
			campeonato = this.campeonatoService.startStatus(campeonato);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(campeonato), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		} 
	}

	@RequestMapping(value="/backtomodeedit", method=RequestMethod.PUT, consumes="application/json; charset=UTF-8", produces="application/json; charset=UTF-8")
	public ResponseEntity<String> backToInProccess(@RequestBody Campeonato campeonato) {
		try {
			campeonato = this.campeonatoService.backToModeEditStatus(campeonato);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(campeonato), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		} 
	}

	@RequestMapping(value="/calcular/{id}", produces="application/json; charset=UTF-8")
	public ResponseEntity<String> executaCalculo(@PathVariable("id") Long id) {
		Campeonato campeonato = this.campeonatoService.findOne(id);
		this.campeonatoService.calcular(campeonato);
		return new ResponseEntity<String>("{\"calculado\": true}", HttpStatus.OK);
	}
	
	@RequestMapping(value="/sendmailrancking/{id}", produces="application/json; charset=UTF-8", method=RequestMethod.PUT)
	public ResponseEntity<String> sendMailRancking(@PathVariable("id") Long id, String serverURL) {
		//String serverURL = HttpCommon.getURLServer(request);
		this.campeonatoService.sendMailRancking(id, serverURL);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	
}
