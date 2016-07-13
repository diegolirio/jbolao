package br.com.jbolao.jbolao.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jbolao.jbolao.models.Aposta;
import br.com.jbolao.jbolao.models.Campeonato;
import br.com.jbolao.jbolao.models.Inscricao;
import br.com.jbolao.jbolao.models.Jogo;
import br.com.jbolao.jbolao.models.Participante;
import br.com.jbolao.jbolao.models.StatusType;
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
		return this.inscricaoRepository.findByCampeonatoAndAtivoOrderByColocacao(campeonato, true);
	}

	public Inscricao findOne(Long id) {
		return this.inscricaoRepository.findByIdAndAtivo(id, true);
	}
	
	public int maxColocacaoByCampeonato(Campeonato campeonato) {
		Integer maxColocacao = this.inscricaoRepository.maxColocacaoByCampeonato(campeonato);
		int max = (maxColocacao != null && maxColocacao > 0 ? maxColocacao : 0);
		return max;
	}

	public Inscricao save(Inscricao inscricao) {
		boolean novaInscricao = inscricao.getId() == null || !inscricaoRepository.exists(inscricao.getId());
		if(novaInscricao) {
			inscricao.setAtivo(true);
			inscricao.setColocacao(this.maxColocacaoByCampeonato(inscricao.getCampeonato()) + 1);
			inscricao = this.inscricaoRepository.save(inscricao);
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
		return this.inscricaoRepository.findByCampeonatoJogosAndAtivoOrderByColocacao(jogo, true);
	}

	public List<Inscricao> findByCampeonatoOrderByRanking(Campeonato campeonato) {
		return this.inscricaoRepository.findByCampeonatoAndAtivoOrderByPontosDescAcertoPlacarDescAcertoVencedorUmResultadoDescAcertoVencedorDescAcertoSomenteUmResultadoDesc(campeonato, true);
	}

	public List<Inscricao> findByParticipante(Participante participante) {
		return this.inscricaoRepository.findByParticipanteAndAtivo(participante, true);
	}

	public void delete(Inscricao inscricao) {
		if(inscricao.getCampeonato().getStatus() == StatusType.EDICAO) {
			//TODO: this.apostaService.deleteByInscricaoId(inscricao.getId());
			List<Aposta> apostas = this.apostaService.findByInscricao(inscricao);
			for (Aposta aposta : apostas) {
				this.apostaService.delete(aposta);
			}
			
			if(this.apostaService.countByInscricao(inscricao) <= 0) {
				this.inscricaoRepository.delete(inscricao);
			}
		} else {
			inscricao.setAtivo(false);
			this.inscricaoRepository.save(inscricao);
		}
	}

	public void delete(Long id) {
		Inscricao inscricao = this.findOne(id);
		this.delete(inscricao);
	}

	public void deleteByCampeonato(Campeonato campeonato) {
		this.inscricaoRepository.deleteByCampeonato(campeonato);
	}

}
