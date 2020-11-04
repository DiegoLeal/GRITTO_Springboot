package br.com.gritto.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.gritto.domain.model.Usuario;
import br.com.gritto.domain.repository.UsuarioRepository;
import br.com.gritto.domain.service.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/usuarios")
@Api(value = "API REST Usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private UsuarioService cadastroUsuario;	
	
	@GetMapping
	@ApiOperation(value = "Retorna uma lista de usuarios")
	public List<Usuario> listar() {
		return usuarioRepository.findAll();
	}
	
	@GetMapping("{usuarioId}")
	@ApiOperation(value = "Retorna um usuario")
	public ResponseEntity<Usuario> buscar (@PathVariable Long usuarioId) {
		Optional<Usuario> usuario = usuarioRepository.findById(usuarioId);
		
		if (usuario.isPresent()) {
			return ResponseEntity.ok(usuario.get());
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ApiOperation(value = "Salva um usuario")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario adicionar(@Valid @RequestBody Usuario usuario) throws Exception {
		return cadastroUsuario.salvar(usuario);
	}
	
	@PutMapping("/{usuarioId}")
	@ApiOperation(value = "Atualiza um usuario")
	public ResponseEntity<Usuario> Atualizar(@Valid @PathVariable Long usuarioId,
			@RequestBody Usuario usuario) throws Exception {
		
		if (!usuarioRepository.existsById(usuarioId)) {
			return ResponseEntity.notFound().build();
		}
		
		usuario.setId(usuarioId);
		usuario = cadastroUsuario.salvar(usuario);
		
		return ResponseEntity.ok(usuario);
	}
	
	@DeleteMapping("/{usuarioId}")
	@ApiOperation(value = "Deleta um usuario")
	public ResponseEntity<Void> remover(@PathVariable Long usuarioId) {
		if (!usuarioRepository.existsById(usuarioId)) {
			return ResponseEntity.notFound().build();
		}
		
		cadastroUsuario.excluir(usuarioId);
		
		return ResponseEntity.noContent().build();
	}

}
