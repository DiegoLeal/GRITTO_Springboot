package br.com.gritto.gritto4.resources;


import br.com.gritto.gritto4.domain.Publicacao;
import br.com.gritto.gritto4.services.PublicacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/publicacao")
@RequiredArgsConstructor
public class PublicacaoResource {

  private final PublicacaoService service;

  @PutMapping
  @ResponseBody
  public ResponseEntity<Publicacao> savePublicacao(@RequestBody Publicacao publicacao) {
    return ResponseEntity.ok(service.save(publicacao));
  }

}
