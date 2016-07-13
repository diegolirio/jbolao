package br.com.jbolao.jbolao.repositories;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.jbolao.jbolao.models.Campeonato;
import br.com.jbolao.jbolao.models.Inscricao;
import br.com.jbolao.jbolao.models.Jogo;
import br.com.jbolao.jbolao.models.StatusType;

@Repository
public interface JogoRepository extends CrudRepository<Jogo, Long> {

	List<Jogo> findByCampeonato(Campeonato campeonato);

	int countByCampeonato(Campeonato campeonato);

	int countByCampeonatoAndStatusNot(Campeonato campeonato, StatusType status);

	List<Jogo> findByCampeonatoInscricoes(Inscricao inscricao);

	int countByCampeonatoAndStatusIn(Campeonato campeonato, Collection<StatusType> statusList);

	List<Jogo> findByCampeonatoAndStatus(Campeonato campeonato, StatusType statusType);  
	
	@Query(value="SELECT DISTINCT j.rodada FROM Jogo j WHERE j.campeonato = ?1")
	List<String> findDistinctRodadaByCampeonato(Campeonato campeonato);

	void deleteByCampeonato(Campeonato campeonato);

}
