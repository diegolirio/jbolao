package br.com.jbolao.jbolao.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jbolao.jbolao.models.Campeonato;
import br.com.jbolao.jbolao.models.Inscricao;
import br.com.jbolao.jbolao.repositories.InscricaoRepository;

@Service
public class InscricaoService {

	@Autowired
	private InscricaoRepository inscricaoRepository;

	public List<Inscricao> findByCampeonato(Campeonato campeonato) {
		return this.inscricaoRepository.findByCampeonato(campeonato);
	}

	public Inscricao findOne(Long id) {
		return this.inscricaoRepository.findOne(id);
	}

	public Inscricao save(Inscricao inscricao) {
		return this.inscricaoRepository.save(inscricao);
	}

}
