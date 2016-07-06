package br.com.jbolao.jbolao.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.jbolao.jbolao.models.Campeonato;

@Repository
public interface CampeonatoRepository extends CrudRepository<Campeonato, Long> {

}
