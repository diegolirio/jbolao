package br.com.jbolao.jbolao.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Diego Lirio
 *
 */
@Entity
public class Campeonato {

	@Id @GeneratedValue
	private Long id;
	
	private String nome;
	
	private StatusType status;

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

	public StatusType getStatus() {
		return status;
	}

	public void setStatus(StatusType status) {
		this.status = status;
	}
	
	
	
}
