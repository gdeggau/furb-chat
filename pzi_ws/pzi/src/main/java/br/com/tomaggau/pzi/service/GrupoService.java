package br.com.tomaggau.pzi.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tomaggau.pzi.model.Grupo;
import br.com.tomaggau.pzi.model.GrupoUsuario;
import br.com.tomaggau.pzi.model.Usuario;
import br.com.tomaggau.pzi.repository.GrupoRepository;
import br.com.tomaggau.pzi.repository.GrupoUsuarioRepository;

@Service
public class GrupoService {
	
	@Autowired
	private GrupoRepository grupoRepository;
	
	@Autowired
	private GrupoUsuarioRepository grupoUsuarioRepository;
	
	//Criar grupo
	public Grupo save(Grupo grupo) {
		grupo.setDtCadastro(LocalDateTime.now());
		grupo.setFlAtivo('A');
		grupo = grupoRepository.save(grupo);
		adcionarUsuarioGrupo(grupo.getIdUsuarioCadastro(), grupo);
		return grupo;
	}
	
	//Listar todos os grupos
	public List<Grupo> findAll() {
		return grupoRepository.findAll();
	}
	
	//Buscar grupo
	public Grupo findById(Long grupoId) {
		return grupoRepository.findById(grupoId).orElse(null);
	}
	
	//Deletar grupo
	public void delete(Grupo grupo) {
		grupo.setFlAtivo('I');
		grupo.setDtInativacao(LocalDateTime.now());
		grupoRepository.save(grupo);
	}

	//Adcionar usuario a um grupo
	public GrupoUsuario adcionarUsuarioGrupo(Usuario usuario, Grupo grupo) {
		GrupoUsuario grupoUsuario = new GrupoUsuario();
		grupoUsuario.setIdUsuario(usuario);
		grupoUsuario.setIdGrupo(grupo);
		grupoUsuario.setDtRegistro(LocalDateTime.now());
		grupoUsuario.setFlAtivo('A');
		return grupoUsuarioRepository.save(grupoUsuario);
	}
	
	//Remover usuario do grupo
	public void removerUsuarioGrupo(Usuario usuario, Grupo grupo) {
		
	}

}
