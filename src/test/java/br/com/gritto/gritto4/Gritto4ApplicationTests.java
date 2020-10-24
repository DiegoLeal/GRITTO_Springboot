package br.com.gritto.gritto4;

import br.com.gritto.gritto4.domain.Usuario;
import br.com.gritto.gritto4.dto.UsuarioDTO;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Gritto4ApplicationTests {

	@Autowired
	ModelMapper mapper;

	@Test
	public void shouldMapperToDto() {
		Usuario usuario = Usuario.builder()
						.id(9999L)
						.nome("teste")
						.cpf("999999")
						.dataNascimento("17/10/1996")
						.email("teste@teste.com")
						.rg("999999")
						.senha("123123")
						.sexo("M")
						.telefone("303030")
						.build();

		UsuarioDTO usuarioDTO = mapper.map(usuario, UsuarioDTO.class);
		assertThat(usuarioDTO)
						.isNotNull()
						.hasFieldOrPropertyWithValue("nome", "teste")
						.hasFieldOrPropertyWithValue("cpf", "999999")
						.hasFieldOrPropertyWithValue("dataNascimento", "17/10/1996");

	}

}
