package br.com.jbolao.jbolao.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.jbolao.jbolao.models.Usuario;

@Repository
public interface UsuarioReporitory extends CrudRepository<Usuario, Long> {

	int countByEmailAndSenha(String email, String senha);

	Usuario findByEmail(String email);

}
