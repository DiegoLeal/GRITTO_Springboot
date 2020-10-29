package br.com.gritto.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gritto.domain.model.Publicacao;

@Repository
public interface PublicacaoRepository extends JpaRepository<Publicacao, Long> {
}
