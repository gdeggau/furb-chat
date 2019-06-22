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
@Table(name="mensagens")
public class Mensagem{
	
	@Id
	@Column(name="id_mensagem")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idMensagem;
	
	@Column(name="ds_mensagem")
	private String dsMensagem;
	
	@ManyToOne
	@JoinColumn(name="id_usuario_envio")
	private Usuario idUsuarioEnvio;
	
	@Column(name="dt_envio")
	private LocalDateTime dtEnvio;
	
	@Column(name="fl_tipo_mensagem")
	private char flTipoMensagem;
	
	@Column(name="fl_tipo_destino")
	private char flDestino;
	
	@Column(name="ds_titulo_conversa")
	private String dsTituloConversa;
	
	
	//Getters and Setters

	public String getDsTituloConversa() {
		return dsTituloConversa;
	}

	public void setDsTituloConversa(String dsTituloConversa) {
		this.dsTituloConversa = dsTituloConversa;
	}

	public long getIdMensagem() {
		return idMensagem;
	}

	public void setIdMensagem(long idMensagem) {
		this.idMensagem = idMensagem;
	}

	public String getDsMensagem() {
		return dsMensagem;
	}

	public void setDsMensagem(String dsMensagem) {
		this.dsMensagem = dsMensagem;
	}

	public Usuario getIdUsuarioEnvio() {
		return idUsuarioEnvio;
	}

	public void setIdUsuarioEnvio(Usuario idUsuario) {
		this.idUsuarioEnvio = idUsuario;
	}

	public LocalDateTime getDtEnvio() {
		return dtEnvio;
	}

	public void setDtEnvio(LocalDateTime dtEnvio) {
		this.dtEnvio = dtEnvio;
	}

	public char getFlTipoMensagem() {
		return flTipoMensagem;
	}

	public void setFlTipoMensagem(char flTipoMensagem) {
		this.flTipoMensagem = flTipoMensagem;
	}

	public char getFlDestino() {
		return flDestino;
	}

	public void setFlDestino(char flDestino) {
		this.flDestino = flDestino;
	}

	

	
}
