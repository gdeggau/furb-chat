package br.com.tomaggau.pzi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tomaggau.pzi.model.Grupo;
import br.com.tomaggau.pzi.model.GrupoUsuario;
import br.com.tomaggau.pzi.repository.GrupoUsuarioRepository;

@Service
public class GrupoUsuarioService {
	
	@Autowired
	private GrupoUsuarioRepository grupoUsuarioRepository;
	
	public GrupoUsuario save(GrupoUsuario grupoUsuario) {
		return grupoUsuarioRepository.save(grupoUsuario);
	}
	
	public List<GrupoUsuario> findAllUsersInGroup(Grupo grupo){
		return grupoUsuarioRepository.findByIdGrupoAndDtInativacaoIsNull(grupo);
	}

}
