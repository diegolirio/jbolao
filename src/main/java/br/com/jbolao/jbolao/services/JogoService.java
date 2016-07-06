package br.com.jbolao.jbolao.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jbolao.jbolao.models.Campeonato;
import br.com.jbolao.jbolao.models.Jogo;
import br.com.jbolao.jbolao.repositories.JogoRepository;

@Service
public class JogoService {

	@Autowired
	private JogoRepository jogoRepository;

	public List<Jogo> findByCampeonato(Campeonato campeonato) {
		return this.jogoRepository.findByCampeonato(campeonato);
	}

	
	
}
