package br.com.jbolao.jbolao.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jbolao.jbolao.common.RegrasCommon;
import br.com.jbolao.jbolao.models.Aposta;
import br.com.jbolao.jbolao.models.Campeonato;
import br.com.jbolao.jbolao.models.Inscricao;
import br.com.jbolao.jbolao.models.Jogo;
import br.com.jbolao.jbolao.models.StatusType;
import br.com.jbolao.jbolao.models.VencedorType;
import br.com.jbolao.jbolao.repositories.CampeonatoRepository;

@Service
public class CampeonatoService {

	@Autowired
	private CampeonatoRepository campeonatoRepository;
	
	@Autowired
	private JogoService jogoService;

	@Autowired
	private ApostaService apostaService;

	@Autowired
	private InscricaoService inscricaoService;

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
			throw new RuntimeException("Campeonato só poderá ser iniciado quando estiver Pendente (Em Edição)");
		int countByCampeonato = this.jogoService.countByCampeonato(campeonato);
		if(countByCampeonato <= 0)
			throw new RuntimeException("Não há Jogo para este campeonato");
		campeonato.setStatus(StatusType.EM_ANDAMENTO);
		campeonato = this.save(campeonato);
		return campeonato;
	}

	public Campeonato backToModeEditStatus(Campeonato campeonato) {
		if(campeonato.getStatus() != StatusType.EM_ANDAMENTO) 
			throw new RuntimeException("Campeonato só poderá voltar para Modo edição quando estiver Em Andamento");
		int countByCampeonatoAndStatusNot = this.jogoService.countByCampeonatoAndStatusNot(campeonato, StatusType.EDICAO);
		if(countByCampeonatoAndStatusNot > 0)
			throw new RuntimeException("Há Jogo(s) Em Andamento ou Finalzado. Para prosseguir todos os jogos deverão estar em Edição");
		campeonato.setStatus(StatusType.EDICAO);
		campeonato = this.save(campeonato);
		return campeonato;
	}
	
	public int getPontos(Jogo jogo, Aposta aposta) {
		if(jogo.getResultadoA() == aposta.getResultadoA() && jogo.getResultadoB() == aposta.getResultadoB())
			return RegrasCommon.ACERTOU_PLACAR;
		if(jogo.getVencedor() == aposta.getVencedor() && aposta.getVencedor() != VencedorType.E && 
		  (jogo.getResultadoA() == aposta.getResultadoA() || jogo.getResultadoB() == aposta.getResultadoB())) 
			return RegrasCommon.ACERTOU_VENCEDOR_UM_RESULTADO;
		if(jogo.getVencedor() == aposta.getVencedor())
			return RegrasCommon.ACERTOU_VENCEDOR;
		if(jogo.getVencedor() != aposta.getVencedor() && 
		  (jogo.getResultadoA() == aposta.getResultadoA() || jogo.getResultadoB() == aposta.getResultadoB()))
				return RegrasCommon.ACERTOU_SOMENTO_UM_RESULTADO;
		return RegrasCommon.ERROU_TUDO;	
	}
	
	private boolean calcularApostas(Jogo jogo) {
		List<Aposta> apostas = this.apostaService.findByJogo(jogo);
		for (Aposta aposta : apostas) {
			aposta.setPontos(this.getPontos(jogo, aposta));
			if (aposta.getJogo().getStatus() == StatusType.FINALIZADO || aposta.getJogo().getStatus() == StatusType.EM_ANDAMENTO)
				aposta.setColocacao(-1);
			this.apostaService.save(aposta);
		}
		return true;
	}

	private boolean calcularApostas(Campeonato campeonato) {
		List<Jogo> jogos = this.jogoService.findByCampeonato(campeonato);
		for (Jogo jogo : jogos) {
			calcularApostas(jogo);
		}
		return true;
	}
	
	private Inscricao somaPontos(Inscricao inscricao) {
		List<Aposta> apostas = this.apostaService.findByInscricao(inscricao);
		int qtdeAp = 0;
		int qtdeAr = 0;
		int qtdeAv = 0;
		int qtdeAs = 0;
		int qtdeEr = 0;					
		int pt = 0;
		for (Aposta aposta : apostas) {
			if(aposta.getJogo().getStatus() != StatusType.EDICAO) {
				pt = pt + aposta.getPontos();
				if(aposta.getPontos() == RegrasCommon.ACERTOU_PLACAR)
					qtdeAp++;	
				if(aposta.getPontos() == RegrasCommon.ACERTOU_VENCEDOR_UM_RESULTADO)
					qtdeAr++;						
				if(aposta.getPontos() == RegrasCommon.ACERTOU_VENCEDOR)
					qtdeAv++;
				if(aposta.getPontos() == RegrasCommon.ACERTOU_SOMENTO_UM_RESULTADO)
					qtdeAs++;	
				if(aposta.getJogo().getStatus() != StatusType.EDICAO && aposta.getPontos() == RegrasCommon.ERROU_TUDO)
					qtdeEr++;
			}
		} 		
		inscricao.setPontos(pt);
		inscricao.setAcertoPlacar(qtdeAp);
		inscricao.setAcertoVencedorUmResultado(qtdeAr);
		inscricao.setAcertoVencedor(qtdeAv);
		inscricao.setAcertoSomenteUmResultado(qtdeAs);
		inscricao.setErrouTudo(qtdeEr);
		inscricao = inscricaoService.save(inscricao);
		return inscricao;
	}

	private void somaPontos(Campeonato campeonato) {
		// calcula colocacao apostas
		List<Inscricao> inscricoesSoma = this.inscricaoService.findByCampeonato(campeonato);
		for (Inscricao inscricao : inscricoesSoma) {
			somaPontos(inscricao);		
		}
	}


	private boolean calculaClassificacao(Campeonato campeonato) {
		somaPontos(campeonato);
		List<Inscricao> inscricoes = this.inscricaoService.findByCampeonatoOrderByRanking(campeonato); 
		int colInc = 0;
		int colReal = 0;
		int ptAnterior = 0;
		int qtdeAp = 0;
		int qtdeAr = 0;
		int qtdeAv = 0;
		int qtdeAs = 0;
		for (Inscricao inscricao : inscricoes) {
			colInc++;
			if (inscricao.getPontos() != ptAnterior || 
				inscricao.getAcertoVencedorUmResultado() != qtdeAr || 
				inscricao.getAcertoPlacar() != qtdeAp || 
				inscricao.getAcertoVencedor() != qtdeAv || 
				inscricao.getAcertoSomenteUmResultado() != qtdeAs) {
				 colReal = colInc;
				 inscricao.setColocacao(colReal);
			} else
				inscricao.setColocacao(colReal);
			this.inscricaoService.save(inscricao);
			ptAnterior = inscricao.getPontos();
			qtdeAp = inscricao.getAcertoPlacar();
			qtdeAr = inscricao.getAcertoVencedorUmResultado();
			qtdeAv = inscricao.getAcertoVencedor();
			qtdeAs = inscricao.getAcertoSomenteUmResultado();
		}

		
		// Finaliza calculo da aposta apos finalizar jogo | guarda historico da colocacao no momento da rodada
		// filtrar novamente as inscricoes ja alteradas a colocacao...
		List<Inscricao> inscricoesColocacao = inscricaoService.findByCampeonato(campeonato);
		for (Inscricao inscricao : inscricoesColocacao) {
			// Colocacao (-1) alterado no metodo -> calcularApostas
			List<Aposta> apostas = apostaService.findByInscricaoAndColocacao(inscricao, -1);
			for (Aposta aposta : apostas) {
				aposta.setColocacao(inscricao.getColocacao());
				if(aposta.getJogo().getStatus() == StatusType.FINALIZADO) {
					aposta.setCalculado(true);
					apostaService.save(aposta);
				}
			}
		}
		
		
		return true;
	}

	private void calculoDefinitivo(Campeonato campeonato) {
		List<Inscricao> inscricoes = inscricaoService.findByCampeonato(campeonato);
		for (Inscricao inscricao : inscricoes) {
			somaPontos(inscricao);		
			calculaClassificacao(campeonato);
		}
	}
	
	// system_calcular_campeonato
	public boolean calcular(Campeonato campeonato) {
		if(campeonato.getStatus() != StatusType.EM_ANDAMENTO)
			return false;
		campeonato.setStatus(StatusType.CALCULANDO);
		this.campeonatoRepository.save(campeonato);
		calcularApostas(campeonato); 
		calculaClassificacao(campeonato);
		calculoDefinitivo(campeonato);
		campeonato.setStatus(StatusType.EM_ANDAMENTO);
		this.campeonatoRepository.save(campeonato);		
		return true;
	}

	public List<Campeonato> findForCalc() {
		Collection<StatusType> statusListJogo = new ArrayList<StatusType>();
		statusListJogo.add(StatusType.EM_ANDAMENTO);
		statusListJogo.add(StatusType.FINALIZADO);
		return this.campeonatoRepository.findByStatusAndInscricoesApostasCalculadoAndInscricoesApostasJogoStatusIn(StatusType.EM_ANDAMENTO, false, statusListJogo);
	}

}
