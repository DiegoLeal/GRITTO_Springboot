package br.com.gritto.domain.service;

import org.springframework.stereotype.Service;

import br.com.gritto.config.DefaultService;
import br.com.gritto.domain.model.Publicacao;
import br.com.gritto.domain.repository.PublicacaoRepository;

@Service
public class PublicacaoService extends DefaultService<PublicacaoRepository, Publicacao> {	

}
