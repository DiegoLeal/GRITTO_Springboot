package br.com.gritto.gritto.domain.service;

import org.springframework.stereotype.Service;

import br.com.gritto.gritto.config.DefaultService;
import br.com.gritto.gritto.domain.model.Publicacao;
import br.com.gritto.gritto.domain.repository.PublicacaoRepository;

@Service
public class PublicacaoService extends DefaultService<PublicacaoRepository, Publicacao> {

}
