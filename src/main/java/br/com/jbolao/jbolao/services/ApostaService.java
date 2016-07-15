package br.com.jbolao.jbolao.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jbolao.jbolao.models.Aposta;
import br.com.jbolao.jbolao.models.Campeonato;
import br.com.jbolao.jbolao.models.Inscricao;
import br.com.jbolao.jbolao.models.Jogo;
import br.com.jbolao.jbolao.models.StatusType;
import br.com.jbolao.jbolao.models.VencedorType;
import br.com.jbolao.jbolao.repositories.ApostaRepository;

@Service
public class ApostaService {

	@Autowired
	private ApostaRepository apostaRepository;

	public List<Aposta> findByInscricao(Inscricao inscricao) {
		return this.apostaRepository.findByInscricaoAndInscricaoAtivo(inscricao, true);
	}

	public VencedorType getVencedor(Aposta aposta) {
		if(aposta.getResultadoA() > aposta.getResultadoB()) 
			return VencedorType.A;
		if(aposta.getResultadoA() < aposta.getResultadoB()) 
			return VencedorType.B;
		return VencedorType.E;	 
	}
	
	public Aposta save(Aposta aposta) {
		//boolean newAposta = aposta.getId() != null || !this.apostaRepository.exists(aposta.getId());
		aposta.setVencedor(this.getVencedor(aposta));
		return this.apostaRepository.save(aposta);
	}

	public List<Aposta> findByInscricaoCampeonatoInscricoesCampeonatoJogo(Jogo jogo) {
		return this.apostaRepository.findByInscricaoCampeonatoInscricoesCampeonatoJogosAndInscricaoAtivo(jogo, true);
	}

	public Aposta findOne(Long id) {
		return this.apostaRepository.findOne(id);
	}

	public List<Aposta> findByJogo(Jogo jogo) {
		return this.apostaRepository.findByJogoAndInscricaoAtivo(jogo, true);
	}

	public List<Aposta> findByInscricaoAndColocacao(Inscricao inscricao, int colocacao) {
		return this.apostaRepository.findByInscricaoAndColocacaoAndInscricaoAtivo(inscricao, colocacao, true);
	}

	public List<Aposta> findByInscricaoCampeonatoAndJogoStatus(Campeonato campeonato, StatusType statusType) {
		return this.apostaRepository.findByInscricaoCampeonatoAndJogoStatusAndInscricaoAtivo(campeonato, statusType, true);
	}
 
	public List<Aposta> findByJogoRodadaAndJogoCampeonatoIdOrderByInscricaoId(String rodada, Long campeonatoId) {
		return this.apostaRepository.findByJogoRodadaAndJogoCampeonatoIdAndInscricaoAtivoOrderByInscricaoId(rodada, campeonatoId, true);
	}

	public int countByInscricao(Inscricao inscricao) {
		return this.apostaRepository.countByInscricao(inscricao);
	}

	public void deleteByJogoCampeonato(Campeonato campeonato) {
		this.apostaRepository.deleteByJogoCampeonato(campeonato);
	}

	public void deleteByInscricaoId(Long id) {
		this.apostaRepository.deleteByInscricaoId(id);
	}

	public void delete(Aposta aposta) {
		this.apostaRepository.delete(aposta);
	}

	public List<Aposta> findByJogoCampeonato(Campeonato campeonato) {
		return this.apostaRepository.findByJogoCampeonato(campeonato);
	}

	public List<Aposta> findByInscricaoCampeonato(Campeonato campeonato) {
		return this.apostaRepository.findByInscricaoCampeonato(campeonato);
	}

	public List<Aposta> findByJogoRodadaInAndJogoCampeonatoIdOrderByInscricaoId(List<String> rodadas, Long campeonatoId) {
		return this.apostaRepository.findByJogoRodadaInAndJogoCampeonatoIdAndCalculadoOrderByInscricaoId(rodadas, campeonatoId, true);
	}

}
