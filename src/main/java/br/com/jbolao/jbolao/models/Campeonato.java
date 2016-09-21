package br.com.jbolao.jbolao.models;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(uniqueConstraints=@UniqueConstraint(columnNames={"nome", "descricao"}))
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
	
	@JsonIgnore
	@OneToMany(mappedBy="campeonato")
	private List<Inscricao> inscricoes;
	
	@JsonIgnore
	@OneToMany(mappedBy="campeonato")
	private List<Jogo> jogos;
	
	@Column(name="altera_aposta_antes_jogo")
	private boolean alteraApostaAntesJogo = false; 
	
	@JsonIgnore
	@Temporal(TemporalType.DATE)
	//@JsonSerialize(using = CalendarToStringSerializerHelpser.class)
	//@JsonDeserialize(using = StringToCalendarDeserializerHelper.class) 
	private Calendar dataCadastro = Calendar.getInstance();	
	
	@ManyToOne
	private Usuario presidente;
	
	public Campeonato() {}
	
	public Campeonato(Long id) {
		this.id = id;
	}

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

	public List<Inscricao> getInscricoes() {
		return inscricoes;
	}

	public void setInscricoes(List<Inscricao> inscricoes) {
		this.inscricoes = inscricoes;
	}

	public List<Jogo> getJogos() {
		return jogos;
	}

	public void setJogos(List<Jogo> jogos) {
		this.jogos = jogos;
	}

	public boolean isAlteraApostaAntesJogo() {
		return alteraApostaAntesJogo;
	}

	public void setAlteraApostaAntesJogo(boolean alteraApostaAntesJogo) {
		this.alteraApostaAntesJogo = alteraApostaAntesJogo;
	}
	
	public Usuario getPresidente() {
		return presidente;
	}

	public void setPresidente(Usuario presidente) {
		this.presidente = presidente;
	}

	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	@Override
	public String toString() {
		return "Campeonato [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", status=" + status + "]";
	}
	
}
