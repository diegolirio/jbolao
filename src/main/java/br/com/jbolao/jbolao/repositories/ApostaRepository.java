package br.com.jbolao.jbolao.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.jbolao.jbolao.models.Aposta;
import br.com.jbolao.jbolao.models.Campeonato;
import br.com.jbolao.jbolao.models.Inscricao;
import br.com.jbolao.jbolao.models.Jogo;
import br.com.jbolao.jbolao.models.StatusType;

@Repository
public interface ApostaRepository extends CrudRepository<Aposta, Long> {

	List<Aposta> findByInscricao(Inscricao inscricao);

	List<Aposta> findByInscricaoCampeonatoInscricoesCampeonatoJogos(Jogo jogo);

	List<Aposta> findByJogo(Jogo jogo);

	List<Aposta> findByInscricaoAndColocacao(Inscricao inscricao, int colocacao);

	List<Aposta> findByInscricaoCampeonatoAndJogoStatus(Campeonato campeonato, StatusType statusType);
	
	List<Aposta> findByJogoRodadaOrderByInscricaoId(String rodada);
	

}
