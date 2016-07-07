package br.com.jbolao.jbolao.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Aposta {

	@Id @GeneratedValue
	private Long id;
	
	@ManyToOne
	private Inscricao inscricao;
	
	@ManyToOne
	private Jogo jogo;
	
	private int resultadoA;

	private int resultadoB;
	
	private int pontos;
	
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition="CHAR(1)", nullable=true)
	private VencedorType vencedor;
	
	private boolean calculado = false;

	private int colocacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Inscricao getInscricao() {
		return inscricao;
	}

	public void setInscricao(Inscricao inscricao) {
		this.inscricao = inscricao;
	}

	public Jogo getJogo() {
		return jogo;
	}

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}

	public int getResultadoA() {
		return resultadoA;
	}

	public void setResultadoA(int resultadoA) {
		this.resultadoA = resultadoA;
	}

	public int getResultadoB() {
		return resultadoB;
	}

	public void setResultadoB(int resultadoB) {
		this.resultadoB = resultadoB;
	}

	public int getPontos() {
		return pontos;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}

	public VencedorType getVencedor() {
		return vencedor;
	}

	public void setVencedor(VencedorType vencedor) {
		this.vencedor = vencedor;
	}

	public boolean isCalculado() {
		return calculado;
	}

	public void setCalculado(boolean calculado) {
		this.calculado = calculado;
	}

	public int getColocacao() {
		return colocacao;
	}

	public void setColocacao(int colocacao) {
		this.colocacao = colocacao;
	}
	
	
	
}
