package br.com.tomaggau.pzi.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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
		
		mensagem.setIdUsuarioEnvio(usuarioService.findById(mensagem.getIdUsuarioEnvio().getIdUsuario()));
		mensagem.setDtEnvio(LocalDateTime.now());
		mensagem.setFlTipoMensagem('T');
		mensagem.setFlDestino(destino.getDescricao());
		mensagem.setIdDestino(id);
		Mensagem mensagemSalva;
		
		MensagemDestinatario destinatario;
		
		//mensagem para um usuário
		if(destino.equals(Destino.USUARIO)) {
			mensagem.setDsTituloConversa(usuarioService.findById(id).getNmExibicao());
			mensagemSalva = mensagemRepository.save(mensagem);
			destinatario = new MensagemDestinatario();
			destinatario.setIdMensagem(mensagem);
			destinatario.setIdUsuarioDestino(usuarioService.findById(id));
			destinatario.setIdGruposUsuariosDestino(null);
			destinatario.setFlLida('N');
			mensagemDestinarioService.save(destinatario);
			return mensagemSalva;
		}else if(destino.equals(Destino.GRUPO)){
			Grupo grupo = grupoService.findById(id);
			mensagem.setDsTituloConversa(grupo.getNmGrupo());
			mensagemSalva = mensagemRepository.save(mensagem);
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
		
		List<Mensagem> mensRecebidas = mensagemRepository.getMensagensRecebidasUsuarios(idOrigem);
		List<Mensagem> mensEnviadas = mensagemRepository.getMensagensEnviadasUsuarios(idOrigem);
		List<Mensagem> mensGrupos = mensagemRepository.getMensagensDosGrupos(idOrigem);
		
		List<Mensagem> mensagensFiltradas = new ArrayList<Mensagem>();
		
		if(mensEnviadas.size() > 0) {
			for (Mensagem mensagemEnviada : mensEnviadas) {
				Long idUsuarioDestino = mensagemDestinarioService.findByIdMensagem(mensagemEnviada).getIdUsuarioDestino().getIdUsuario();
				Usuario usuarioDestino = usuarioService.findById(idUsuarioDestino);
				boolean achouUsuario = false;
				for(Mensagem mensagemRecebida : mensRecebidas) {
					Usuario usuarioEnvio = usuarioService.findById(mensagemRecebida.getIdUsuarioEnvio().getIdUsuario());
					if(usuarioEnvio.getIdUsuario() == usuarioDestino.getIdUsuario()) {
						achouUsuario = true;
						if(mensagemRecebida.getDtEnvio().isAfter(mensagemEnviada.getDtEnvio())) {
							mensagemRecebida.setDsTituloConversa(usuarioEnvio.getNmExibicao());
							mensagensFiltradas.add(mensagemRecebida);
						} else {
							mensagemEnviada.setDsTituloConversa(usuarioEnvio.getNmExibicao());
							mensagensFiltradas.add(mensagemEnviada);
						}
					}
				}
				if(achouUsuario == false) {
					mensagemEnviada.setDsTituloConversa(usuarioDestino.getNmExibicao());
					mensagensFiltradas.add(mensagemEnviada);
				}
			}
		} else {
			for (Mensagem mensagRecebida : mensRecebidas) {
				mensagensFiltradas.add(mensagRecebida);
			}
		}
		
		for (Mensagem mensagem : mensGrupos) {
			mensagensFiltradas.add(mensagem);
		}		
		
		List<Mensagem> mensagensOrdenadas = new ArrayList<Mensagem>(mensagensFiltradas);
		mensagensOrdenadas.sort(Comparator.comparing(Mensagem::getDtEnvio).reversed());
		
		return mensagensOrdenadas;
	}

	public List<Mensagem> getMensagensTrocadasBaseadaNoIdMensagem(Long idMensagem) {
		return mensagemRepository.getMensagensTrocadasBaseadaNoIdMensagem(idMensagem);
	}

	public List<Mensagem> getMensagenTrocadasEntreLogadoEDestino(Long idOrigem, Long idDestino, Destino destino) {

		if(destino.equals(Destino.USUARIO)) {
			return getMensagensTrocadasUsuario(idOrigem, idDestino);
		}else {
			return getMensagensTrocadasGrupo(idDestino);
		}
		
	}
	
	public Mensagem findByIdMensagem(Long id) {
		return mensagemRepository.findByIdMensagem(id);
	}
	
}
