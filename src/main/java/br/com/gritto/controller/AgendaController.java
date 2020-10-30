package br.com.gritto.controller;

import lombok.AllArgsConstructor;
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

import br.com.gritto.domain.model.Agenda;
import br.com.gritto.domain.service.AgendaService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/agenda")
@AllArgsConstructor
public class AgendaController {

  private AgendaService service;

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