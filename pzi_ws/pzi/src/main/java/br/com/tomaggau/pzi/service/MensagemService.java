package br.com.tomaggau.pzi.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tomaggau.pzi.enums.Destino;
import br.com.tomaggau.pzi.model.Grupo;
import br.com.tomaggau.pzi.model.GrupoUsuario;
import br.com.tomaggau.pzi.model.Mensagem;
import br.com.tomaggau.pzi.model.MensagemDestinatario;
import br.com.tomaggau.pzi.model.Usuario;
import br.com.tomaggau.pzi.repository.MensagemRepository;

@Service
public class MensagemService {
	
	@Autowired
	private MensagemRepository mensagemRepository;
	
	@Autowired
	private MensagemDestinatarioService mensagemDestinarioService;
	
	@Autowired
	private GrupoUsuarioService grupoUsuarioService;
	
	@Autowired
	private GrupoService grupoService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	public Mensagem save(Long id, Mensagem mensagem, Destino destino) {
		
		mensagem.setDtEnvio(LocalDateTime.now());
		mensagem.setFlTipoMensagem('T');
		Mensagem mensagemSalva = mensagemRepository.save(mensagem);
		
		MensagemDestinatario destinatario;
		
		//mensagem para um usuário
		if(destino.equals(Destino.USUARIO)) {
			destinatario = new MensagemDestinatario();
			destinatario.setIdMensagem(mensagem);
			destinatario.setIdUsuarioDestino(usuarioService.findById(id));
			destinatario.setIdGruposUsuariosDestino(null);
			destinatario.setFlLida('N');
			mensagemDestinarioService.save(destinatario);
			return mensagemSalva;
		}else if(destino.equals(Destino.GRUPO)){
			Grupo grupo = grupoService.findById(id);
			List<GrupoUsuario> membrosGrupo = grupoUsuarioService.findAllUsersInGroup(grupo);
			for (GrupoUsuario grupoUsuario : membrosGrupo) {
				destinatario = new MensagemDestinatario();
				destinatario.setIdMensagem(mensagem);
				destinatario.setIdGruposUsuariosDestino(grupoUsuario);
				destinatario.setIdUsuarioDestino(null);
				destinatario.setFlLida('N');
				mensagemDestinarioService.save(destinatario);
			}
			return mensagemSalva;
		}else {
			throw new RuntimeException();
		}
		
	}
	
	public List<Mensagem> getMensagensTrocadasUsuario(Long idOrigem, Long idDestino) {
		return mensagemRepository.getMensagensTrocadasUsuario(idOrigem, idDestino);
	}

	public List<Mensagem> getMensagensTrocadasGrupo(Long id) {
		return mensagemRepository.getMensagensTrocadasGrupo(id);
	}

	public List<Mensagem> getMensagensRecebidas(Long idOrigem) {
		return mensagemRepository.getMensagensRecebidas(idOrigem);
	}
	
}
