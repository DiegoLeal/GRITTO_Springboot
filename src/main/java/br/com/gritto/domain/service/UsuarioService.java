package br.com.gritto.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gritto.domain.model.Usuario;
import br.com.gritto.domain.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository UsuarioRepository;
	
	public Usuario salvar(Usuario Usuario) throws Exception {
		Usuario UsuarioExistente = UsuarioRepository.findByEmail(Usuario.getEmail());
		
		if (UsuarioExistente != null && !UsuarioExistente.equals(Usuario)) {
			throw new Exception("Já exixte um Usuario cadastrado com este e-mail");
		}
		return UsuarioRepository.save(Usuario);
	}
	
	public void excluir(Long UsuarioId) {
		UsuarioRepository.deleteById(UsuarioId);
	}

}