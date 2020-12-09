package br.com.gritto.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Publicacao implements Model {

	private static final long serialVersionUID = -3447556886413066683L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Size(max = 280)
	private String descricao;

	@Size(max = 60)
	private String foto;

	@JoinColumn(name = "usuario_id")
	@ManyToOne
	@JsonBackReference
	private Usuario usuario;

	private Endereco endereco;

	//private CatServico catServico;

	private Integer numero;

	@Size(max = 45)
	private String complemento;

}