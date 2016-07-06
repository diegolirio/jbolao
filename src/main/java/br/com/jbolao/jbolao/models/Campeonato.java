package br.com.jbolao.jbolao.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Diego Lirio
 *
 */
@Entity
public class Campeonato implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue
	private Long id;
	
	/*
	 * Ex: Copa do Mundo | Campeonato Brasileiro
	 */
	private String nome;
	
	/*
	 * Ex: Liga TDV | Amigos do boteco
	 */
	private String descricao;
	
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition="VARCHAR(20) NOT NULL default 'EDICAO'")
	private StatusType status = StatusType.EDICAO;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public StatusType getStatus() {
		return status;
	}

	public void setStatus(StatusType status) {
		this.status = status;
	}
	
	
}
