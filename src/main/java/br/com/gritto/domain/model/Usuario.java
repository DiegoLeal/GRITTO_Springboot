package br.com.gritto.domain.model;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonView;

import br.com.gritto.config.view.Views;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@Builder
public class Usuario implements UserDetails {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonView({ Views.List.class, Views.CatServico.class })
	private Long id;
	
	@NotBlank
	@Size(max = 60)
	@JsonView({ Views.List.class, Views.CatServico.class })
	private String nome;	
	
	@NotBlank
	@Size(max = 20)
	private String rg;
	
	@NotBlank
	@CPF
	@Size(max = 14)
	private String cpf;
	
	//@NotBlank
	//@Size(max = 11)
	private LocalDate dataNascimento;
	
	@NotBlank
	@Size(max = 20)
	private String telefone;
	
	@NotBlank
	@Size(max = 60)
	private String senha;
	
	@NotBlank
	@Email
	@Size(max = 255)
	@JsonView({ Views.List.class })
	private String email;
	
	@NotBlank
	@Size(max = 1)
	private String sexo;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Collections.<GrantedAuthority>singletonList(new SimpleGrantedAuthority("User"));
	}

	@Override
	public String getPassword() {
		return getSenha();
	}

	@Override
	public String getUsername() {
		return getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}