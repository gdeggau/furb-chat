package br.com.tomaggau.pzi.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="contatos")
public class Contato {
	
	@Id
	@Column(name="id_contato")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idContato;
	
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario idUsuario;
	
	@ManyToOne
	@JoinColumn(name="id_usuario_contato")
	private Usuario idUsuarioContato;
	
	@Column(name="dt_vinculo")
	private LocalDateTime dtVinculo;
	
	@Column(name="fl_ativo")
	private char flAtivo;
	
	@Column(name="dt_inativacao")
	private LocalDateTime dtInativacao;

	public long getIdContato() {
		return idContato;
	}

	public void setIdContato(long idContato) {
		this.idContato = idContato;
	}

	public Usuario getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Usuario idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Usuario getIdUsuarioContato() {
		return idUsuarioContato;
	}

	public void setIdUsuarioContato(Usuario idUsuarioContato) {
		this.idUsuarioContato = idUsuarioContato;
	}

	public LocalDateTime getDtVinculo() {
		return dtVinculo;
	}

	public void setDtVinculo(LocalDateTime dtVinculo) {
		this.dtVinculo = dtVinculo;
	}

	public char getFlAtivo() {
		return flAtivo;
	}

	public void setFlAtivo(char flAtivo) {
		this.flAtivo = flAtivo;
	}

	public LocalDateTime getDtInativacao() {
		return dtInativacao;
	}

	public void setDtInativacao(LocalDateTime dtInativacao) {
		this.dtInativacao = dtInativacao;
	}

}
