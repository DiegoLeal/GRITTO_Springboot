package br.com.gritto.gritto4.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.gritto.gritto4.domain.Usuario;
import br.com.gritto.gritto4.dto.UsuarioDTO;
import br.com.gritto.gritto4.services.UsuarioService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value="/usuarios")
public class UsuarioResource {
	
	@Autowired
	private UsuarioService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<UsuarioDTO>> findAll() {
		List<Usuario> list = service.findAll();
		List<UsuarioDTO> listDTO = list.stream().map(x -> new UsuarioDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);	
	}
	
	@RequestMapping(value="/usuarios/{id}", method=RequestMethod.GET)
	public ResponseEntity<UsuarioDTO> finBayId(@PathVariable Long id) {
		Usuario obj = service.findById(id);
		return ResponseEntity.ok().body(new UsuarioDTO(obj));
	}	
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody UsuarioDTO objDTO) {
		Usuario obj = service.fromDTO(objDTO);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/usuarios/{id}", method=RequestMethod.DELETE)
 	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/usuarios/{id}", method=RequestMethod.PUT)
 	public ResponseEntity<Void> update(@RequestBody UsuarioDTO objDto, @PathVariable Long id) {
		Usuario obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	/*@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Usuario>> findAll() {
		List<Usuario> list = new ArrayList<>();
		Usuario vitoria = new Usuario("1", "Vitória Silveira", "22.610.093-5", "699.620.573-53", new Date(1966-06-14), "(95) 99245-1738", "3Z0oLGgMiH", "vitoriasilveira@skapcom.com", "F");
		Usuario vicente = new Usuario("2", "Vicente Santos", "25.791.644-1", "573.849.058-42", new Date(1969-01-17), "(16) 98262-7375", "rRTDKtCOP3", "vicentesantos@gmail.com", "M");
		list.addAll(Arrays.asList(vitoria, vicente));
		return ResponseEntity.ok().body(list);	
   }*/
	
}	
