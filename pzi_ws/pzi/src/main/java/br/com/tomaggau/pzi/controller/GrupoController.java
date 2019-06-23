package br.com.tomaggau.pzi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tomaggau.pzi.model.Grupo;
import br.com.tomaggau.pzi.model.GrupoUsuario;
import br.com.tomaggau.pzi.model.Usuario;
import br.com.tomaggau.pzi.service.GrupoService;
import br.com.tomaggau.pzi.service.UsuarioService;

@RestController
@RequestMapping("/pzi")
@CrossOrigin(origins = {"http://localhost:8100", "http://localhost:8080"})
public class GrupoController {
	
	@Autowired
	private GrupoService grupoService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping("/grupos")
	public ResponseEntity<Grupo> salvarGrupo(@Valid @RequestBody Grupo grupoEntity){
		return ResponseEntity.ok().body(grupoService.save(grupoEntity));
	}
	
	@GetMapping("/grupos/{id}")
	public ResponseEntity<Grupo> buscarGrupo(@PathVariable Long id){
		Grupo grupo = grupoService.findById(id);
		
		if(grupo == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok().body(grupo);
	}
	
	@GetMapping("/grupos")
	public ResponseEntity<List<Grupo>> listarGrupos(){
		return ResponseEntity.ok().body(grupoService.findAll());
	}
	
	@DeleteMapping("/grupos/{id}")
	public ResponseEntity<Grupo> deletarGrupo(@PathVariable Long id){
		Grupo grupo = grupoService.findById(id);
		
		if(grupo == null) {
			return ResponseEntity.notFound().build();
		}
		
		grupoService.delete(grupo);
		
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("/grupos/usuarios/{id}")
	public ResponseEntity<GrupoUsuario> adcionarUsuarioGrupo(@PathVariable Long id, @RequestBody @Valid Grupo grupo){
		Usuario usuario = usuarioService.findById(id);
		
		if(grupo == null || usuario == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok().body(grupoService.adcionarUsuarioGrupo(usuario, grupo));
	}
	
	/*
	@DeleteMapping("/grupos/usuarios/{id}")
	public ResponseEntity<GrupoUsuario> removerUsuarioGrupo(@PathVariable Long id,@RequestBody @Valid GrupoUsuario grupoUsuario){
		Grupo grupo = grupoService.findById(grupoUsuario.getIdGrupo().getIdGrupo());
		Usuario usuario = usuarioService.findById(id);
		
		if(grupo == null || usuario == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok().body(grupoService.);
	}
	*/
}
