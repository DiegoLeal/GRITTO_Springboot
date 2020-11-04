package br.com.gritto.config;

import br.com.gritto.domain.model.Model;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

public class DefaultController<T extends Model, S extends DefaultService<?, T>> {

  @Getter
  @Setter
  @Autowired
  private S service;

  @PutMapping
  @ResponseBody
  public ResponseEntity<T> save(@RequestBody T entity) {
    return ResponseEntity.ok(service.save(entity));
  }

  @GetMapping
  @ResponseBody
  public ResponseEntity<Page<T>> findAll(Pageable pageable) {
    return ResponseEntity.ok(service.findAll(pageable));
  }


}
