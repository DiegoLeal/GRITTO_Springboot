package br.com.gritto.gritto4.dto;

import java.io.Serializable;

import br.com.gritto.gritto4.domain.Usuario;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UsuarioDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private String rg;
	private String cpf;
	private String dataNascimento;
	private String telefone;
	private String senha;
	private String email;
	private String sexo;

}
