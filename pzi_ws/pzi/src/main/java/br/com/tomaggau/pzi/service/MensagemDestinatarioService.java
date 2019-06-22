package br.com.tomaggau.pzi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tomaggau.pzi.model.Mensagem;
import br.com.tomaggau.pzi.model.MensagemDestinatario;
import br.com.tomaggau.pzi.repository.MensagemDestinatarioRepository;

@Service
public class MensagemDestinatarioService {
	
	@Autowired
	private MensagemDestinatarioRepository mensagemDestinatarioRepository;
	
	public MensagemDestinatario save(MensagemDestinatario mensagem) {
		return mensagemDestinatarioRepository.save(mensagem);
	}
	
	public MensagemDestinatario findByIdMensagem(Mensagem mensagem) {
		return mensagemDestinatarioRepository.findByIdMensagem(mensagem);
	}
	

}
