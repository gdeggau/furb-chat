package br.com.tomaggau.pzi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tomaggau.pzi.model.Contato;
import br.com.tomaggau.pzi.model.Mensagem;
import br.com.tomaggau.pzi.model.Usuario;
import br.com.tomaggau.pzi.service.ContatoService;

@RestController
@RequestMapping("/pzi")
@CrossOrigin(origins = {"http://localhost:8100", "http://localhost:8080"})
public class ContatoController {

	@Autowired
	private ContatoService contatoService;
	
	@PostMapping("/contatos/{nrTelefone}")
	public ResponseEntity<Contato> adicionarContato(@PathVariable String nrTelefone, @Valid @RequestBody Usuario usuarioLogado){
		contatoService.save(usuarioLogado, nrTelefone);
		return null;
	}
	
	//public ResponseEntity<T>
	
	
}
