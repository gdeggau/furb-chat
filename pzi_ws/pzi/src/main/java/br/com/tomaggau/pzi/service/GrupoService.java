package br.com.tomaggau.pzi.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tomaggau.pzi.model.Grupo;
import br.com.tomaggau.pzi.repository.GrupoRepository;

@Service
public class GrupoService {
	
	@Autowired
	private GrupoRepository grupoRepository;
	
	//Criar grupo
	public Grupo save(Grupo grupo) {
		grupo.setDtCadastro(LocalDateTime.now());
		grupo.setFlAtivo('A');
		return grupoRepository.save(grupo);
	}
	
	//Listar todos os grupos
	public List<Grupo> findAll() {
		return grupoRepository.findAll();
	}
	
	//Buscar grupo
	public Grupo findById(Long grupoId) {
		return grupoRepository.findById(grupoId).orElse(null);
	}
	
	//Deletar grupo
	public void delete(Grupo grupo) {
		grupo.setFlAtivo('I');
		grupo.setDtInativacao(LocalDateTime.now());
		grupoRepository.save(grupo);
	}

}
