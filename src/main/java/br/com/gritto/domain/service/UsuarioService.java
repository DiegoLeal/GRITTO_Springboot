package br.com.gritto.domain.service;

import br.com.gritto.domain.model.Usuario;
import br.com.gritto.domain.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private PasswordEncoder encoder;
	
	public Usuario salvar(Usuario usuario) throws Exception {
		Usuario usuarioExis = usuarioRepository.findByCpf(usuario.getCpf());

		if (usuarioExis != null && !usuarioExis.equals(usuario)) {
			throw new Exception("Já exixte um Usuario cadastrado com este CPF");
		}

		String encodedPassword = encoder.encode(usuario.getSenha());
		usuario.setSenha(encodedPassword);

		return usuarioRepository.save(usuario);
	}

	
  public Usuario atualizar(Usuario usuario) {
		
		return UsuarioRepository.save(usuario);
	}
  
	public void excluir(Long UsuarioId) {
		usuarioRepository.deleteById(UsuarioId);
	}

	public Usuario getUser(String username) {
		return usuarioRepository.findOneByEmail(username);
	}


}