package br.com.gritto.gritto4;

import br.com.gritto.gritto4.domain.Agenda;
import br.com.gritto.gritto4.repository.AgendaRepository;
import br.com.gritto.gritto4.services.AgendaService;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class AgendaServiceTest extends DefaultSpringBootRunnerTest{

  @Autowired
  private AgendaService agendaService;

  @MockBean
  private AgendaRepository agendaRepository;

  @Before
  public void beforeAll(){
    when(agendaRepository.save(any()))
            .thenReturn(Agenda.builder().id(1L).build());
  }

  @Test
  public void shouldSaveAgenda() {
    Agenda teste = agendaService
            .save(buildAgendaForTest());
    Assertions.assertThat(teste)
            .isNotNull()
            .hasFieldOrPropertyWithValue("id", 1L);

  }

  private Agenda buildAgendaForTest() {
    return Agenda.builder()
            .descricao("teste")
            .historico("teste")
            .build();
  }

}
