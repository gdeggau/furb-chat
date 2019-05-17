package br.com.tomaggau.pzi.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tomaggau.pzi.model.Usuario;
import br.com.tomaggau.pzi.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	//Criar usuario
	public Usuario save(Usuario usuario) {
		usuario.setDtCadastro(LocalDateTime.now());
		usuario.setFlAtivo('A');
		return usuarioRepository.save(usuario);
	}
	
	//Listar todos os usuarios
	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}
	
	//Buscar usuario
	public Usuario findById(Long usuarioId) {
		return usuarioRepository.findById(usuarioId).orElse(null);
	}
	
	//Deletar usuario
	public void delete(Usuario usuario) {
		usuario.setFlAtivo('I');
		usuarioRepository.save(usuario);
	}
	
}
