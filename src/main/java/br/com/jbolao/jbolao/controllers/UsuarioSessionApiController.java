package br.com.jbolao.jbolao.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.jbolao.jbolao.models.Campeonato;
import br.com.jbolao.jbolao.models.Usuario;
import br.com.jbolao.jbolao.services.UsuarioService;

@Controller
@RequestMapping(value="/api/usuariosession")
public class UsuarioSessionApiController {

	private static final String CAMPEONATO_SESSION = "campeonatoSession";
	private static final String USUARIO_LOGGED_SESSION = "usuarioLogged";
	
	@Autowired
	private UsuarioService usuarioService;

	@RequestMapping(value="get/usuario", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<String> setUsuario(HttpSession session) {
		try {
			Usuario usuario = (Usuario) session.getAttribute(USUARIO_LOGGED_SESSION);
//			if(usuario == null) {
//				usuario = new Usuario();
//				usuario.setId(1l);
//				usuario.setNome("Diego Lirio");
//				usuario.setEmail("diego@diegolirio.com");
//			}
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(usuario), HttpStatus.OK);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@RequestMapping(value="/set/campeonato", method=RequestMethod.POST, consumes="application/json", produces="application/json")
	public ResponseEntity<String> setCampeonato(@RequestBody Campeonato campeonato, HttpSession session) {
		try {
			session.setAttribute(CAMPEONATO_SESSION, campeonato);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(campeonato), HttpStatus.OK);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value="get/campeonato", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<String> setCampeonato(HttpSession session) {
		try {
			Campeonato campeonato = (Campeonato) session.getAttribute(CAMPEONATO_SESSION);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(campeonato), HttpStatus.OK);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST, consumes="application/json", produces="application/json")
	public ResponseEntity<String> login(@RequestBody Usuario usuario, HttpSession session) {
		try {
			System.out.println("INIT="+usuario);
			if(this.usuarioService.login(usuario.getEmail(), usuario.getSenha()) == false) 
				return new ResponseEntity<String>("Email ou senha incorreto", HttpStatus.UNAUTHORIZED);
			usuario = this.usuarioService.findByEmail(usuario.getEmail());
			System.out.println("LOGGED="+usuario);
			session.setAttribute(USUARIO_LOGGED_SESSION, usuario);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(usuario), HttpStatus.OK);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}	
	
	@RequestMapping(value="/logout", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<String> logout(HttpSession session) {
		try {
			session.invalidate();
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}	
	
}
