package br.com.jbolao.jbolao.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jbolao.jbolao.models.Campeonato;
import br.com.jbolao.jbolao.models.StatusType;
import br.com.jbolao.jbolao.repositories.CampeonatoRepository;

@Service
public class CampeonatoService {

	@Autowired
	private CampeonatoRepository campeonatoRepository;
	
	@Autowired
	private JogoService jogoRepository;

	public List<Campeonato> findAll() {
		return (List<Campeonato>) this.campeonatoRepository.findAll();
	}

	public Campeonato save(Campeonato campeonato) {
		return this.campeonatoRepository.save(campeonato);
	}

	public Campeonato findOne(Long id) {
		return this.campeonatoRepository.findOne(id);
	}

	public void delete(Campeonato campeonato) {
		this.campeonatoRepository.delete(campeonato);
	}

	public Campeonato startStatus(Campeonato campeonato) {
		if(campeonato.getStatus() != StatusType.EDICAO) 
			throw new RuntimeException("Campeonato s� poder� ser iniciado quando estiver Pendente (Em Edi��o)");
		int countByCampeonato = this.jogoRepository.countByCampeonato(campeonato);
		if(countByCampeonato <= 0)
			throw new RuntimeException("N�o h� Jogo para este campeonato");
		campeonato.setStatus(StatusType.EM_ANDAMENTO);
		campeonato = this.save(campeonato);
		return campeonato;
	}

	public Campeonato backToModeEditStatus(Campeonato campeonato) {
		if(campeonato.getStatus() != StatusType.EM_ANDAMENTO) 
			throw new RuntimeException("Campeonato s� poder� voltar para Modo edi��o quando estiver Em Andamento");
		int countByCampeonatoAndStatusNot = this.jogoRepository.countByCampeonatoAndStatusNot(campeonato, StatusType.EDICAO);
		if(countByCampeonatoAndStatusNot > 0)
			throw new RuntimeException("H� Jogo(s) Em Andamento ou Finalzado. Para prosseguir todos os jogos dever�o estar em Edi��o");
		campeonato.setStatus(StatusType.EDICAO);
		campeonato = this.save(campeonato);
		return campeonato;
	}

}
