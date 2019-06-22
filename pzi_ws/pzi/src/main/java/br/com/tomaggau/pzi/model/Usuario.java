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
public class Usuario{
	
	

	@Id
	@Column(name="id_usuario")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idUsuario;
	
	//nao nao vai ser mais usado
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dsCaminhoFoto == null) ? 0 : dsCaminhoFoto.hashCode());
		result = prime * result + ((dsEmail == null) ? 0 : dsEmail.hashCode());
		result = prime * result + ((dsFrasePerfil == null) ? 0 : dsFrasePerfil.hashCode());
		result = prime * result + ((dsSenha == null) ? 0 : dsSenha.hashCode());
		result = prime * result + ((dtCadastro == null) ? 0 : dtCadastro.hashCode());
		result = prime * result + ((dtInativacao == null) ? 0 : dtInativacao.hashCode());
		result = prime * result + ((dtNascimento == null) ? 0 : dtNascimento.hashCode());
		result = prime * result + flAtivo;
		result = prime * result + flStatus;
		result = prime * result + (int) (idUsuario ^ (idUsuario >>> 32));
		result = prime * result + ((nmExibicao == null) ? 0 : nmExibicao.hashCode());
		result = prime * result + ((nmUsuario == null) ? 0 : nmUsuario.hashCode());
		result = prime * result + ((nrTelefone == null) ? 0 : nrTelefone.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (dsCaminhoFoto == null) {
			if (other.dsCaminhoFoto != null)
				return false;
		} else if (!dsCaminhoFoto.equals(other.dsCaminhoFoto))
			return false;
		if (dsEmail == null) {
			if (other.dsEmail != null)
				return false;
		} else if (!dsEmail.equals(other.dsEmail))
			return false;
		if (dsFrasePerfil == null) {
			if (other.dsFrasePerfil != null)
				return false;
		} else if (!dsFrasePerfil.equals(other.dsFrasePerfil))
			return false;
		if (dsSenha == null) {
			if (other.dsSenha != null)
				return false;
		} else if (!dsSenha.equals(other.dsSenha))
			return false;
		if (dtCadastro == null) {
			if (other.dtCadastro != null)
				return false;
		} else if (!dtCadastro.equals(other.dtCadastro))
			return false;
		if (dtInativacao == null) {
			if (other.dtInativacao != null)
				return false;
		} else if (!dtInativacao.equals(other.dtInativacao))
			return false;
		if (dtNascimento == null) {
			if (other.dtNascimento != null)
				return false;
		} else if (!dtNascimento.equals(other.dtNascimento))
			return false;
		if (flAtivo != other.flAtivo)
			return false;
		if (flStatus != other.flStatus)
			return false;
		if (idUsuario != other.idUsuario)
			return false;
		if (nmExibicao == null) {
			if (other.nmExibicao != null)
				return false;
		} else if (!nmExibicao.equals(other.nmExibicao))
			return false;
		if (nmUsuario == null) {
			if (other.nmUsuario != null)
				return false;
		} else if (!nmUsuario.equals(other.nmUsuario))
			return false;
		if (nrTelefone == null) {
			if (other.nrTelefone != null)
				return false;
		} else if (!nrTelefone.equals(other.nrTelefone))
			return false;
		return true;
	}
}
