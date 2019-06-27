package br.com.tomaggau.pzi.controller;

import java.time.LocalDateTime;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.tomaggau.pzi.model.Usuario;
import br.com.tomaggau.pzi.service.UsuarioService;

@RestController
@RequestMapping("/pzi")
@CrossOrigin(origins = {"http://localhost:8100", "http://localhost:8080"})
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping("/usuarios")
	public ResponseEntity<Usuario> salvarUsuario(@Valid @RequestBody Usuario usuarioEntity, @RequestParam MultipartFile imagem) throws Exception {
		if(usuarioService.findByNrTelefone(usuarioEntity.getNrTelefone()) != null)
			throw new Exception("Este telefone já está cadastrado!");
		usuarioEntity.setDtCadastro(LocalDateTime.now());
		usuarioEntity.setFlAtivo('A');
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
	
	@GetMapping("usuarios/{telefone}/{senha}")
	public ResponseEntity<Usuario> buscarUsuarioLogin(@PathVariable(value="telefone") String telefone, @PathVariable(value="senha") String senha) {
		
		Usuario usuario = usuarioService.findByPhoneAndPassword(telefone, senha);
		
		if(usuario == null)
			return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok().body(usuario);
	}
	
	@PutMapping("/usuarios/{id}")
	public ResponseEntity<Usuario> atualizarUsuario(@PathVariable Long id, @Valid @RequestBody Usuario usuarioDetalhes) throws Exception {
		Usuario usuario = usuarioService.findById(id);
		if(usuario == null)
			return ResponseEntity.notFound().build();

		BeanUtils.copyProperties(usuarioDetalhes, usuario, "idUsuario");
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
	

}
