package br.com.gritto.domain.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UniaoFederativa implements Model {

	private static final long serialVersionUID = 1L;

@Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nome;

@Override
public Long getId() {
	// TODO Auto-generated method stub
	return null;
}

}
