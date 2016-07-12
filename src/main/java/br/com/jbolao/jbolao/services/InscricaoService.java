package br.com.jbolao.jbolao.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jbolao.jbolao.models.Aposta;
import br.com.jbolao.jbolao.models.Campeonato;
import br.com.jbolao.jbolao.models.Inscricao;
import br.com.jbolao.jbolao.models.Jogo;
import br.com.jbolao.jbolao.repositories.InscricaoRepository;

@Service
public class InscricaoService {

	@Autowired
	private InscricaoRepository inscricaoRepository;

	@Autowired
	private JogoService jogoService;

	@Autowired
	private ApostaService apostaService;

	public List<Inscricao> findByCampeonatoOrderByColocacao(Campeonato campeonato) {
		return this.inscricaoRepository.findByCampeonatoOrderByColocacao(campeonato);
	}

	public Inscricao findOne(Long id) {
		return this.inscricaoRepository.findOne(id);
	}

	public Inscricao save(Inscricao inscricao) {
		boolean novaInscricao = inscricao.getId() == null || !inscricaoRepository.exists(inscricao.getId());
		inscricao = this.inscricaoRepository.save(inscricao);
		if(novaInscricao) {
			List<Jogo> jogos = this.jogoService.findByCampeonatoInscricoes(inscricao);
			for (Jogo jogo : jogos) {
				Aposta a = new Aposta();
				a.setInscricao(inscricao);
				a.setJogo(jogo);
				a.setCalculado(false);
				a.setResultadoA(0);
				a.setResultadoB(0);
				this.apostaService.save(a);
			}
		}
		return inscricao;
	}

	public List<Inscricao> findByCampeonatoJogosOrderByColocacao(Jogo jogo) {
		return this.inscricaoRepository.findByCampeonatoJogosOrderByColocacao(jogo);
	}

	public List<Inscricao> findByCampeonatoOrderByRanking(Campeonato campeonato) {
		return this.inscricaoRepository.findByCampeonatoOrderByPontosDescAcertoPlacarDescAcertoVencedorUmResultadoDescAcertoVencedorDescAcertoSomenteUmResultadoDesc(campeonato);
	}

}
