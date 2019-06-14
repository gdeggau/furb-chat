package br.com.tomaggau.pzi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tomaggau.pzi.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	Usuario findByNmUsuario(String usuario);
	
	Usuario findByNrTelefone(String nrTelefone);

}
