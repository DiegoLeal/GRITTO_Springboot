package br.com.gritto.gritto4.resources;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.gritto.gritto4.domain.Publicacao;
import br.com.gritto.gritto4.services.PublicacaoService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/publicacao")
@RequiredArgsConstructor
public class PublicacaoResource {

  private final PublicacaoService service = new PublicacaoService();

  @PutMapping
  @ResponseBody
  public ResponseEntity<Publicacao> savePublicacao(@RequestBody Publicacao publicacao) {
    return ResponseEntity.ok(service.save(publicacao));
  }

}