package br.com.gritto.gritto.domain.service;

import org.springframework.stereotype.Service;

import br.com.gritto.gritto.config.DefaultService;
import br.com.gritto.gritto.domain.model.Agenda;
import br.com.gritto.gritto.domain.repository.AgendaRepository;

@Service
public class AgendaService extends DefaultService<AgendaRepository, Agenda> {

}
