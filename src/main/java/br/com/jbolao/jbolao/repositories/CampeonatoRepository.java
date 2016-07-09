package br.com.jbolao.jbolao.repositories;

import java.util.Collection;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.jbolao.jbolao.models.Campeonato;
import br.com.jbolao.jbolao.models.StatusType;

@Repository
public interface CampeonatoRepository extends CrudRepository<Campeonato, Long> {

	List<Campeonato> findByStatusAndInscricoesApostasCalculadoAndInscricoesApostasJogoStatusIn(StatusType emAndamento, boolean apostasCalculadas, Collection<StatusType> statusListJogo);

}
