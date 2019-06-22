package br.com.tomaggau.pzi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tomaggau.pzi.model.Contato;
import br.com.tomaggau.pzi.model.Usuario;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long>{
	
	List<Contato> findByIdUsuarioAndDtInativacaoIsNull(Usuario usuario);
	
	Contato findByIdUsuarioAndIdUsuarioContato(Usuario origem, Usuario contato);

}
