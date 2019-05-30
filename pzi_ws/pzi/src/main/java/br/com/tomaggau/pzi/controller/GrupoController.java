package br.com.tomaggau.pzi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tomaggau.pzi.model.Grupo;
import br.com.tomaggau.pzi.service.GrupoService;

@RestController
@RequestMapping("/pzi")
public class GrupoController {
	
	@Autowired
	private GrupoService grupoService;
	
	@PostMapping("/grupos")
	public ResponseEntity<Grupo> salvarGrupo(@Valid @RequestBody Grupo grupoEntity){
		return ResponseEntity.ok().body(grupoService.save(grupoEntity));
	}
	
	//public ResponseEntity<Grupo> deletarGrupo(@Valid @RequestBody)

}
