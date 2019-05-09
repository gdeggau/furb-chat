package br.com.tomaggau.pzi.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="mensagem")
public class MensagemEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column
	@NotNull
	private String nomeUsuario;
	
	@Column
	private String nomeExibicao;
	
	@Column
	private LocalDateTime dataNascimento;
	
	@Column
	private String telefone;
	
	@Column
	@NotNull
	private String email;
	
	@Column
	@NotNull
	private String senha;
	
	@Column
	@NotNull
	private LocalDateTime dataRegistro;
	
	@Column
	private String caminhoFoto;
	
	@Column
	private String frasePerfil;
	
	@Column
	@NotNull
	private char status;
	
	@Column
	@NotNull
	private boolean ativo;

}
