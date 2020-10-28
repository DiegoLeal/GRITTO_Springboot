package br.com.gritto.gritto4.services;

import br.com.gritto.gritto4.config.DefaultService;
import br.com.gritto.gritto4.domain.Publicacao;
import br.com.gritto.gritto4.repository.PublicacaoRepository;
import org.springframework.stereotype.Service;

@Service
public class PublicacaoService extends DefaultService<PublicacaoRepository, Publicacao> {

}
