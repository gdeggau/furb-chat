package br.com.tomaggau.pzi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.tomaggau.pzi.model.Contato;
import br.com.tomaggau.pzi.model.Grupo;

@Repository
public interface GrupoRepository extends JpaRepository<Grupo, Long>{
	
	@Query(value = "select * from contatos" + 
				" where id_usuario = :idOrigem and dt_inativacao is null and id_usuario_contato not in (" + 
				"	select cont.id_usuario_contato from contatos cont" + 
				"	inner join grupos_usuarios gu" + 
				"	on cont.id_usuario_contato = gu.id_usuario" + 
				"	where cont.id_usuario = :idOrigem" + 
				"	and gu.id_grupo = :idGrupo" + 
				"	and cont.dt_inativacao is null" + 
				" )", nativeQuery = true)
	List<Contato> getContatosParaAdicionarAoGrupo(@Param("idOrigem") Long idOrigem, @Param("idGrupo") Long idGrupo);

}
