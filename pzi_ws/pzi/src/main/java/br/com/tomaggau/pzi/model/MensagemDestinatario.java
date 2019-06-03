package br.com.tomaggau.pzi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="mensagens_destinatario")
public class MensagemDestinatario {
	
	@Id
	@Column(name="id_mensagem_destinatario")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idMensagemDestinatario;
	
	@ManyToOne
	@JoinColumn(name="id_mensagem")
	private Mensagem idMensagem;
	
	@ManyToOne
	@JoinColumn(name="id_usuario_destino")
	private Usuario idUsuarioDestino;
	
	@ManyToOne
	@JoinColumn(name="id_grupos_usuarios_destino")
	private GrupoUsuario idGruposUsuariosDestino;
	
	@Column(name="fl_lida")
	private char flLida;
	
	//Getters and Setters

	public long getIdMensagemDestinatario() {
		return idMensagemDestinatario;
	}

	public void setIdMensagemDestinatario(long idMensagemDestinatario) {
		this.idMensagemDestinatario = idMensagemDestinatario;
	}

	public Mensagem getIdMensagem() {
		return idMensagem;
	}

	public void setIdMensagem(Mensagem idMensagem) {
		this.idMensagem = idMensagem;
	}

	public Usuario getIdUsuarioDestino() {
		return idUsuarioDestino;
	}

	public void setIdUsuarioDestino(Usuario idUsuarioDestino) {
		this.idUsuarioDestino = idUsuarioDestino;
	}

	public char getFlLida() {
		return flLida;
	}

	public void setFlLida(char flLida) {
		this.flLida = flLida;
	}

	public GrupoUsuario getIdGruposUsuariosDestino() {
		return idGruposUsuariosDestino;
	}

	public void setIdGruposUsuariosDestino(GrupoUsuario idGruposUsuariosDestino) {
		this.idGruposUsuariosDestino = idGruposUsuariosDestino;
	}

	
	
}
