package br.com.gritto.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.gritto.domain.model.CatServico;
import br.com.gritto.domain.repository.CatServicoRepository;
import br.com.gritto.domain.service.CatServicoService;

@RestController
@RequestMapping("/categoria-servico")
public class CatServicoController {
	
	@Autowired
	private CatServicoRepository catServicoRepository;
	
	@Autowired
	private CatServicoService catServicoService;
	
	@GetMapping
	public List<CatServico> listar() {
		return catServicoRepository.findAll();
	}
	
	@GetMapping("/{usuarioId}")
	public ResponseEntity<CatServico> buscar(@PathVariable Long usuarioId) {
		Optional<CatServico> catServico = catServicoRepository.findById(usuarioId);
		
		if (catServico.isPresent()) {
			return ResponseEntity.ok(catServico.get());
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CatServico criar(@RequestBody CatServico catServico) throws Exception {
		
		return catServicoService.criar(catServico);
		
	}
	
	@PutMapping("/{usuarioId}")
	public ResponseEntity<CatServico> atualizar(@Valid @PathVariable Long usuarioId,
			@RequestBody CatServico catServico) {
		
		if (!catServicoRepository.existsById(usuarioId)) {
			return ResponseEntity.notFound().build();
		}
		
		catServico.setId(usuarioId);
		//catServico = catServicoService.salvar(catServico);
		
		return ResponseEntity.ok(catServico);
	}
	
	@DeleteMapping("/{usuarioId}")
	public ResponseEntity<Void> remover(@PathVariable Long usuarioId) {
		if (!catServicoRepository.existsById(usuarioId)) {
			return ResponseEntity.notFound().build();
		}
		
		catServicoService.excluir(usuarioId);
		
		return ResponseEntity.noContent().build();
	}


}
