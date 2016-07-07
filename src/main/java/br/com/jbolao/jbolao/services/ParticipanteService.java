package br.com.jbolao.jbolao.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jbolao.jbolao.models.Participante;
import br.com.jbolao.jbolao.repositories.ParticipanteRepository;

@Service
public class ParticipanteService {

	@Autowired
	private ParticipanteRepository participanteRepository;

	public List<Participante> findAll() {
		return (List<Participante>) this.participanteRepository.findAll();
	}

	public Participante findOne(Long id) {
		return this.participanteRepository.findOne(id);
	}

	public Participante save(Participante participante) {
		return this.participanteRepository.save(participante);
	}

}
