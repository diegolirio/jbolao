package br.com.jbolao.jbolao.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jbolao.jbolao.models.Aposta;
import br.com.jbolao.jbolao.models.Campeonato;
import br.com.jbolao.jbolao.models.Inscricao;
import br.com.jbolao.jbolao.models.Jogo;
import br.com.jbolao.jbolao.models.StatusType;
import br.com.jbolao.jbolao.repositories.JogoRepository;

@Service
public class JogoService {

	@Autowired
	private JogoRepository jogoRepository;
	
	@Autowired
	private ApostaService apostaService;

	@Autowired
	private InscricaoService inscricaoService;

	public List<Jogo> findByCampeonato(Campeonato campeonato) {
		return this.jogoRepository.findByCampeonato(campeonato);
	}

	public Jogo save(Jogo jogo) {
		boolean novaJogo = this.jogoRepository.exists(jogo.getId()) == false;
		jogo = this.jogoRepository.save(jogo);
		if(novaJogo) {
			List<Inscricao> inscricoes = this.inscricaoService.findByCampeonatoJogos(jogo);
			for (Inscricao inscricao : inscricoes) {
				Aposta a = new Aposta();
				a.setCalculado(false);
				a.setInscricao(inscricao);
				a.setJogo(jogo);
				a.setResultadoA(0);
				a.setResultadoB(0);
				this.apostaService.save(a);
			}
		}
		return jogo;
	}

	public Jogo findOne(Long id) {
		return this.jogoRepository.findOne(id);
	}

	public int countByCampeonato(Campeonato campeonato) {
		return this.jogoRepository.countByCampeonato(campeonato);
	}

	public int countByCampeonatoAndStatusNot(Campeonato campeonato, StatusType status) {
		return this.jogoRepository.countByCampeonatoAndStatusNot(campeonato, status);
	}

	public Jogo start(Jogo jogo) {
		if(jogo.getStatus() != StatusType.EDICAO) 
			throw new RuntimeException("Jogo Deve estar em Modo Edição para ser iniciado");
		if(jogo.getCampeonato().getStatus() != StatusType.EM_ANDAMENTO) 
			throw new RuntimeException("Campeonato Deve estar em Em Andamento para Jogo ser iniciado");
		jogo.setStatus(StatusType.EM_ANDAMENTO);
		jogo = this.save(jogo);
		return jogo;
	}

	public Jogo backToEdit(Jogo jogo) {
		if(jogo.getStatus() != StatusType.EM_ANDAMENTO)
			throw new RuntimeException("Jogo Deve estar Em Andamento para ser retornado para Pendente");
		if(jogo.getCampeonato().getStatus() != StatusType.EM_ANDAMENTO) 
			throw new RuntimeException("Campeonato Deve estar em Em Andamento para Jogo ser retornado para Pendente");
		jogo.setStatus(StatusType.EDICAO);
		jogo = this.save(jogo);
		return jogo;
	}

	/**
	 * Status de EM_ANDAMENTO para FINALIZADO
	 * @param jogo
	 * @return jogo
	 */
	public Jogo finalize(Jogo jogo) {
		if(jogo.getStatus() != StatusType.EM_ANDAMENTO)
			throw new RuntimeException("Jogo Deve estar Em Andamento para ser Finalizado");
		if(jogo.getCampeonato().getStatus() != StatusType.EM_ANDAMENTO) 
			throw new RuntimeException("Campeonato Deve estar em Em Andamento para Jogo ser Finalizado");
		jogo.setStatus(StatusType.FINALIZADO);
		jogo = this.save(jogo);
		return jogo;
	}

	/**
	 * Status FINALIZADO para EM_ANDAMENTO
	 * @param jogo
	 * @return jogo
	 */
	public Jogo backToInProccess(Jogo jogo) {
		if(jogo.getStatus() != StatusType.FINALIZADO)
			throw new RuntimeException("Jogo Deve estar Finalizado para ser retornado para Em Andamento");
		if(jogo.getCampeonato().getStatus() != StatusType.EM_ANDAMENTO) 
			throw new RuntimeException("Campeonato Deve estar em Em Andamento");
		jogo.setStatus(StatusType.EM_ANDAMENTO);
		jogo = this.save(jogo);
		return jogo;
	}

	public List<Jogo> findByCampeonatoInscricoes(Inscricao inscricao) {
		return this.jogoRepository.findByCampeonatoInscricoes(inscricao);
	}

	
	
}
