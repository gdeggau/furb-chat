package br.com.tomaggau.pzi.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tomaggau.pzi.model.Contato;
import br.com.tomaggau.pzi.model.Usuario;
import br.com.tomaggau.pzi.repository.ContatoRepository;

@Service
public class ContatoService{
	
	@Autowired
	private ContatoRepository contatoRepository;
	
	@Autowired 
	private UsuarioService usuarioService;
	
	public Contato save(Usuario usuarioLogado, String nrTelefone) {
		
		Usuario usuarioContato = usuarioService.findByNrTelefone(nrTelefone);
		
		if(usuarioContato == null) {
			return null;
		}
		
		Contato contato = new Contato();
		contato.setIdUsuario(usuarioLogado);
		contato.setIdUsuarioContato(usuarioContato);
		contato.setDtVinculo(LocalDateTime.now());
		contato.setFlAtivo('A');
		
		Contato contato2 = new Contato();
		contato2.setIdUsuario(usuarioContato);
		contato2.setIdUsuarioContato(usuarioLogado);
		contato2.setDtVinculo(LocalDateTime.now());
		contato2.setFlAtivo('A');
		contatoRepository.save(contato2);
		
		return contatoRepository.save(contato);
	}
	
	public List<Usuario> getMeusContato(Long idUsuarioLogado) {
		Usuario usuario = usuarioService.findById(idUsuarioLogado);
		List<Contato> meusContatos = contatoRepository.findByIdUsuarioAndDtInativacaoIsNull(usuario);
		
		List<Usuario> usuariosContato = new ArrayList<Usuario>();
		for (Contato contato : meusContatos) {
			usuariosContato.add(contato.getIdUsuarioContato());
		}
		
		return usuariosContato;
	}

	

}
