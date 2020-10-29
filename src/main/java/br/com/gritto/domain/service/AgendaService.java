package br.com.gritto.domain.service;

import org.springframework.stereotype.Service;

import br.com.gritto.config.DefaultService;
import br.com.gritto.domain.model.Agenda;
import br.com.gritto.domain.repository.AgendaRepository;

@Service
public class AgendaService extends DefaultService<AgendaRepository, Agenda> {

}
