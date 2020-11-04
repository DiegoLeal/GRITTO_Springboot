package br.com.gritto.domain.service;

import br.com.gritto.config.DefaultService;
import br.com.gritto.domain.model.Endereco;
import br.com.gritto.domain.repository.EnderecoRepository;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService extends DefaultService<EnderecoRepository, Endereco> {
}
