package br.com.tomaggau.pzi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tomaggau.pzi.enums.Destino;
import br.com.tomaggau.pzi.model.Mensagem;
import br.com.tomaggau.pzi.model.Usuario;
import br.com.tomaggau.pzi.service.MensagemService;

@RestController
@RequestMapping("/pzi")
public class MensagemController {
	
	@Autowired
	private MensagemService mensagemService;
	
	//id para quem eu tou enviando a mensagem
	@PostMapping("/mensagens/usuario/{id}")
	public ResponseEntity<Mensagem> enviarMensagemUsuario(@PathVariable Long id, @Valid @RequestBody Mensagem mensagem) {
		return ResponseEntity.ok().body(mensagemService.save(id, mensagem, Destino.USUARIO));
	}
	
	@PostMapping("/mensagens/grupo/{id}")
	public ResponseEntity<Mensagem> enviarMensagemGrupo(@PathVariable Long id, @Valid @RequestBody Mensagem mensagem){
		return ResponseEntity.ok().body(mensagemService.save(id, mensagem, Destino.GRUPO));
	}
	
	//id de quem eu quero ver as mensagens
	//@GetMapping("/mensagens/usuario/{id}")
	//public ResponseEntity<List<Mensagem>> getMensagensRecebidasUsuario(@PathVariable Long id, @Valid @RequestBody Usuario usuarioLogado) {
		//return ResponseEntity.ok().body(mensagemService.getMensagensUsuario(id, usuarioLogado));
	//}
	
	//id de quem eu quero ver as mensagens
	@GetMapping("/mensagens/usuario/{id}")
	public ResponseEntity<List<Mensagem>> getMensagensTrocadasUsuario(@PathVariable Long id, @Valid @RequestBody Usuario usuarioLogado) {
		return ResponseEntity.ok().body(mensagemService.getMensagensTrocadasUsuario(id, usuarioLogado));
	}

}
