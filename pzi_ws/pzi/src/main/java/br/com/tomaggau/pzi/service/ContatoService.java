package br.com.tomaggau.pzi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tomaggau.pzi.model.Usuario;
import br.com.tomaggau.pzi.repository.ContatoRepository;

@Service
public class ContatoService {
	
	@Autowired
	private ContatoRepository contatoRepository;
	
	@Autowired 
	private UsuarioService usuarioService;
	
	public ContatoService save(Usuario usuarioLogado, String nrTelefone) {
		
		Usuario usuario = usuarioService.findByNrTelefone(nrTelefone);
		
		if(usuario == null) {
			return null;
		}
		
		return null;
	}

}
