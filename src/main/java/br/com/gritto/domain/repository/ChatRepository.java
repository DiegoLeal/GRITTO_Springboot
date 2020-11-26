package br.com.gritto.domain.repository;

import br.com.gritto.domain.model.Chat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Long> {

    Chat findByTexto(String texto);


}
