package br.com.tomaggau.pzi.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.tomaggau.pzi.entity.UsuarioEntity;
import br.com.tomaggau.pzi.service.UsuarioService;

@RestController
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping("/usuario")
	public UsuarioEntity criarUsuario(@Valid @RequestBody UsuarioEntity usuarioEntity) {
		return usuarioService.criarUsuario(usuarioEntity);
	}
	
	@GetMapping("/usuarios")
	public List<UsuarioEntity> listarUsuarios() {
		return usuarioService.listarUsuarios();
	}
	
	@GetMapping("/usuario/{id}")
	public ResponseEntity<UsuarioEntity> buscarClientePorId(@PathVariable Long id) {
		
		UsuarioEntity usuario = usuarioService.buscarUsuario(id);
		
		if(usuario == null)
			return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok().body(usuario);
	}
	
	/*
	@GetMapping("/clientes/buscar")
	public ResponseEntity<List<ClienteDTO>> buscarClientes(@PathParam(value="nome") String nome){
		return new ResponseEntity<List<ClienteDTO>>(clienteService.buscarClientes(nome), HttpStatus.OK);
	}

	@GetMapping("/clientes")
	public ResponseEntity<List<ClienteDTO>> listarClientes() {
		return new ResponseEntity<List<ClienteDTO>>(clienteService.listarClientes(), HttpStatus.OK);
	}
	
	@PostMapping("/cliente")
	//RequestBody, signfica que o cliente vai vir no corpo da requisição
	public ResponseEntity<ClienteDTO> criarCliente(@RequestBody ClienteDTO clienteDTO) {
		ClienteDTO clienteCriado = clienteService.criarCliente(clienteDTO);
		return new ResponseEntity<ClienteDTO>(clienteCriado, HttpStatus.OK);
	}
	
	@DeleteMapping("/cliente/{id}")
	//@PathVariable significa que o parametro ID vai vir no path da requisicao. ex.:  cliente/3
	public ResponseEntity<Void> deletarCliente(@PathVariable Long id) {
		clienteService.deletarCliente(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	*/
}
