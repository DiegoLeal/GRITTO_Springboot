package br.com.gritto.gritto4.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gritto.gritto4.domain.Usuario;
import br.com.gritto.gritto4.dto.UsuarioDTO;
import br.com.gritto.gritto4.repository.UsuarioRepository;
import br.com.gritto.gritto4.services.exception.ObjectNotFoundException;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repo;
	
	public List<Usuario> findAll() {
		return repo.findAll();		
	}
	
	public Usuario findById(Long id) {
		Optional<Usuario> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(id));
		
		
	}
	
	public Usuario insert(Usuario obj) {
		return repo.save(obj);
	}
	
	public void delete(Long id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public Usuario update(Usuario obj) {
		Usuario newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	private void updateData(Usuario newObj, Usuario obj) {
		newObj.setNome(obj.getNome());
		newObj.setRg(obj.getRg());
		newObj.setCpf(obj.getCpf());
		newObj.setDataNascimento(obj.getDataNascimento());
		newObj.setTelefone(obj.getTelefone());
		newObj.setSenha(obj.getSenha());
		newObj.setEmail(obj.getEmail());
		newObj.setSexo(obj.getSexo());		
	}

	public Usuario fromDTO(UsuarioDTO objDto) {
		return new Usuario(objDto.getId(), objDto.getNome(), objDto.getRg(), objDto.getCpf(), objDto.getDataNascimento(), objDto.getTelefone(), objDto.getSenha(), objDto.getEmail(), objDto.getSexo());
	}
}
