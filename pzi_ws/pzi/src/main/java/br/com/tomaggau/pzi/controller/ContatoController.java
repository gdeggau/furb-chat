package br.com.tomaggau.pzi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tomaggau.pzi.model.Contato;
import br.com.tomaggau.pzi.model.Usuario;
import br.com.tomaggau.pzi.service.ContatoService;

@RestController
@RequestMapping("/pzi")
@CrossOrigin(origins = {"http://localhost:8100", "http://localhost:8080"})
public class ContatoController {
	
	/*
	 * 	métodos POST o usuário logado vai no CORPO da requisição
	 *  métodos GET o usuário logado vai como PARAMETRO da requisição
	 * */

	@Autowired
	private ContatoService contatoService;
	
	@PostMapping("/contatos/{nrTelefone}")
	public ResponseEntity<Contato> adicionarContato(@PathVariable String nrTelefone, @Valid @RequestBody Usuario usuarioLogado){
		Contato contato = contatoService.save(usuarioLogado, nrTelefone);
		
		if(contato == null)
			ResponseEntity.notFound().build();
		
		return ResponseEntity.ok().body(contato);
	}
	
	@GetMapping("/contatos/{idOrigem}")
	public ResponseEntity<List<Usuario>> getMeusContatos(@PathVariable(value="idOrigem") Long idOrigem){
		return ResponseEntity.ok().body(contatoService.getMeusContato(idOrigem));
	}
	
	
}
