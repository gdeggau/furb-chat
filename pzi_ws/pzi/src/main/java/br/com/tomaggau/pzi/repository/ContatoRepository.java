package br.com.tomaggau.pzi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tomaggau.pzi.model.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long>{

}
