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
@Table(name="grupos")
public class Grupo {
		
		@Id
		@Column(name="id_grupo")
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private long idGrupo;
		
		@Column(name="nm_grupo")
		private String nmGrupo;
		
		@Column(name="ds_grupo")
		private String dsGrupo;
		
		@ManyToOne
		@JoinColumn(name="id_usuario_cadastro")
		private Usuario idUsuarioCadastro;
		
		@Column(name="dt_cadastro")
		private LocalDateTime dtCadastro;
	
		@Column(name="fl_ativo")
		private char flAtivo;
		
		@Column(name="dt_inativacao")
		private LocalDateTime dtInativacao;

		public long getIdGrupo() {
			return idGrupo;
		}

		public void setIdGrupo(long idGrupo) {
			this.idGrupo = idGrupo;
		}

		public String getNmGrupo() {
			return nmGrupo;
		}

		public void setNmGrupo(String nmGrupo) {
			this.nmGrupo = nmGrupo;
		}

		public String getDsGrupo() {
			return dsGrupo;
		}

		public void setDsGrupo(String dsGrupo) {
			this.dsGrupo = dsGrupo;
		}

		public Usuario getIdUsuarioCadastro() {
			return idUsuarioCadastro;
		}

		public void setIdUsuarioCadastro(Usuario idUsuarioCadastro) {
			this.idUsuarioCadastro = idUsuarioCadastro;
		}

		public LocalDateTime getDtCadastro() {
			return dtCadastro;
		}

		public void setDtCadastro(LocalDateTime dtCadastro) {
			this.dtCadastro = dtCadastro;
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
