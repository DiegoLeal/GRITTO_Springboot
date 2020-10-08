package br.com.gritto.gritto4.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.gritto.gritto4.domain.Usuario;
import br.com.gritto.gritto4.repository.UsuarioRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public void run(String... args) throws Exception {
		
		usuarioRepository.deleteAll();
		
		Usuario vicente = new Usuario(null, "Vicente Santos", "25.791.644-1", "573.849.058-42", "(1969-01-17)", "(16) 98262-7375", "rRTDKtCOP3", "vicentesantos@gmail.com", "M");
		Usuario vitoria = new Usuario(null, "Vitoria Silveira", "22.610.093-5", "699.620.573-53", "(1966-06-14)", "(95) 99245-1738", "3Z0oLGgMiH", "vitoriasilveira@skapcom.com", "F");
		Usuario mario = new Usuario(null, "Mario Ramos", "42.710.494-4", "271.306.590-92", "(1988-05-04)", "(98) 98711-7276", "h7bsWba3Wd", "marioramos@gmail.com", "M");
		
		usuarioRepository.saveAll(Arrays.asList(vicente, vitoria, mario));		
	}
}
