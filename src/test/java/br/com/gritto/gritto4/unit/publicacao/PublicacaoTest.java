package br.com.gritto.gritto4.unit.publicacao;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.validation.ValidationException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.gritto.domain.model.Publicacao;
import br.com.gritto.gritto4.DefaultSpringUnitTest;

class PublicacaoTest extends DefaultSpringUnitTest<Publicacao> {
	
	private Publicacao publicacao;
	
	@BeforeEach
	void initClazz() {
		publicacao = Publicacao.builder()
				.build();
	}
	
	@Test
	void deveRetornarErroCampoDescricaoMaximo() {
		publicacao.setDescricao("a".repeat(300));
		assertThrows(ValidationException.class, () -> saveForError(publicacao));
	}
	
	@Test
	void deveRetornarErroCampoFotoMaximo() {
		publicacao.setFoto("f".repeat(100));
		assertThrows(ValidationException.class, () -> saveForError(publicacao));
	}
	
	@Test
	void deveRetornarErroCampoComplementoMaximo() {
		publicacao.setComplemento("c".repeat(46));
		assertThrows(ValidationException.class, () -> saveForError(publicacao));
		
		publicacao.setComplemento("c".repeat(100));
		assertThrows(ValidationException.class, () -> saveForError(publicacao));
	}
	
	@Test
	void naoDeveRetornarErroCompoComplemento() {
		publicacao.setComplemento("c".repeat(45));
		assertDoesNotThrow(() -> saveForError(publicacao));
	}
}
