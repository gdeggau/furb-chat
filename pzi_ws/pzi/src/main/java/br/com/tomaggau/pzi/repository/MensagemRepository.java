package br.com.tomaggau.pzi.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.tomaggau.pzi.model.Mensagem;

@Repository
public interface MensagemRepository extends JpaRepository<Mensagem, Long>{
	
	Mensagem findByIdMensagem(Long id);
	
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
	
	@Query(value="select mens.* from mensagens mens"
			  + " inner join mensagens_destinatario mens_dest"
			  + " on mens.id_mensagem = mens_dest.id_mensagem"
			  + " inner join ("
			  + " 	select m.id_usuario_envio, max(m.dt_envio) dt_envio from mensagens_destinatario md"
			  + " 	inner join mensagens m"
			  + " 	on m.id_mensagem = md.id_mensagem"
			  + " 	where md.id_usuario_destino = ?"
			  + " 	group by m.id_usuario_envio"
			  + " ) mens2"
			  + " on mens2.id_usuario_envio = mens.id_usuario_envio and mens2.dt_envio = mens.dt_envio"
			  + " order by mens.dt_envio desc",nativeQuery = true)
	List<Mensagem> getMensagensRecebidasUsuarios(Long id);
	
	@Query(value="select mens.* from mensagens mens" + 
			" inner join mensagens_destinatario mens_dest" + 
			" on mens.id_mensagem = mens_dest.id_mensagem" + 
			" inner join (" + 
			"	select md.id_usuario_destino, max(m.dt_envio) dt_envio from mensagens_destinatario md" + 
			"	inner join mensagens m" + 
			"	on m.id_mensagem = md.id_mensagem" + 
			"	where m.id_usuario_envio = ? and md.id_usuario_destino is not null" + 
			"	group by md.id_usuario_destino" + 
			" ) mens2" + 
			" on mens2.id_usuario_destino = mens_dest.id_usuario_destino and mens2.dt_envio = mens.dt_envio" + 
			" order by mens.dt_envio desc", nativeQuery = true)
	List<Mensagem> getMensagensEnviadasUsuarios(Long id);
	
	@Query(value="select mens.* from mensagens mens" + 
			" inner join (" + 
			"	select mens_dest.id_usuario_destino, mens.id_usuario_envio from mensagens mens" + 
			"	inner join mensagens_destinatario mens_dest" + 
			"	on mens_dest.id_mensagem = mens.id_mensagem" + 
			"	where mens.id_mensagem = ?" + 
			" ) mens2" + 
			" inner join mensagens_destinatario mens_dest" + 
			" on mens.id_mensagem = mens_dest.id_mensagem" + 
			" where (mens.id_usuario_envio = mens2.id_usuario_envio and mens_dest.id_usuario_destino = mens2.id_usuario_destino) " + 
			" OR (mens.id_usuario_envio = mens2.id_usuario_destino and mens_dest.id_usuario_destino = mens2.id_usuario_envio)" + 
			" order by mens.dt_envio;", nativeQuery = true)
	List<Mensagem> getMensagensTrocadasBaseadaNoIdMensagem(Long id);
	
	@Query(value="select mens.* from mensagens mens" + 
			" inner join mensagens_destinatario mens_dest" + 
			" on mens.id_mensagem = mens_dest.id_mensagem" + 
			" inner join grupos_usuarios gpuser" + 
			" on gpuser.id_grupos_usuarios = mens_dest.id_grupos_usuarios_destino" + 
			" inner join grupos g" + 
			" on g.id_grupo = gpuser.id_grupo" + 
			" inner join (" + 
			"	select gp.id_grupo, max(m.dt_envio) dt_envio, gp_user.id_usuario from mensagens_destinatario md" + 
			"	inner join mensagens m" + 
			"	on m.id_mensagem = md.id_mensagem" + 
			"	inner join grupos_usuarios gp_user" + 
			"	on gp_user.id_grupos_usuarios = md.id_grupos_usuarios_destino" + 
			"	inner join grupos gp" + 
			"	on gp.id_grupo = gp_user.id_grupo" + 
			"	where gp_user.id_usuario = ?" + 
			"	group by gp.id_grupo" + 
			" ) mens2" + 
			" on mens2.id_grupo = g.id_grupo and mens2.dt_envio = mens.dt_envio and mens2.id_usuario = gpuser.id_usuario" + 
			" order by mens.dt_envio desc", nativeQuery = true)
	List<Mensagem> getMensagensDosGrupos(Long idOrigem);
		
}
