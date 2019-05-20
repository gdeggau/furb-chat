package br.com.tomaggau.pzi.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tomaggau.pzi.enums.Destino;
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
	private UsuarioService usuarioService;
	
	public Mensagem save(Long id, Mensagem mensagem, Destino destino) {
		//mensagem para um usuário
		if(destino.equals(Destino.USUARIO)) {
			mensagem.setDtEnvio(LocalDateTime.now());
			mensagem.setFlTipoMensagem('T');
			mensagem.setIdUsuarioEnvio(usuarioService.findById(mensagem.getIdUsuarioEnvio().getIdUsuario()));
			
			MensagemDestinatario destinatario = new MensagemDestinatario();
			Mensagem mensagemSalva = mensagemRepository.save(mensagem);
			
			destinatario.setIdMensagem(mensagem);
			destinatario.setIdUsuarioDestino(usuarioService.findById(id));
			destinatario.setFlLida('N');
			
			mensagemDestinarioService.save(destinatario);
			
			return mensagemSalva;
		}else {
			throw new RuntimeException();
		}
		
	}

	public List<Mensagem> getMensagensUsuario(Long id, Usuario usuario) {
		return mensagemRepository.getMensagensUsuario(id, usuario.getIdUsuario());
	}
	
	public List<Mensagem> getMensagensTrocadasUsuario(Long id, Usuario usuario) {
		return mensagemRepository.getMensagensTrocadasUsuario(id, usuario.getIdUsuario());
	}
	
	/*
	@Autowired
	UsuarioRepository usuarioRepository;
	
	//Criar usuario
	public UsuarioEntity salvarUsuario(UsuarioEntity usuario) {
		return usuarioRepository.save(usuario);
	}
	
	//Listar todos os usuarios
	public List<UsuarioEntity> listarUsuarios() {
		return usuarioRepository.findAll();
	}
	
	//Buscar usuario
	public UsuarioEntity buscarUsuario(Long usuarioId) {
		return usuarioRepository.findById(usuarioId).orElse(null);
	}
	
	//Deletar usuario
	public void deletarUsuario(UsuarioEntity usuario) {
		usuario.setAtivo(false);
		usuarioRepository.save(usuario);
	}
	*/

}
