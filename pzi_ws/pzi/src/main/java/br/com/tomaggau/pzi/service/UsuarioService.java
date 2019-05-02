package br.com.tomaggau.pzi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tomaggau.pzi.entity.UsuarioEntity;
import br.com.tomaggau.pzi.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	//Criar usuario
	public UsuarioEntity criarUsuario(UsuarioEntity usuario) {
		return usuarioRepository.save(usuario);
	}
	
	//Listar todos os usuarios
	public List<UsuarioEntity> listarUsuarios() {
		return usuarioRepository.findAll();
	}
	
	//Buscar usuario
	public UsuarioEntity buscarUsuario(Long usuarioId) {
		return usuarioRepository.findById(usuarioId).orElse(null);
	}
	
	//Deletar usuario
	public void deletarUsuario(Long id) {
		usuarioRepository.deleteById(id);
	}
	
}
