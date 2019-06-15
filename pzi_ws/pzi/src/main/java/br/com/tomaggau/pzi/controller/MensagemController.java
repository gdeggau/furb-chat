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

import br.com.tomaggau.pzi.enums.Destino;
import br.com.tomaggau.pzi.model.Mensagem;
import br.com.tomaggau.pzi.service.MensagemService;

@RestController
@RequestMapping("/pzi")
@CrossOrigin(origins = {"http://localhost:8100", "http://localhost:8080"})
public class MensagemController {
	
	/*
	 * 	métodos POST o usuário logado vai no CORPO da requisição
	 *  métodos GET o usuário logado vai como PARAMETRO da requisição
	 * */
	
	@Autowired
	private MensagemService mensagemService;
	
	//id para quem eu tou enviando a mensagem
	@PostMapping("/mensagens/usuario/{idDestino}")
	public ResponseEntity<Mensagem> enviarMensagemUsuario(@PathVariable Long idDestino, @Valid @RequestBody Mensagem mensagem) {
		return ResponseEntity.ok().body(mensagemService.save(idDestino, mensagem, Destino.USUARIO));
	}
	
	@PostMapping("/mensagens/grupo/{idDestino}")
	public ResponseEntity<Mensagem> enviarMensagemGrupo(@PathVariable Long idDestino, @Valid @RequestBody Mensagem mensagem){
		return ResponseEntity.ok().body(mensagemService.save(idDestino, mensagem, Destino.GRUPO));
	}
	
	//id de quem eu quero ver as mensagens
	@GetMapping("/mensagens/usuario/{idOrigem}/{idDestino}")
	public ResponseEntity<List<Mensagem>> getMensagensTrocadasUsuario(@PathVariable(value="idOrigem") Long idOrigem, @PathVariable(value="idDestino") Long idDestino) {
		return ResponseEntity.ok().body(mensagemService.getMensagensTrocadasUsuario(idOrigem, idDestino));
	}
	
	//id do grupo que quero ver as mensagens
	@GetMapping("/mensagens/grupo/{idOrigem}")
	public ResponseEntity<List<Mensagem>> getMensagensTrocadasGrupo(@PathVariable Long idOrigem){
		return ResponseEntity.ok().body(mensagemService.getMensagensTrocadasGrupo(idOrigem));
	}
	
	//minhas mensagens
	@GetMapping("/mensagens/{idOrigem}")
	public ResponseEntity<List<Mensagem>> getMensagensRecebidas(@PathVariable(value="idOrigem") Long idOrigem){
		return ResponseEntity.ok().body(mensagemService.getMensagensRecebidas(idOrigem));
	}

}
