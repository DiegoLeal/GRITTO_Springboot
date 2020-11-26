package br.com.gritto.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

	@NotBlank
	@Size(max = 9, message = "error.endereco.cep.max")
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
