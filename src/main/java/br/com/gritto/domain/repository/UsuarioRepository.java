package br.com.gritto.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gritto.domain.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Usuario findOneByEmail(String email);
	List<Usuario> findByNomeContaining(String nome);
	Usuario findByEmail(String email);
	Usuario findByCpf(String cpf);
	Object findByNome(Long id);
	
    
}
