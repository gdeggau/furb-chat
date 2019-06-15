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
	public Usuario save(Usuario usuario) throws Exception {
		if(usuarioRepository.findByNrTelefone(usuario.getNrTelefone()) != null)
			throw new Exception("Este telefone já está cadastrado!");
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
		usuario.setDtInativacao(LocalDateTime.now());
		usuarioRepository.save(usuario);
	}
	
	public Usuario findByNmUsuario(String nome) {
		return usuarioRepository.findByNmUsuario(nome);
	}
	
	public Usuario findByNrTelefone(String telefone) {
		return usuarioRepository.findByNrTelefone(telefone);
	}
	
}
