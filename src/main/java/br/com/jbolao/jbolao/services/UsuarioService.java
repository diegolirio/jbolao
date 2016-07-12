package br.com.jbolao.jbolao.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jbolao.jbolao.models.Usuario;
import br.com.jbolao.jbolao.repositories.UsuarioReporitory;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioReporitory usuarioRepository;

	public boolean login(String email, String senha) {
		return this.usuarioRepository.countByEmailAndSenha(email, senha) > 0;
	}

	public Usuario findByEmail(String email) {
		return this.usuarioRepository.findByEmail(email);
	}

	
	
}
