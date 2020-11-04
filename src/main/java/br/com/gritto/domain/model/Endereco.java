package br.com.gritto.domain.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Endereco implements Model {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String cep;

  @ManyToOne
  private Cidade cidade;

  @ManyToOne
  private Rua rua;

  @ManyToOne
  private Bairro bairro;

@Override
public Long getId() {
	// TODO Auto-generated method stub
	return null;
}

}
