package br.com.gritto.gritto4.resources;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gritto.gritto4.domain.Agenda;
import br.com.gritto.gritto4.services.AgendaService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/agenda")
@RequiredArgsConstructor
public class AgendaResource {

  private final AgendaService service = new AgendaService();

  @PutMapping
  public ResponseEntity<Agenda> save(@RequestBody Agenda agenda) {
    return ResponseEntity.ok(service.save(agenda));
  }

  @PostMapping
  public ResponseEntity<Agenda> update(@RequestBody Agenda agenda) {
    return ResponseEntity.ok(service.update(agenda));
  }

  @GetMapping("{id}")
  public ResponseEntity<Agenda> getAgendaById(@PathVariable Long id) {
    return ResponseEntity.ok(service.get(id));
  }

  @GetMapping
  public ResponseEntity<Page<Agenda>> getAllAgendas(Pageable page) {
    return ResponseEntity.ok(service.findAll(page));
  }

}