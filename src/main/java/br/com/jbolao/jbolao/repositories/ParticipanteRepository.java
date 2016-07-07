package br.com.jbolao.jbolao.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.jbolao.jbolao.models.Participante;

@Repository
public interface ParticipanteRepository extends CrudRepository<Participante, Long> {

}
