package br.com.tomaggau.pzi.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.tomaggau.pzi.model.Mensagem;

@Repository
public interface MensagemRepository extends JpaRepository<Mensagem, Long>{
	
	@Query(value = "SELECT * "
				+ " FROM mensagens mens" 
				+ " INNER JOIN mensagem_destinatario mens_des"
				+ " ON mens.id_mensagem = mens_des.id_mensagem"
				+ " WHERE mens.id_usuario_envio = ? "
				+ " AND mens_des.id_usuario_destino = ?", nativeQuery = true)
	List<Mensagem> getMensagensUsuario(Long idEnvio, Long idDestino);
	
	//ta funcionando ainda, tem que ver as paradas do parametros
	@Query(value = "SELECT * "
				+ " FROM mensagens mens" 
				+ " INNER JOIN mensagens_destinatario mens_des" 
				+ " ON mens.id_mensagem = mens_des.id_mensagem" 
				+ " WHERE (mens.id_usuario_envio = :idUser1 AND mens_des.id_usuario_destino = :idUser2)" 
				+ " OR (mens.id_usuario_envio = :idUser2 AND mens_des.id_usuario_destino = :idUser1)" 
				+ " ORDER BY mens.dt_envio;", nativeQuery = true)
	//tanto faz qual user passar nos parametros
	List<Mensagem> getMensagensTrocadasUsuario(@Param("idUser1") Long idUser1, @Param("idUser2") Long idUser2);

}
