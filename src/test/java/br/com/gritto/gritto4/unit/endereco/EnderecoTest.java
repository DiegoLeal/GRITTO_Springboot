package br.com.gritto.gritto4.unit.endereco;

import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.validation.ValidationException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.gritto.domain.model.Endereco;
import br.com.gritto.gritto4.DefaultSpringUnitTest;

class EnderecoTest extends DefaultSpringUnitTest<Endereco> {

	private Endereco endereco;


	@BeforeEach
	void beforeRun() {		
		endereco = Endereco.builder()
				.cep("99999999")
				.build();
	}
	
	@Test
	void deveRetornarErroDeTamanhoMaximoHibernate() {
		endereco.setCep("9".repeat(1000));
		assertThrows(ValidationException.class, () -> saveForError(endereco));
		
	}
	
	@Test
	void deveRetornarErroAoSavarEnderecoVaziu() {
		endereco.setCep("");
		assertThrows(ValidationException.class, () -> saveForError(endereco));
	}

}
