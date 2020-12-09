package br.com.gritto.gritto4.unit.usuario;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.validation.ValidationException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.gritto.domain.model.Usuario;
import br.com.gritto.gritto4.DefaultSpringUnitTest;

class UsuarioTest extends DefaultSpringUnitTest<Usuario> {
	
	private Usuario usuario;

	@BeforeEach
	void initClazz() {
		usuario = Usuario.builder()
				.build();
	}
	
	@Test
	void erroAoSalvarCampoNomeEmBranco() {
		usuario.setNome("");
		assertThrows(ValidationException.class, () -> saveForError(usuario));
	}
	
	@Test
	void retornaErroAoExcederQuantidadeMaximaCaracteresCampoNome() {
		usuario.setNome("n".repeat(61));
		assertThrows(ValidationException.class, () -> saveForError(usuario));
	}
	
	@Test
	void naoRetornarErroQuantidadeEspecificadaCaracteresCampoNome() {
		usuario.setNome("n".repeat(60));
		assertDoesNotThrow(() -> saveForError(usuario));
	}
	
	@Test
	void erroAoSalvarCampoRgEmBranco() {
		usuario.setRg("");
		assertThrows(ValidationException.class, () -> saveForError(usuario));
	}
	
	@Test
	void retornaErroAoExcederQuantidadeMaximaCaracteresCampoRg() {
		usuario.setRg("r".repeat(21));
		assertThrows(ValidationException.class, () -> saveForError(usuario));
	}	
	
	@Test
	void naoRetornarErroQuantidadeEspecificadaCaracteresCampoRg() {
		usuario.setRg("r".repeat(19));
		assertDoesNotThrow(() -> saveForError(usuario));
	}
	
	@Test
	void erroAoSalvarCampoCpfEmBranco() {
		usuario.setCpf("");
		assertThrows(ValidationException.class, () -> saveForError(usuario));
	}
	
	@Test
	void retornaErroAoExcederQuantidadeMaximaCaracteresCampoCpf() {
		usuario.setCpf("c".repeat(15));
		assertThrows(ValidationException.class, () -> saveForError(usuario));
	}	
	
	@Test
	void naoRetornarErroQuantidadeEspecificadaCaracteresCampoCpf() {
		usuario.setCpf("c".repeat(14));
		assertDoesNotThrow(() -> saveForError(usuario));
	}
	
	@Test
	void erroAoSalvarCampoTelefoneEmBranco() {
		usuario.setTelefone("");
		assertThrows(ValidationException.class, () -> saveForError(usuario));
	}
	
	@Test
	void retornaErroAoExcederQuantidadeMaximaCaracteresCampoTelefone() {
		usuario.setTelefone("c".repeat(21));
		assertThrows(ValidationException.class, () -> saveForError(usuario));
	}	
	
	@Test
	void naoRetornarErroQuantidadeEspecificadaCaracteresCampotelefone() {
		usuario.setTelefone("c".repeat(20));
		assertDoesNotThrow(() -> saveForError(usuario));
	}
	
	@Test
	void erroAoSalvarCampoSenhaEmBranco() {
		usuario.setSenha("");
		assertThrows(ValidationException.class, () -> saveForError(usuario));
	}
	
	@Test
	void retornaErroAoExcederQuantidadeMaximaCaracteresCampoSenha() {
		usuario.setSenha("s".repeat(61));
		assertThrows(ValidationException.class, () -> saveForError(usuario));
	}	
	
	@Test
	void naoRetornarErroQuantidadeEspecificadaCaracteresCampoSenha() {
		usuario.setSenha("s".repeat(60));
		assertDoesNotThrow(() -> saveForError(usuario));
	}

	@Test
	void erroAoSalvarCampoEmailEmBranco() {
		usuario.setEmail("");
		assertThrows(ValidationException.class, () -> saveForError(usuario));
	}
	
	@Test
	void retornaErroAoExcederQuantidadeMaximaCaracteresCampoEmail() {
		usuario.setEmail("e".repeat(256));
		assertThrows(ValidationException.class, () -> saveForError(usuario));
	}	
	
	@Test
	void naoRetornarErroQuantidadeEspecificadaCaracteresCampoEmail() {
		usuario.setEmail("e".repeat(255));
		assertDoesNotThrow(() -> saveForError(usuario));
	}

	@Test
	void erroAoSalvarCampoSexoEmBranco() {
		usuario.setSexo("");
		assertThrows(ValidationException.class, () -> saveForError(usuario));
	}
	
	@Test
	void retornaErroAoExcederQuantidadeMaximaCaracteresCampoSexo() {
		usuario.setSexo("s".repeat(2));
		assertThrows(ValidationException.class, () -> saveForError(usuario));
	}	
	
	@Test
	void naoRetornarErroQuantidadeEspecificadaCaracteresCampoSexo() {
		usuario.setSexo("s".repeat(1));
		assertDoesNotThrow(() -> saveForError(usuario));
	}
}
