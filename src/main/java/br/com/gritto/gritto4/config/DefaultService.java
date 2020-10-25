package br.com.gritto.gritto4.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public class DefaultService<R extends JpaRepository<E, Long>, E> {

  @Autowired
  private R repository;

  public E save(E entity) {
    return repository.save(entity);
  }

  public E update(E entity) {
    return repository.save(entity);
  }

  public E get(Long id) {
    return repository.getOne(id);
  }

  public Page<E> findAll(Pageable page) {
    return repository.findAll(page);
  }

  public void delete(Long id) {
    repository.deleteById(id);
  }


}
