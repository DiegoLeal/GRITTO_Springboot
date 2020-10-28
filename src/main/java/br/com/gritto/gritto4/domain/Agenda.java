package br.com.gritto.gritto4.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

  private String descricao;

  private String historico;

  private LocalTime hora;

@Override
public Long getId() {
	// TODO Auto-generated method stub
	return null;
}
}