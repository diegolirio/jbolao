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

	public List<Campeonato> findAll() {
		return (List<Campeonato>) this.campeonatoRepository.findAll();
	}

	public Campeonato save(Campeonato campeonato) {
		if(campeonato.getId() == null)
			campeonato.setStatus(StatusType.EDICAO);
		return this.campeonatoRepository.save(campeonato);
	}

}
