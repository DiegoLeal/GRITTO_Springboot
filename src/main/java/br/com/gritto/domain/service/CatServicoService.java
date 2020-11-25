package br.com.gritto.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gritto.domain.model.CatServico;
import br.com.gritto.domain.model.Usuario;
import br.com.gritto.domain.repository.CatServicoRepository;
import br.com.gritto.domain.repository.UsuarioRepository;

@Service
public class CatServicoService {
	
	@Autowired
	private CatServicoRepository catServicoRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public CatServico criar(CatServico catServico) throws Exception {
		Usuario usuario = usuarioRepository.findById(catServico.getUsuario().getId())
				.orElseThrow(() -> new Exception("Usuario não encontrado"));
		
		catServico.setUsuario(usuario);
		return catServicoRepository.save(catServico);
	}
	
    public CatServico salvar(CatServico catServico) {
		
		return catServicoRepository.save(catServico);
	}

	public void excluir(Long usuarioId) {		
		catServicoRepository.deleteById(usuarioId);
	}

}
