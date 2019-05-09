package br.com.tomaggau.pzi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.tomaggau.pzi.entity.UsuarioEntity;
import br.com.tomaggau.pzi.service.UsuarioService;

@RestController
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping("/usuarios")
	public ResponseEntity<UsuarioEntity> criarUsuario(@Valid @RequestBody UsuarioEntity usuarioEntity) {
		return ResponseEntity.ok().body(usuarioService.salvarUsuario(usuarioEntity));
	}
	
	@GetMapping("/usuarios")
	public ResponseEntity<List<UsuarioEntity>> listarUsuarios() {
		return ResponseEntity.ok().body(usuarioService.listarUsuarios());
	}
	
	@GetMapping("/usuarios/{id}")
	public ResponseEntity<UsuarioEntity> buscarClientePorId(@PathVariable Long id) {
		
		UsuarioEntity usuario = usuarioService.buscarUsuario(id);
		
		if(usuario == null)
			return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok().body(usuario);
	}
	
	@PutMapping("/usuarios/{id}")
	public ResponseEntity<UsuarioEntity> atualizarUsuario(@PathVariable Long id, @RequestBody UsuarioEntity usuarioDetalhes) {
		System.out.println("entrou no update");
		UsuarioEntity usuario = usuarioService.buscarUsuario(id);
		if(usuario == null)
			return ResponseEntity.notFound().build();

		BeanUtils.copyProperties(usuarioDetalhes, usuario, "id");
		UsuarioEntity atualizarUsuario = usuarioService.salvarUsuario(usuario);
		return ResponseEntity.ok().body(atualizarUsuario);
	}
	
	@DeleteMapping("/usuarios/{id}")
	//@PathVariable significa que o parametro ID vai vir no path da requisicao. ex.:  cliente/3
	public ResponseEntity<UsuarioEntity> deletarUsuario(@PathVariable Long id) {
		
		UsuarioEntity usuario = usuarioService.buscarUsuario(id);
		
		if(usuario == null)
			return ResponseEntity.notFound().build();
		
		usuarioService.deletarUsuario(usuario);
		
		return ResponseEntity.ok().build();
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
