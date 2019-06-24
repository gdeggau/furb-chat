package br.com.tomaggau.pzi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tomaggau.pzi.model.Grupo;
import br.com.tomaggau.pzi.model.GrupoUsuario;

@Repository
public interface GrupoUsuarioRepository extends JpaRepository<GrupoUsuario, Long>{
	
	List<GrupoUsuario> findByIdGrupoAndDtInativacaoIsNull(Grupo grupo);
	
	

}