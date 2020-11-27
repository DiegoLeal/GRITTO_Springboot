package br.com.gritto.domain.service;

import br.com.gritto.domain.repository.ChatRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gritto.domain.model.Chat;

@Service
public class ChatService {

    @Autowired
    private ChatRepository ChatRepository;

    public Chat salvar(Chat Chat) throws Exception {
        Chat ChatExistente = ChatRepository.findByTexto(Chat.getTexto());

        if (ChatExistente != null && !ChatExistente.equals(Chat)) {
            throw new Exception("Já exixte um Texto");
        }
        return ChatRepository.save(Chat);
    }

    public void excluir(Long ChatId) { ChatRepository.deleteById(ChatId); }

}

