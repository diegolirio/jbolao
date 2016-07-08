package br.com.jbolao.jbolao.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jbolao.jbolao.models.Aposta;
import br.com.jbolao.jbolao.models.Inscricao;
import br.com.jbolao.jbolao.models.Jogo;
import br.com.jbolao.jbolao.models.VencedorType;
import br.com.jbolao.jbolao.repositories.ApostaRepository;

@Service
public class ApostaService {

	@Autowired
	private ApostaRepository apostaRepository;

	public List<Aposta> findByInscricao(Inscricao inscricao) {
		return this.apostaRepository.findByInscricao(inscricao);
	}

	public Aposta save(Aposta aposta) {
		boolean newAposta = aposta.getId() != null || !this.apostaRepository.exists(aposta.getId());
		if(newAposta == false) {
			if(aposta.getResultadoA() > aposta.getResultadoB()) 
				aposta.setVencedor(VencedorType.A);
			else if(aposta.getResultadoA() < aposta.getResultadoB()) 
				aposta.setVencedor(VencedorType.B);
			else 
				aposta.setVencedor(VencedorType.E);
		}
		return this.apostaRepository.save(aposta);
	}

	public List<Aposta> findByInscricaoCampeonatoInscricoesCampeonatoJogo(Jogo jogo) {
		return this.apostaRepository.findByInscricaoCampeonatoInscricoesCampeonatoJogos(jogo);
	}

	public Aposta findOne(Long id) {
		return this.apostaRepository.findOne(id);
	}

}
