package br.com.jbolao.jbolao.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
public class Inscricao {

	@Id @GeneratedValue
	private Long id;

	@ManyToOne
	private Campeonato campeonato;

	@ManyToOne
	private Participante participante;
	
	private int colocacao = 0;
	
	private int pontos = 0;
	
	/**
	 * Ex: Jogo 2 X 1 - Aposta 2 X 1 
	 *     Jogo 2 X 4 - Aposta 2 X 4
	 */ 
	private int acertoPlacar = 0; // 8 pontos

	/**
	 * Ex: Jogo 2 X 1 - Aposta 3 X 1 
	 *     Jogo 2 X 3 - Aposta 2 X 4
	 */
	private int acertoVencedorUmResultado = 0; // 5 pontos

	/**
	 *  Acertou Vencedor ou Empate com placar diferente
	 *  Ex: Jogo 2 X 0 - Aposta 3 X 1
	 *   	Jogo 2 X 4 - Aposta 0 X 1
	 *   	Jogo 1 X 1 - Aposta 2 X 2
	 */
	private int acertoVencedor = 0; // 3 pontos

	/**
	 *  Acertou Somente um Resultado
	 *  Ex: Jogo 2 X 0 - Aposta 2 X 3
	 *   	Jogo 2 X 4 - Aposta 2 X 1
	 *   	Jogo 1 X 1 - Aposta 2 X 1
	 */
	private int acertoSomenteUmResultado = 0; // 1 pontos

	/**
	 *  Acertou Somente um Resultado
	 *  Ex: Jogo 2 X 0 - Aposta 1 X 1
	 *   	Jogo 2 X 4 - Aposta 3 X 1
	 *   	Jogo 1 X 1 - Aposta 3 X 0
	 */
	private int errouTudo = 0;
	
	@JsonIgnore
	@OneToMany(mappedBy="inscricao")
	private List<Aposta> apostas;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Campeonato getCampeonato() {
		return campeonato;
	}

	public void setCampeonato(Campeonato campeonato) {
		this.campeonato = campeonato;
	}
	
	public Participante getParticipante() {
		return participante;
	}

	public void setParticipante(Participante participante) {
		this.participante = participante;
	}
	
	public int getColocacao() {
		return colocacao;
	}

	public void setColocacao(int colocacao) {
		this.colocacao = colocacao;
	}

	public int getPontos() {
		return pontos;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}

	public int getAcertoPlacar() {
		return acertoPlacar;
	}

	public void setAcertoPlacar(int acertoPlacar) {
		this.acertoPlacar = acertoPlacar;
	}

	public int getAcertoVencedorUmResultado() {
		return acertoVencedorUmResultado;
	}

	public void setAcertoVencedorUmResultado(int acertoVencedorUmResultado) {
		this.acertoVencedorUmResultado = acertoVencedorUmResultado;
	}

	public int getAcertoVencedor() {
		return acertoVencedor;
	}

	public void setAcertoVencedor(int acertoVencedor) {
		this.acertoVencedor = acertoVencedor;
	}

	public int getAcertoSomenteUmResultado() {
		return acertoSomenteUmResultado;
	}

	public void setAcertoSomenteUmResultado(int acertoSomenteUmResultado) {
		this.acertoSomenteUmResultado = acertoSomenteUmResultado;
	}

	public int getErrouTudo() {
		return errouTudo;
	}

	public void setErrouTudo(int errouTudo) {
		this.errouTudo = errouTudo;
	}	
	
	
	
}
