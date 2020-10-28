package br.com.gritto.gritto4.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Publicacao implements Model {

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

//  private Object endereco;

//  private Object catServico;

  private Integer numero;

  @Size(max = 45, message = "")
  private String complemento;

}
