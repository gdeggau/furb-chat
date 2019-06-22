package br.com.tomaggau.pzi.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
		
		return contatoRepository.save(contato);
	}
	
	public List<Usuario> getMeusContato(Long idUsuarioLogado) {
		Usuario usuario = usuarioService.findById(idUsuarioLogado);
		List<Contato> meusContatos = contatoRepository.findByIdUsuarioAndDtInativacaoIsNull(usuario);
		
		List<Usuario> usuariosContato = new ArrayList<Usuario>();
		for (Contato contato : meusContatos) {
			usuariosContato.add(contato.getIdUsuarioContato());
		}
		
		Collections.sort(usuariosContato, new Comparator<Usuario>() {
            public int compare(Usuario s1, Usuario s2) {
                  if(s1.getNmExibicao() != null && s2.getNmExibicao() != null && s1.getNmExibicao().compareTo(s1.getNmExibicao()) != 0) {
                      return s1.getNmExibicao().compareTo(s2.getNmExibicao());
                  } else {
                    return s1.getNrTelefone().compareTo(s2.getNrTelefone());
                 }
             }
		});
		
		return usuariosContato;
	}

	public void deletarContato(Long idOrigem, Long idDestino) {
		Usuario origem = usuarioService.findById(idOrigem);
		Usuario destino = usuarioService.findById(idDestino);
		
		Contato contato1 = contatoRepository.findByIdUsuarioAndIdUsuarioContato(origem, destino);
		contato1.setDtInativacao(LocalDateTime.now());
		contato1.setFlAtivo('I');
		contatoRepository.save(contato1);
		
	}

	

}
