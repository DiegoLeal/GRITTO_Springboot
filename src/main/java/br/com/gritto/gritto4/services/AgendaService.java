package br.com.gritto.gritto4.services;

import br.com.gritto.gritto4.config.DefaultService;
import br.com.gritto.gritto4.domain.Agenda;
import br.com.gritto.gritto4.repository.AgendaRepository;
import org.springframework.stereotype.Service;

@Service
public class AgendaService extends DefaultService<AgendaRepository, Agenda> {

}
