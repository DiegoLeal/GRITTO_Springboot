package br.com.gritto.controller;


import br.com.gritto.domain.model.Publicacao;
import br.com.gritto.domain.service.PublicacaoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/publicacao")
@AllArgsConstructor
public class PublicacaoController {

  private PublicacaoService service;

  @PutMapping
  @ResponseBody
  public ResponseEntity<Publicacao> savePublicacao(@RequestBody Publicacao publicacao) {
    return ResponseEntity.ok(service.save(publicacao));
  }

}