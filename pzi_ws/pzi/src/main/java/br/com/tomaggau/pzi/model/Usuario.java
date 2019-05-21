package br.com.tomaggau.pzi.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuario {
	
	@Id
	@Column(name="id_usuario")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idUsuario;
	
	@Column(name="nm_usuario")
	private String nmUsuario;
	
	@Column(name="nm_usuario_exibicao")
	private String nmExibicao;
	
	@Column(name="dt_nascimento")
	private LocalDateTime dtNascimento;
	
	@Column(name="nr_telefone")
	private String nrTelefone;
	
	@Column(name="ds_email")
	private String dsEmail;
	
	@Column(name="ds_senha")
	private String dsSenha;
	
	@Column(name="dt_cadastro")
	private LocalDateTime dtCadastro;
	
	@Column(name="ds_caminho_foto")
	private String dsCaminhoFoto;
	
	@Column(name="ds_frase_perfil")
	private String dsFrasePerfil;
	
	@Column(name="fl_status")
	private char flStatus;
	
	@Column(name="fl_ativo")
	private char flAtivo;
	
	@Column(name="dt_inativacao")
	private LocalDateTime dtInativacao;
	
	//Getters & Setters

	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNmUsuario() {
		return nmUsuario;
	}

	public void setNmUsuario(String nmUsuario) {
		this.nmUsuario = nmUsuario;
	}

	public String getNmExibicao() {
		return nmExibicao;
	}

	public void setNmExibicao(String nmExibicao) {
		this.nmExibicao = nmExibicao;
	}

	public LocalDateTime getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(LocalDateTime dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public String getNrTelefone() {
		return nrTelefone;
	}

	public void setNrTelefone(String nrTelefone) {
		this.nrTelefone = nrTelefone;
	}

	public String getDsEmail() {
		return dsEmail;
	}

	public void setDsEmail(String dsEmail) {
		this.dsEmail = dsEmail;
	}

	public String getDsSenha() {
		return dsSenha;
	}

	public void setDsSenha(String dsSenha) {
		this.dsSenha = dsSenha;
	}

	public LocalDateTime getDtCadastro() {
		return dtCadastro;
	}

	public void setDtCadastro(LocalDateTime dtCadastro) {
		this.dtCadastro = dtCadastro;
	}

	public String getDsCaminhoFoto() {
		return dsCaminhoFoto;
	}

	public void setDsCaminhoFoto(String dsCaminhoFoto) {
		this.dsCaminhoFoto = dsCaminhoFoto;
	}

	public String getDsFrasePerfil() {
		return dsFrasePerfil;
	}

	public void setDsFrasePerfil(String dsFrasePerfil) {
		this.dsFrasePerfil = dsFrasePerfil;
	}

	public char getFlStatus() {
		return flStatus;
	}

	public void setFlStatus(char flStatus) {
		this.flStatus = flStatus;
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
