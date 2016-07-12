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
		return this.apostaRepository.findByInscricao(inscricao);
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
		return this.apostaRepository.findByInscricaoCampeonatoInscricoesCampeonatoJogos(jogo);
	}

	public Aposta findOne(Long id) {
		return this.apostaRepository.findOne(id);
	}

	public List<Aposta> findByJogo(Jogo jogo) {
		return this.apostaRepository.findByJogo(jogo);
	}

	public List<Aposta> findByInscricaoAndColocacao(Inscricao inscricao, int colocacao) {
		return this.apostaRepository.findByInscricaoAndColocacao(inscricao, colocacao);
	}

	public List<Aposta> findByInscricaoCampeonatoAndJogoStatus(Campeonato campeonato, StatusType statusType) {
		return this.apostaRepository.findByInscricaoCampeonatoAndJogoStatus(campeonato, statusType);
	}
 
	public List<Aposta> findByJogoRodadaOrderByInscricaoId(String rodada) {
		return this.apostaRepository.findByJogoRodadaOrderByInscricaoId(rodada);
	}

}
