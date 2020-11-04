package br.com.gritto.domain.repository;

import br.com.gritto.domain.model.Bairro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BairroRepository extends JpaRepository<Bairro, Long> {
}
