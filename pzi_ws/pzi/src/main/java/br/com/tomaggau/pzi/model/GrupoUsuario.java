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
@Table(name="grupos_usuarios")
public class GrupoUsuario {
	
	@Id
	@Column(name="id_grupos_usuarios")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idGruposUsuarios;
	
	@ManyToOne
	@JoinColumn(name="id_grupo")
	private Grupo idGrupo;
	
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario idUsuario;
	
	@Column(name="dt_registro")
	private LocalDateTime dtRegistro;
	
	@Column(name="fl_ativo")
	private char flAtivo;
	
	@Column(name="dt_inativacao")
	private LocalDateTime dtInativacao;

	public long getIdGruposUsuarios() {
		return idGruposUsuarios;
	}

	public void setIdGruposUsuarios(long idGruposUsuarios) {
		this.idGruposUsuarios = idGruposUsuarios;
	}

	public Grupo getIdGrupo() {
		return idGrupo;
	}

	public void setIdGrupo(Grupo idGrupo) {
		this.idGrupo = idGrupo;
	}

	public Usuario getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Usuario idUsuario) {
		this.idUsuario = idUsuario;
	}

	public LocalDateTime getDtRegistro() {
		return dtRegistro;
	}

	public void setDtRegistro(LocalDateTime dtRegistro) {
		this.dtRegistro = dtRegistro;
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
