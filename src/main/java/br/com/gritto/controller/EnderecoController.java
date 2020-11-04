package br.com.gritto.controller;

import br.com.gritto.config.DefaultController;
import br.com.gritto.domain.model.Endereco;
import br.com.gritto.domain.service.EnderecoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("endereco")
public class EnderecoController extends DefaultController<Endereco, EnderecoService> {
}
