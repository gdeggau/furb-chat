package br.com.tomaggau.pzi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tomaggau.pzi.model.Mensagem;
import br.com.tomaggau.pzi.model.MensagemDestinatario;

@Repository
public interface MensagemDestinatarioRepository extends JpaRepository<MensagemDestinatario, Long>{
	
	MensagemDestinatario findByIdMensagem(Mensagem mensagem);

}
