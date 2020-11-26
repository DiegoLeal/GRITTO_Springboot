package br.com.gritto.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonView;

import br.com.gritto.config.view.Views;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CatServico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.CatServico.class)
	private Long id;
	
	@ManyToOne
	@JsonView(Views.CatServico.class)
	private Usuario usuario;
	
	@JsonView(Views.CatServico.class)
	private String profissao;
		
}
