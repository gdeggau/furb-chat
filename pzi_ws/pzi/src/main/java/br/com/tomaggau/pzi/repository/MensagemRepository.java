package br.com.tomaggau.pzi.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.tomaggau.pzi.model.Mensagem;

@Repository
public interface MensagemRepository extends JpaRepository<Mensagem, Long>{
	
	@Query(value = "SELECT *"
				+ " FROM mensagens mens" 
				+ " INNER JOIN mensagem_destinatario mens_des"
				+ " ON mens.id_mensagem = mens_des.id_mensagem"
				+ " WHERE mens.id_usuario_envio = ? "
				+ " AND mens_des.id_usuario_destino = ?", nativeQuery = true)
	List<Mensagem> getMensagensUsuario(Long idEnvio, Long idDestino);
	
	//ta funcionando ainda, tem que ver as paradas do parametros
	@Query(value = "SELECT *"
				+ " FROM mensagens mens" 
				+ " INNER JOIN mensagens_destinatario mens_des" 
				+ " ON mens.id_mensagem = mens_des.id_mensagem" 
				+ " WHERE (mens.id_usuario_envio = :idUser1 AND mens_des.id_usuario_destino = :idUser2)" 
				+ " OR (mens.id_usuario_envio = :idUser2 AND mens_des.id_usuario_destino = :idUser1)" 
				+ " ORDER BY mens.dt_envio;", nativeQuery = true)
	//tanto faz qual user passar nos parametros
	List<Mensagem> getMensagensTrocadasUsuario(@Param("idUser1") Long idUser1, @Param("idUser2") Long idUser2);
	
	@Query(value="SELECT mens.* "
			  + " FROM mensagens mens" 
			  + " INNER JOIN mensagens_destinatario mens_des" 
			  + " ON mens.id_mensagem = mens_des.id_mensagem" 
			  + " INNER JOIN grupos_usuarios gp_user"
			  + " ON gp_user.id_grupos_usuarios = mens_des.id_grupos_usuarios_destino" 
			  + " INNER JOIN grupos gp"
			  + " ON gp.id_grupo = gp_user.id_grupo"
			  + " WHERE gp.id_grupo = ? "
			  + " GROUP BY mens.id_mensagem, mens.ds_mensagem "
			  + " ORDER BY mens.dt_envio;", nativeQuery = true)
	List<Mensagem> getMensagensTrocadasGrupo(Long idGrupo);
	
	@Query(value="select mens.id_mensagem, mens.ds_mensagem, mens2.dt_envio, mens.fl_tipo_mensagem, mens.id_usuario_envio"
			  + " from ("
			  + " 		select max(dt_envio) dt_envio, id_usuario_envio"
			  + " 		from mensagens"
			  + " 		group by id_usuario_envio"
			  + " ) mens2"
			  + " inner join mensagens mens"
			  + " on mens.id_usuario_envio = mens2.id_usuario_envio and mens.dt_envio = mens2.dt_envio"
			  + " inner join mensagens_destinatario mens_dest"
			  + " on mens.id_mensagem = mens_dest.id_mensagem"
			  + " where mens_dest.id_usuario_destino = ?"
			  + " group by mens.id_usuario_envio"
			  + " order by mens.dt_envio desc",nativeQuery = true)
	List<Mensagem> getMensagensRecebidas(Long id);

}
