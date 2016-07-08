package br.com.jbolao.jbolao.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.jbolao.jbolao.models.Campeonato;
import br.com.jbolao.jbolao.models.Inscricao;
import br.com.jbolao.jbolao.models.Jogo;

@Repository
public interface InscricaoRepository extends CrudRepository<Inscricao, Long> {

	List<Inscricao> findByCampeonato(Campeonato campeonato);
 
	List<Inscricao> findByCampeonatoJogos(Jogo jogo); 

}