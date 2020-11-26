package br.com.gritto.controller;

import br.com.gritto.domain.model.Chat;
import br.com.gritto.domain.repository.ChatRepository;
import br.com.gritto.domain.service.ChatService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@CrossOrigin(origins ="*")
@RestController
@RequestMapping("/chats")
@Resource
public class ChatController {

    @Autowired
    private ChatRepository chatRepository;

    @Autowired
    private ChatService cadastroChat;

    @GetMapping
    public List<Chat> listar() {
        return chatRepository.findAll();
    }

    @GetMapping("{chatId}")
    public ResponseEntity<Chat> buscar (@PathVariable Long chatId) {
        Optional<Chat> chat = chatRepository.findById(chatId);

        if (chat.isPresent()) {
            return ResponseEntity.ok(chat.get());
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Chat adicionar(@Valid @RequestBody Chat chat) throws Exception {
        return cadastroChat.salvar(chat);
    }

    @PutMapping("/{chatId}")
    public ResponseEntity<Chat> Atualizar(@Valid @PathVariable Long chatId,
                                          @RequestBody Chat chat) throws Exception {

        if (!chatRepository.existsById(chatId)) {
            return ResponseEntity.notFound().build();
        }

        chat.setId(chatId);
        chat = cadastroChat.salvar(chat);

        return ResponseEntity.ok(chat);
    }

    @DeleteMapping("/{chatId}")
    public ResponseEntity<Void> remover(@PathVariable Long chatId) {
        if (!chatRepository.existsById(chatId)) {
            return ResponseEntity.notFound().build();
        }

        cadastroChat.excluir(chatId);

        return ResponseEntity.noContent().build();
    }

}