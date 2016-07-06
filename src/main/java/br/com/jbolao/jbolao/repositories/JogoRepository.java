package br.com.jbolao.jbolao.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.jbolao.jbolao.models.Campeonato;
import br.com.jbolao.jbolao.models.Jogo;

@Repository
public interface JogoRepository extends CrudRepository<Jogo, Long> {

	List<Jogo> findByCampeonato(Campeonato campeonato); 

}
