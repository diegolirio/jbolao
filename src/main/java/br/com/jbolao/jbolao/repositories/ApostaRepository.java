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

	List<Aposta> findByInscricaoAndInscricaoAtivo(Inscricao inscricao, boolean ativo);

	List<Aposta> findByInscricaoCampeonatoInscricoesCampeonatoJogosAndInscricaoAtivo(Jogo jogo, boolean ativo);

	List<Aposta> findByJogoAndInscricaoAtivo(Jogo jogo, boolean ativo);

	List<Aposta> findByInscricaoAndColocacaoAndInscricaoAtivo(Inscricao inscricao, int colocacao, boolean ativo);

	List<Aposta> findByInscricaoCampeonatoAndJogoStatusAndInscricaoAtivo(Campeonato campeonato, StatusType statusType, boolean ativo);
	
	List<Aposta> findByJogoRodadaAndInscricaoAtivoOrderByInscricaoId(String rodada, boolean ativo);

	List<Aposta> findByJogoRodadaAndJogoCampeonatoIdAndInscricaoAtivoOrderByInscricaoId(String rodada, Long campeonatoId, boolean ativo);

	void deleteByInscricao(Inscricao inscricao);

	int countByInscricao(Inscricao inscricao);

	void deleteByJogoCampeonato(Campeonato campeonato);

	void deleteByInscricaoId(Long id);

	List<Aposta> findByJogoCampeonato(Campeonato campeonato);

	List<Aposta> findByInscricaoCampeonato(Campeonato campeonato);

	List<Aposta> findByJogoRodadaInAndJogoCampeonatoIdAndCalculadoOrderByInscricaoId(List<String> rodadas, Long campeonatoId, boolean calculado);
	

}
