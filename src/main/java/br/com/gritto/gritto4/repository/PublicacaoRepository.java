package br.com.gritto.gritto4.repository;

import br.com.gritto.gritto4.domain.Publicacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicacaoRepository extends JpaRepository<Publicacao, Long> {
}
