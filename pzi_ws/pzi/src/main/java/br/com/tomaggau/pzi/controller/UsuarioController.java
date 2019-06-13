package br.com.tomaggau.pzi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tomaggau.pzi.model.Usuario;
import br.com.tomaggau.pzi.service.UsuarioService;

@RestController
@RequestMapping("/pzi")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8080"})
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping("/usuarios")
	public ResponseEntity<Usuario> salvarUsuario(@Valid @RequestBody Usuario usuarioEntity) {
		return ResponseEntity.ok().body(usuarioService.save(usuarioEntity));
	}
	
	@GetMapping("/usuarios")
	public ResponseEntity<List<Usuario>> listarUsuarios() {
		return ResponseEntity.ok().body(usuarioService.findAll());
	}
	
	@GetMapping("/usuarios/{id}")
	public ResponseEntity<Usuario> buscarUsuario(@PathVariable Long id) {
		
		Usuario usuario = usuarioService.findById(id);
		
		if(usuario == null)
			return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok().body(usuario);
	}
	
	@PutMapping("/usuarios/{id}")
	public ResponseEntity<Usuario> atualizarUsuario(@PathVariable Long id, @Valid @RequestBody Usuario usuarioDetalhes) {
		System.out.println("entrou no update");
		Usuario usuario = usuarioService.findById(id);
		if(usuario == null)
			return ResponseEntity.notFound().build();

		BeanUtils.copyProperties(usuarioDetalhes, usuario, "id");
		Usuario atualizarUsuario = usuarioService.save(usuario);
		return ResponseEntity.ok().body(atualizarUsuario);
	}
	
	@DeleteMapping("/usuarios/{id}")
	//@PathVariable significa que o parametro ID vai vir no path da requisicao. ex.:  cliente/3
	public ResponseEntity<Usuario> deletarUsuario(@PathVariable Long id) {
		
		Usuario usuario = usuarioService.findById(id);
		
		if(usuario == null)
			return ResponseEntity.notFound().build();
		
		usuarioService.delete(usuario);
		
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
