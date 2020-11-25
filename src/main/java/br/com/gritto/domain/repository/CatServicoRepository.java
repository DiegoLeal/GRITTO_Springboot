package br.com.gritto.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gritto.domain.model.CatServico;

@Repository
public interface CatServicoRepository extends JpaRepository<CatServico, Long> {
	
	List<CatServico> findByProfissao(String profissao);	
	List<CatServico> findByProfissaoContaining(String profissao);

}
