package br.com.gritto.domain.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Agenda implements Model {

  private static final long serialVersionUID = -1651127424730685074L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private LocalDate data;
  
  @Size(max = 45)
  private String descricao;

  @Size(max = 45)
  private String historico;

  @NotNull(message = "agenda.hora.empty")
  private LocalTime hora;

}