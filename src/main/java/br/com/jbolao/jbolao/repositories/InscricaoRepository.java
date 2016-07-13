package br.com.jbolao.jbolao.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.jbolao.jbolao.models.Campeonato;
import br.com.jbolao.jbolao.models.Inscricao;
import br.com.jbolao.jbolao.models.Jogo;
import br.com.jbolao.jbolao.models.Participante;

@Repository
public interface InscricaoRepository extends CrudRepository<Inscricao, Long> {

	List<Inscricao> findByCampeonatoAndAtivoOrderByColocacao(Campeonato campeonato, boolean ativo);
 
	List<Inscricao> findByCampeonatoJogosAndAtivoOrderByColocacao(Jogo jogo, boolean ativo);
  
	List<Inscricao> findByCampeonatoAndAtivoOrderByPontosDescAcertoPlacarDescAcertoVencedorUmResultadoDescAcertoVencedorDescAcertoSomenteUmResultadoDesc(Campeonato campeonato, boolean ativo);

	List<Inscricao> findByParticipanteAndAtivo(Participante participante, boolean ativo);

	Inscricao findByIdAndAtivo(Long id, boolean ativo);

	@Query("SELECT MAX(i.colocacao) FROM Inscricao i WHERE i.campeonato = ?1")
	Integer maxColocacaoByCampeonato(Campeonato campeonato);

	void deleteByCampeonato(Campeonato campeonato); 
	
}
