package br.com.gritto.domain.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cidade implements Model{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nome;

  @ManyToOne
  private UniaoFederativa uf;

@Override
public Long getId() {
	// TODO Auto-generated method stub
	return null;
}

}
