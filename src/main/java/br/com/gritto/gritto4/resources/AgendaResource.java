package br.com.gritto.gritto4.resources;

import br.com.gritto.gritto4.domain.Agenda;
import br.com.gritto.gritto4.services.AgendaService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/agenda")
@RequiredArgsConstructor
public class AgendaResource {

  private final AgendaService service;

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
