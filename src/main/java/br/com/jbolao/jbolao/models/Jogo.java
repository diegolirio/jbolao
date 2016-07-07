package br.com.jbolao.jbolao.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Jogo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue
	private Long id;
	
	private String timeA;
	
	private String timeB;
	
	private int resultadoA;
	
	private int resultadoB;

	@Enumerated(EnumType.STRING)
	@Column(columnDefinition="CHAR(1)", nullable=true)
	private VencedorType vencedor;
	
	//private Calendar dataHora;
	
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition="VARCHAR(20) default 'EDICAO'", nullable=false)	
	private StatusType status = StatusType.EDICAO;

	@ManyToOne
	private Campeonato campeonato;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTimeA() {
		return timeA;
	}

	public void setTimeA(String timeA) {
		this.timeA = timeA;
	}

	public String getTimeB() {
		return timeB;
	}

	public void setTimeB(String timeB) {
		this.timeB = timeB;
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

	public VencedorType getVencedor() {
		return vencedor;
	}

	public void setVencedor(VencedorType vencedor) {
		this.vencedor = vencedor;
	}

	public StatusType getStatus() {
		return status;
	}

	public void setStatus(StatusType status) {
		this.status = status;
	}

	public Campeonato getCampeonato() {
		return campeonato;
	}

	public void setCampeonato(Campeonato campeonato) {
		this.campeonato = campeonato;
	}

	
	
	
}
